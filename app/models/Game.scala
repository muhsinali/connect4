package models

class Game {
  val grid = new Grid

  val p1 = new Player("Player 1", Disc.RED)
  val p2 = new Player("Player 2", Disc.YELLOW)
  var currentPlayer: Player = p1

  // Test configuration
  val disc = Disc.RED
  val other = Disc.YELLOW
  for(c <- 0 until WinCondition.NUM_CONSECUTIVE){
    for(_ <- 0 until c){
      grid.placeDisc(c, other)
    }
    if(c != WinCondition.NUM_CONSECUTIVE - 1) grid.placeDisc(c, disc)
  }


  def hasGameBeenWon: Boolean = {
    WinCondition.hasGameBeenWon(grid, currentPlayer.disc)
  }

  def nextPlayer(): Unit = {
    currentPlayer = if(currentPlayer == p1)  p2 else p1
  }

  def placeDisc(col: Int): Boolean = {
    grid.placeDisc(col, currentPlayer.disc)
  }
}
