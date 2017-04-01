package models

/*
* Game is a specific instance of a game of connect 4.
*
* It contains a grid to place discs in and two instance of the Player class.
*
* */
class Game {
  val grid = new Grid
  val p1 = new Player("Player 1", Disc.RED)
  val p2 = new Player("Player 2", Disc.YELLOW)
  var currentPlayer: Player = p1


  def hasBeenWon: Boolean = WinCondition.hasGameBeenWon(grid, currentPlayer.disc)

  def nextPlayer(): Unit = {currentPlayer = if(currentPlayer == p1) p2 else p1}

  def placeDisc(col: Int): Boolean = grid.placeDisc(col, currentPlayer.disc)
}
