package models

import org.scalatest.{FlatSpec, Matchers}


class GridSpec extends FlatSpec with Matchers {
  val red = Disc.RED
  val yellow = Disc.YELLOW

  "Grid" should "allow player to place a disc in an empty column" in {
    val grid = new Grid
    grid.placeDisc(1, red) should be (true)
    grid.placeDisc(1, yellow) should be (true)

    grid.isPositionOccupied(Grid.NUM_ROWS - 1, 1) should be (true)
    grid.getDisc(Grid.NUM_ROWS - 1, 1) should be (red)
    grid.isPositionOccupied(Grid.NUM_ROWS - 2, 1) should be (true)
    grid.getDisc(Grid.NUM_ROWS - 2, 1) should be (yellow)

    grid.isColumnFull(1) should be (false)
  }

  it should "prevent player from placing a disc in a full column" in {
    val grid = new Grid

    // Completely fill up column
    for(_ <- 0 until Grid.NUM_ROWS){
      grid.placeDisc(1, red) should be (true)
    }
    // Verify that column is full
    grid.isColumnFull(1) should be (true)

    // Try to place a disc in the completely filled column
    grid.placeDisc(1, red) should be (false)
  }

  "Grid#isFull" should "return true when the grid is completely filled" in {
    val grid = new Grid
    for{
      r <- 0 until Grid.NUM_ROWS
      c <- 0 until Grid.NUM_COLUMNS
    }{
      grid.placeDisc(c, red)
    }
    grid.isFull should be (true)
  }



}
