
var answer = ""

fun main() {
    val game = TicTacToeGame()
    game.printGameBoard()
    while (!game.isGameOver) {
        game.takeTurns()

        var row: Int? = -1
        var col: Int? = -1

        var validMove: Boolean = false
        while (!validMove) {
            try {
                print("Enter row number: ")
                row = readlnOrNull()?.toInt()
                print("Enter column number: ")
                col = readlnOrNull()?.toInt()

                if (row != null && col != null
                    && game.isValidMove(row, col)) {
                    validMove = true
                    game.placePiece(row, col)
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

        if (game.isGameOver) {
            println("New game? Type 'yes' or 'no'")
            val answer: String? = readlnOrNull()
            if (answer != null) {
                if (isPlayingAgain(answer)) {
                    game.resetGame()
                    game.printGameBoard()
                } else {
                    println("Exiting game...")
                }
            }
        }
    }
}



fun isPlayingAgain(answer: String): Boolean {
    return (answer.equals("y", ignoreCase = true) || answer.equals("yes", ignoreCase = true))
}