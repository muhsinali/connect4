package models

import models.Disc.Disc


/*
* WinCondition contains all the different ways that a connect 4 game could be won or be tied.
*
* Essentially, the following configurations of discs with the same colour are searched for within a grid. If one such
* configuration is found, it is said that the game has been won.
*
* Horizontal:
*   X X X X
*
* Vertical:
*   X
*   X
*   X
*   X
*
* Left diagonal:
*   X
*     X
*       X
*         X
*
* Right diagonal:
*         X
*       X
*     X
*   X
*
* */

object WinCondition {
  // Number of consecutive discs required for game to be won
  val NUM_CONSECUTIVE = 4

  def hasGameBeenWon(grid: Grid, disc: Disc): Boolean = {
    horizontalWin(grid, disc) || verticalWin(grid, disc) || leftDiagonalWin(grid, disc) || rightDiagonalWin(grid, disc)
  }

  def hasGameBeenTied(grid: Grid, disc: Disc, other: Disc): Boolean = {
    grid.isFull && !hasGameBeenWon(grid, disc) && !hasGameBeenWon(grid, other)
  }

  // This is exposed to make it testable
  def horizontalWin(grid: Grid, disc: Disc): Boolean = {
    (0 until Grid.NUM_ROWS).exists(r => horizontalWinInRow(grid, r, disc))
  }

  // This is exposed to make it testable
  def verticalWin(grid: Grid, disc: Disc): Boolean = {
    (0 until Grid.NUM_COLUMNS).exists(c => verticalWinInColumn(grid, c, disc))
  }

  // This is exposed to make it testable
  def leftDiagonalWin(grid: Grid, disc: Disc): Boolean = {
    for {
      r <- 0 to Grid.NUM_ROWS - NUM_CONSECUTIVE
      c <- 0 to Grid.NUM_COLUMNS - NUM_CONSECUTIVE
      if leftDiagonalFourInARow(grid, r, c, disc)
    } return true

    false
  }

  // This is exposed to make it testable
  def rightDiagonalWin(grid: Grid, disc: Disc): Boolean = {
    for {
      r <- 0 to Grid.NUM_ROWS - NUM_CONSECUTIVE
      c <- Grid.NUM_COLUMNS - 1 to NUM_CONSECUTIVE - 1 by -1
      if rightDiagonalFourInARow(grid, r, c, disc)
    } return true

    false
  }



  private def horizontalFourInARow(grid: Grid, row: Int, startCol: Int, disc: Disc): Boolean = {
    (0 until NUM_CONSECUTIVE).forall(i => grid.getDisc(row, startCol + i) == disc)
  }

  private def horizontalWinInRow(grid: Grid, row: Int, disc: Disc): Boolean = {
    (0 to Grid.NUM_COLUMNS - NUM_CONSECUTIVE).exists(c => horizontalFourInARow(grid: Grid, row, c, disc))
  }

  private def verticalFourInARow(grid: Grid, startRow: Int, col: Int, disc: Disc): Boolean = {
    (0 until NUM_CONSECUTIVE).forall(i => grid.getDisc(startRow + i, col) == disc)
  }

  private def verticalWinInColumn(grid: Grid, col: Int, disc: Disc): Boolean = {
    (0 to Grid.NUM_ROWS - NUM_CONSECUTIVE).exists(r => verticalFourInARow(grid: Grid, r, col, disc))
  }

  private def leftDiagonalFourInARow(grid: Grid, startRow: Int, startCol: Int, disc: Disc): Boolean = {
    (0 until NUM_CONSECUTIVE).forall(i => grid.getDisc(startRow + i, startCol + i) == disc)
  }

  private def rightDiagonalFourInARow(grid: Grid, startRow: Int, startCol: Int, disc: Disc): Boolean = {
    (0 until NUM_CONSECUTIVE).forall(i => grid.getDisc(startRow + i, startCol - i) == disc)
  }

}
