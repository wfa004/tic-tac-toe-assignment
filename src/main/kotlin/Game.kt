abstract class Game(
    open val size: Int,
    open val empty: String = "___",
) {
    open var moveCount = 0
    open var isGameOver = false
    open var gameBoard = GameBoard(size).boardAsArrays()


}