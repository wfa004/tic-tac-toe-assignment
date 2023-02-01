abstract class Game {
    abstract fun checkRows(): Int
    abstract fun checkColumns(): Int
    abstract fun checkDiagonals(): Int
    abstract fun printGameBoard()
}

class GameBoard {
    private val gameBoard = Array(3) { Array(3) { " " } }

    fun getMarkAt(row: Int, column: Int) = gameBoard[row][column]
    fun setMarkAt(row: Int, column: Int, mark: Char) { gameBoard[row][column] = mark }
    }


class TicTacToeGame: Game() {
    private val gameBoard = GameBoard()

    override fun checkRows(): Int {
        for (i in gameBoard) {
            if (gameBoard[i][0] == gameBoard[i][1] && gameBoard[i][1] == gameBoard[i][2]) {
                return i
            }
        }
        return -1
    }

    override fun checkColumns(): Int {
        for (i in gameBoard) {
            if (gameBoard[0][i] == gameBoard[1][i] && gameBoard[1][i] == gameBoard[2][i]) {
                return i
            }
        }
        return -1
    }

    override fun checkDiagonals(): Int {
        if (gameBoard[0][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][2]) {
            return 1
        }
        if (gameBoard[0][2] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][0]) {
            return 2
        }
        return -1
    }

    override fun printGameBoard() {
        for (i in gameBoard) {
            for (j in gameBoard) {
                print(gameBoard[i][j])
                print(" ")
            }
            println()
        }
    }

    fun isValidMove(row: Int, column: Int, player: Int) {
        if (gameBoard[row][column] != " ") {
            return ("Denne boksen er opptatt. Prøv igjen!")
        }
    }
}

class Player(val symbol: String) {

}


fun main() {
    val player1 = Player("X")
    val player2 = Player("O")
    val game = TicTacToeGame()
    var currentPlayer = player1
    while (true) {
        println("Spiller ${currentPlayer.symbol} sin tur")
        println("Velg rad:")
