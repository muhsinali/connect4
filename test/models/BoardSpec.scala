package models

import org.scalatest.{FlatSpec, Matchers}


class BoardSpec extends FlatSpec with Matchers {

  "Board" should "allow player to place a disc in an empty column" in {
    val board = new Board
    board.placeDisc(1, Disc.RED) should be (true)
    board.placeDisc(1, Disc.YELLOW) should be (true)

    board.isPositionOccupied(0, 1) should be (true)
    board.getDisc(0, 1) should be (Disc.RED)
    board.isPositionOccupied(1, 1) should be (true)
    board.getDisc(1, 1) should be (Disc.YELLOW)

    board.isColumnFull(1) should be (false)
  }

  it should "prevent player from placing a disc in a full column" in {
    val board = new Board

    // Fill up column and do checks
    for(_ <- 0 until Board.NUM_ROWS){
      board.placeDisc(1, Disc.RED) should be (true)
    }
    for(r <- 0 until Board.NUM_ROWS){
      board.getDisc(r, 1) should be (Disc.RED)
      board.isPositionOccupied(r, 1) should be (true)
    }
    board.isColumnFull(1) should be (true)

    // Try to place a disc in the completely filled column
    board.placeDisc(1, Disc.RED) should be (false)
  }



}
