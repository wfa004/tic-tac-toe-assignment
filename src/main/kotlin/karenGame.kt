abstract class Game {
}

class GameBoard(var row: Int = 3, var column: Int = 3) {
    // sjekke om objektet blir init med en verdi over eller lik 3

    val board = listOf()
    for (i in 0..column) //row,column

}

class TicTacToeGame: Game()  {
    val board = GameBoard(3,3)

    init {
        printGameBoard()
    }
    fun checkRows() {
        //  skal returnere indeks til rad som har tre kolonner med samme
        //  spiller sitt merke.
        //Returnerer ‐1 dersom ingen det ikke finnes en slik rad (og dermed
        // fortsatt ingen vinner).
    }

    fun checkColumns() {
        //skal returnere indeks til kolonne som har tre rader med samme
        // spiller sitt merke. Returnerer ‐1 dersom ingen det ikke finnes en
        // slik kolonne (og dermed fortsatt ingen vinner).
    }

    fun checkDiagonals() {
        //skal returnere et nummer som representerer diagonal som har tre
        // kolonner med samme spiller sitt merke.
        // Returnerer ‐1 dersom det ikke finnes en slik diagonal (og dermed fortsatt ingen
        // vinner).
    }

    fun printGameBoard() {
        for (i in board.column)
        //skriver spillebrettet til skjerm med spillernes markeringer.
        // Skriv ut så enkelt som mulig, men likevel slik at man får et tydelig
        // inntrykk av cellene og spillernes markeringer.
        //Bruk O (stor bokstav o) for den ene spilleren og X
        // (stor bokstav x) for den andre spilleren.
    }

    fun isValidMove(row: Int, column: Int, player: Int) {
        //sjekker om aktuell posisjon ledig og kan markeres med spiller
        // sitt tegn. Dersom plass er opptatt eller ugyldig indeks skal det
        // gis en feilmelding.
    }
}

class Player(var name: String) {}

