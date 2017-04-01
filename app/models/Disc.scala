package models

/*
* Disc enumerates all the different possible types of discs that could be placed in a Grid
*
* */
object Disc extends Enumeration {
  type Disc = Value
  val EMPTY, RED, YELLOW = Value
}
