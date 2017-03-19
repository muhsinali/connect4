package models

import org.scalatest.{FlatSpec, Matchers}


class BoardSpec extends FlatSpec with Matchers {
  "Board#isColumnFull" should "return false if there are some empty positions remaining" in {
    val board: Board = new Board
    board.isColumnFull(1) should be (false)
  }

  "Board" should "allow player to place a disc in an empty column" in {
    val board: Board = new Board
    board.placeDisc(1, Disc.RED) should be (true)
    board.placeDisc(1, Disc.YELLOW) should be (true)

    board.isPositionOccupied(0, 1) should be (true)
    board.getDisc(0, 1) should be (Disc.RED)
    board.isPositionOccupied(1, 1) should be (true)
    board.getDisc(1, 1) should be (Disc.YELLOW)

    board.isColumnFull(1) should be (false)
  }

  it should "allow player to place a disc in a partially filled column" in {

  }

  it should "prevent player from placing a disc in a full column" in {

  }
}
