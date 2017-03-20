package models

import org.scalatest.{FlatSpec, Matchers}


class GridSpec extends FlatSpec with Matchers {

  "Grid" should "allow player to place a disc in an empty column" in {
    val grid = new Grid
    grid.placeDisc(1, Disc.RED) should be (true)
    grid.placeDisc(1, Disc.YELLOW) should be (true)

    grid.isPositionOccupied(Grid.NUM_ROWS - 1, 1) should be (true)
    grid.getDisc(Grid.NUM_ROWS - 1, 1) should be (Disc.RED)
    grid.isPositionOccupied(Grid.NUM_ROWS - 2, 1) should be (true)
    grid.getDisc(Grid.NUM_ROWS - 2, 1) should be (Disc.YELLOW)

    grid.isColumnFull(1) should be (false)
  }

  it should "prevent player from placing a disc in a full column" in {
    val grid = new Grid

    // Completely fill up column
    for(_ <- 0 until Grid.NUM_ROWS){
      grid.placeDisc(1, Disc.RED) should be (true)
    }
    // Verify that column is full
    for(r <- Grid.NUM_ROWS - 1 to 0 by -1){
      grid.getDisc(r, 1) should be (Disc.RED)
      grid.isPositionOccupied(r, 1) should be (true)
    }
    grid.isColumnFull(1) should be (true)

    // Try to place a disc in the completely filled column
    grid.placeDisc(1, Disc.RED) should be (false)
  }



}
