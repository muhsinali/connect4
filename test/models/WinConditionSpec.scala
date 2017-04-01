package models

import org.scalatest.{FlatSpec, Matchers}


class WinConditionSpec extends FlatSpec with Matchers {
  val red = Disc.RED
  val yellow = Disc.YELLOW

  "WinCondition" should "correctly determine if there are 4 consecutive identical discs in a vertical row" in {
    val grid = new Grid
    WinCondition.verticalWin(grid, red) should be (false)
    for(_ <- 0 until 4){
      grid.placeDisc(1, red)
    }
    WinCondition.verticalWin(grid, red) should be (true)
  }

  it should "determine if there are 4 consecutive identical discs in a horizontal row" in {
    val grid = new Grid
    WinCondition.horizontalWin(grid, yellow) should be (false)
    for(i <- 0 until 4){
      grid.placeDisc(i, yellow)
    }
    WinCondition.horizontalWin(grid, yellow) should be (true)
  }

  it should "determine if there are 4 consecutive identical discs arranged in a left diagonal manner" in {
    val grid = new Grid
    WinCondition.leftDiagonalWin(grid, red) should be (false)
    for(c <- 0 until WinCondition.NUM_CONSECUTIVE){
      for(_ <- 3 - c until 0 by -1){
        grid.placeDisc(c, yellow)
      }
      grid.placeDisc(c, red)
    }
    WinCondition.leftDiagonalWin(grid, red) should be (true)
  }

  it should "determine if there are 4 consecutive identical discs arranged in a right diagonal manner" in {
    val grid = new Grid
    WinCondition.rightDiagonalWin(grid, red) should be (false)
    for(c <- 0 until WinCondition.NUM_CONSECUTIVE){
      for(_ <- 0 until c){
        grid.placeDisc(c, yellow)
      }
      grid.placeDisc(c, red)
    }
    WinCondition.rightDiagonalWin(grid, red) should be (true)
  }

  it should "determine if the game has not yet been won" in {
    val grid = new Grid

    // checks to see if WinCondition#horizontalWin and WinCondition#verticalWin don't attempt to read outside of grid
    grid.placeDisc(6, Disc.RED)

    WinCondition.hasGameBeenWon(grid, red) should be (false)
    WinCondition.hasGameBeenWon(grid, yellow) should be (false)
  }

  it should "determine if the game has been tied" in {
    val grid = new Grid

    // Create stalemate configuration
    // Column 0
    grid.placeDisc(0, yellow)
    grid.placeDisc(0, yellow)
    grid.placeDisc(0, red)
    grid.placeDisc(0, yellow)
    grid.placeDisc(0, red)
    grid.placeDisc(0, red)

    // Column 1
    grid.placeDisc(1, red)
    grid.placeDisc(1, yellow)
    grid.placeDisc(1, red)
    grid.placeDisc(1, yellow)
    grid.placeDisc(1, red)
    grid.placeDisc(1, yellow)

    // Column 2
    grid.placeDisc(2, red)
    grid.placeDisc(2, yellow)
    grid.placeDisc(2, yellow)
    grid.placeDisc(2, yellow)
    grid.placeDisc(2, red)
    grid.placeDisc(2, yellow)

    // Column 3
    grid.placeDisc(3, yellow)
    grid.placeDisc(3, red)
    grid.placeDisc(3, red)
    grid.placeDisc(3, red)
    grid.placeDisc(3, yellow)
    grid.placeDisc(3, red)

    // Column 4
    grid.placeDisc(4, red)
    grid.placeDisc(4, yellow)
    grid.placeDisc(4, red)
    grid.placeDisc(4, yellow)
    grid.placeDisc(4, red)
    grid.placeDisc(4, yellow)

    // Column 5
    grid.placeDisc(5, red)
    grid.placeDisc(5, yellow)
    grid.placeDisc(5, red)
    grid.placeDisc(5, yellow)
    grid.placeDisc(5, red)
    grid.placeDisc(5, yellow)

    // Column 6
    grid.placeDisc(6, red)
    grid.placeDisc(6, red)
    grid.placeDisc(6, yellow)
    grid.placeDisc(6, yellow)
    grid.placeDisc(6, yellow)
    grid.placeDisc(6, red)

    WinCondition.hasGameBeenTied(grid, red, yellow) should be (true)
  }

}
