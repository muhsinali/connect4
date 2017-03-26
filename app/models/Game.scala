package models

class Game {
  val grid = new Grid

  // Test configuration
  grid.placeDisc(1, Disc.RED)
  grid.placeDisc(1, Disc.YELLOW)
  grid.placeDisc(5, Disc.YELLOW)
}
