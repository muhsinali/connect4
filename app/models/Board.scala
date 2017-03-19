package models

import models.Disc._


class Board {
  val board: Array[Array[Disc]] = {
    val array = Array.ofDim[Disc](Board.NUM_ROWS, Board.NUM_COLUMNS)
    for{
      r <- 0 until Board.NUM_ROWS
      c <- 0 until Board.NUM_COLUMNS
    } array(r)(c) = Disc.EMPTY
    array
  }

  def getDisc(row: Int, col: Int): Disc = board(row)(col)

  def isColumnFull(col: Int): Boolean = {
    for(r <- Board.NUM_ROWS - 1 to 0 by -1){
      if(board(r)(col) == Disc.EMPTY) return false
    }
    true
  }

  def isPositionOccupied(row: Int, col: Int): Boolean = board(row)(col) != Disc.EMPTY

  def placeDisc(col: Int, disc: Disc): Boolean = {
    for(r <- 0 until Board.NUM_ROWS){
      if(board(r)(col) == Disc.EMPTY){
        board(r)(col) = disc
        return true
      }
    }

    false
  }
}



object Board {
  val NUM_COLUMNS = 7
  val NUM_ROWS = 6
}
