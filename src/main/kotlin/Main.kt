val player1 = Player("X").mark()
val player2 = Player("O").mark()
var currentPlayer = Player("").mark()
var answer = ""

fun main() {
    val game = TicTacToeGame()
    game.printGameBoard()
    while (!game.isGameOver) {
        takeTurns()
        println("$currentPlayer's turn")
        print("Enter row number: ")
        val row: Int? = readlnOrNull()?.toInt()
        print("Enter column number: ")
        val col: Int? = readlnOrNull()?.toInt()
        if (row != null && col != null) {
            game.placePiece(row, col, currentPlayer)
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

fun takeTurns() {
    currentPlayer = if (player1 == currentPlayer) {
        player2
    } else {
        player1
    }
}

fun isPlayingAgain(answer: String): Boolean {
    return (answer.equals("y", ignoreCase = true) || answer.equals("yes", ignoreCase = true))
}