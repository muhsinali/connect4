package models

import models.Disc.Disc
import org.scalatest.{FlatSpec, Matchers}


class WinConditionSpec extends FlatSpec with Matchers {
  "WinCondition" should "correctly determine if there are 4 consecutive identical discs in a vertical row" in {
    val disc: Disc = Disc.RED
    val grid = new Grid
    WinCondition.verticalWin(grid, disc) should be (false)
    for(_ <- 0 until 4){
      grid.placeDisc(1, disc)
    }
    WinCondition.verticalWin(grid, disc) should be (true)
  }

  it should "determine if there are 4 consecutive identical discs in a horizontal row" in {
    val disc = Disc.YELLOW
    val grid = new Grid
    WinCondition.horizontalWin(grid, disc) should be (false)
    for(i <- 0 until 4){
      grid.placeDisc(i, disc)
    }
    WinCondition.horizontalWin(grid, disc) should be (true)
  }

  it should "determine if there are 4 consecutive identical discs arranged in a left diagonal manner" in {
    val disc = Disc.RED
    val other = Disc.YELLOW
    val grid = new Grid
    WinCondition.leftDiagonalWin(grid, disc) should be (false)
    for(c <- 0 until WinCondition.NUM_CONSECUTIVE){
      for(_ <- 3 - c until 0 by -1){
        grid.placeDisc(c, other)
      }
      grid.placeDisc(c, disc)
    }
    WinCondition.leftDiagonalWin(grid, disc) should be (true)
  }

  it should "determine if there are 4 consecutive identical discs arranged in a right diagonal manner" in {
    val disc = Disc.RED
    val other = Disc.YELLOW
    val grid = new Grid
    WinCondition.rightDiagonalWin(grid, disc) should be (false)
    for(c <- 0 until WinCondition.NUM_CONSECUTIVE){
      for(_ <- 0 until c){
        grid.placeDisc(c, other)
      }
      grid.placeDisc(c, disc)
    }
    WinCondition.rightDiagonalWin(grid, disc) should be (true)
  }
}
