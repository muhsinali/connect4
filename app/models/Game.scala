package models

class Game {
  val grid = new Grid

  val p1 = new Player("Player 1", Disc.RED)
  val p2 = new Player("Player 2", Disc.YELLOW)
  var currentPlayer: Player = p1

  // Test configuration
  grid.placeDisc(1, Disc.RED)
  grid.placeDisc(1, Disc.YELLOW)
  grid.placeDisc(5, Disc.YELLOW)


  def placeDisc(col: Int): Boolean = {
    val result = grid.placeDisc(col, currentPlayer.disc)
    if(!result){
      return false
    }
    nextPlayer()
    result
  }

  private def nextPlayer(): Unit = {
    currentPlayer = if(currentPlayer == p1)  p2 else p1
  }
}
