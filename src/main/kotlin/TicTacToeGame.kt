import kotlin.math.pow

class TicTacToeGame() {

    private var size = 3
    private val empty = "___"
    private var moveCount = 0
    var isGameOver = false
    private var gameBoard = GameBoard(size).boardAsArrays()

    private fun checkRows(x: Int, y: Int, piece: String): Int {
        for (i in 0 until size) {
            if (gameBoard[x][i] != piece) {
                break
            }
            if (i == size - 1) {
                return x
            }
        }
        return -1
    }

    private fun checkColumns(x: Int, y: Int, piece: String): Int {
        for (i in 0 until size) {
            if (gameBoard[i][y] != piece) {
                break
            }
            if (i == size - 1) {
                return y
            }
        }
        return -1
    }


    private fun checkDiagonals(x: Int, y: Int, piece: String): Int {
        //check diagonal
        if (x == y) {
            for (i in 0 until size) {
                if (gameBoard[i][i] != piece) {
                    break
                }
                if (i == size - 1) {
                    // represents diagonal 1
                    return 1
                }
            }
        }
        //check anti diagonal
        if (x + y == size - 1) {
            for (i in 0 until size) {
                if (gameBoard[i][(size - 1)] != piece) {
                    break
                }
                if (i == size - 1) {
                    // represents diagonal 2
                    return 2
                }
            }
        }
        return -1
    }

    fun printGameBoard() {
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

    fun placePiece(x: Int, y: Int, piece: String) {
        if (!isGameOver) {
            moveCount++
            gameBoard[x][y] = piece
            printGameBoard()
            isGameOver =
                checkRows(x, y, piece) != -1 || checkColumns(x, y, piece) != -1 || checkDiagonals(x, y, piece) != -1 || isDraw()
            if (isGameOver && !isDraw()) {
                println("We have a winner!")
            } else if (isDraw()) {
                println("Draw!")
            }
        } else if (gameBoard[x][y] != empty) {
            println("Position is already occupied")
    }
        }

    fun isValidMove(x: Int, y: Int): Boolean {
        return ((x in 0 until size) && (y in 0 until size) && (gameBoard[x][y] == empty))
    }

    private fun isDraw(): Boolean {
        return (moveCount == (size.toDouble().pow(2) - 1).toInt())
    }

    private fun resetBoard() {
        gameBoard = GameBoard(size).boardAsArrays()
    }

    fun resetGame() {
        resetBoard()
        isGameOver = false
        moveCount = 0
    }


//
//    fun isValidMove(row: Int, column: Int, player: Int)

}