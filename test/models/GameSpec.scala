package models

import org.scalatest.{FlatSpec, Matchers}


class GameSpec extends FlatSpec with Matchers {
  "Game#nextPlayer" should "return a reference to the other player" in {
    val game = new Game
    game.currentPlayer should equal (game.p1)
    game.nextPlayer()
    game.currentPlayer should equal (game.p2)
    game.nextPlayer()
    game.currentPlayer should equal (game.p1)
  }
}
