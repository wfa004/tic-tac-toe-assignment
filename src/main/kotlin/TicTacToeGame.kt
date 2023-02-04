import kotlin.math.pow

class TicTacToeGame : Game(size = 3) {
    private val player1 = Player("X")
    private val player2 = Player("O")

    private var  currentPlayer = player1
    private var row: Int = -1
    private var col: Int = -1
    private var validMove: Boolean = false
    private var answer: String = ""

    init {
        startGame()
    }

    private fun startGame(){
        printGameBoard()
        while (!isGameOver) {
            validMove = false
            while (!validMove) {
                println("${currentPlayer.mark}'s turn")
                try {
                    print("Enter row number: ")
                    row = readln().toInt()
                    print("Enter column number: ")
                    col = readln().toInt()

                    if (isValidMove()) {
                        validMove = true
                        placePiece()
                        takeTurns()
                    }else {
                        println("Invalid position")
                        println("Try again!")
                        continue
                    }
                } catch (e: NumberFormatException) {
                    println("You did not enter a number")
                    println("Try again!")
                }

            }

            if (isGameOver) {
                println("New game? Type 'yes' or 'no'")
                answer = readln()
                val isPlayingAgain = { answer: String ->
                    answer.lowercase() in listOf("yes", "y")
                }
                if (isPlayingAgain(answer)) {
                    resetGame()
                    printGameBoard()
                } else {
                    println("Exiting game...")
                }
            }
        }
    }

    private fun takeTurns() {
        currentPlayer = if (currentPlayer == player1) {
            player2
        } else {
            player1
        }
    }
    private fun checkRows(): Int {
        for (i in 0 until size) {
            if (gameBoard[row][i] != currentPlayer.mark) {
                break
            }
            if (i == size - 1) {
                return row
            }
        }
        return -1
    }

    private fun checkColumns(): Int {
        for (i in 0 until size) {
            if (gameBoard[i][col] != currentPlayer.mark) {
                break
            }
            if (i == size - 1) {
                return col
            }
        }
        return -1
    }


    private fun checkDiagonals(): Int {
        //check diagonal
        if (row == col) {
            for (i in 0 until size) {
                if (gameBoard[i][i] != currentPlayer.mark) {
                    break
                }
                if (i == size - 1) {
                    // represents diagonal 1
                    return 1
                }
            }
        } ;return -1
    }

    private fun checkDiagonals2(): Int {
        // check the other diagonal
        if (row == size - col - 1) {
            for (i in 0 until size) {
                if (gameBoard[i][size - i - 1] != currentPlayer.mark) {
                    break
                }
                if (i == size - 1) {
                    // represents diagonal 2
                    return 2
                }
            }
        } ;return -1
    }

    private fun printGameBoard() {
        println("  0    1    2")
        var colNr = 0
        gameBoard.forEach { row ->
            row.forEach { element ->
                if (element == empty) {
                    print("|$element|")
                } else {
                    print("| $element |")

                }
            }
            println("$colNr")
            colNr += 1
            println()
        }
        println()
    }

    private fun placePiece() {
        if (!isGameOver) {
            moveCount++
            gameBoard[row][col] = currentPlayer.mark
            printGameBoard()
            isGameOver =
                checkRows() != -1 || checkColumns() != -1 || checkDiagonals() != -1 || checkDiagonals2() != -1 || isDraw()
            if (isGameOver && !isDraw()) {
                println("We have a winner!")
                println("${currentPlayer.mark} is the winner!")
            } else if (isDraw()) {
                println("Draw!")
            }
        } else if (gameBoard[row][col] != empty) {
            println("Position is already occupied")
    }
        }

    private fun isValidMove(): Boolean {
        return ((row in 0 until size) && (col in 0 until size) && (gameBoard[row][col] == empty))
    }

    private fun isDraw(): Boolean {
        return (moveCount == (size.toDouble().pow(2) - 1).toInt())
    }

    private fun resetBoard() {
        gameBoard = GameBoard(size).boardAsArrays()
    }

    private fun resetGame() {
        resetBoard()
        isGameOver = false
        moveCount = 0
        validMove = false
        currentPlayer = player1
    }
}