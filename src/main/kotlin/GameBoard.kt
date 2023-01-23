import kotlin.math.pow

class GameBoard(private val size: Int) {
    private val empty = "___"
    private var board = Array(size) { Array(size) { empty } }

    fun boardAsArrays(): Array<Array<String>> {
        return board
    }






}

