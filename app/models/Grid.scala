package models

import models.Disc._


class Grid {
  val grid: Array[Array[Disc]] = {
    val array = Array.ofDim[Disc](Grid.NUM_ROWS, Grid.NUM_COLUMNS)
    for{
      r <- 0 until Grid.NUM_ROWS
      c <- 0 until Grid.NUM_COLUMNS
    } array(r)(c) = Disc.EMPTY
    array
  }

  // TODO check that row and col values provided are valid
  def getDisc(row: Int, col: Int): Disc = grid(row)(col)

  def isColumnFull(col: Int): Boolean = {
    for(r <- 0 until Grid.NUM_ROWS){
      if(!isPositionOccupied(r, col)) return false
    }
    true
  }

  // TODO check that row and col values provided are valid
  def isPositionOccupied(row: Int, col: Int): Boolean = grid(row)(col) != Disc.EMPTY

  // TODO check that col provided is valid
  def placeDisc(col: Int, disc: Disc): Boolean = {
    for(r <- Grid.NUM_ROWS - 1 to 0 by -1){
      if(!isPositionOccupied(r, col)){
        grid(r)(col) = disc
        return true
      }
    }
    false
  }
}



object Grid {
  val NUM_COLUMNS = 7
  val NUM_ROWS = 6
}
