package scala.gwent.model.board

import munit.FunSuite

import scala.gwent.model.cards.ICard
import scala.gwent.model.cards.weather.{BitingFrostEffect, IWeatherCard}
import scala.gwent.model.player.Player
import scala.gwent.model.board.{Board, BoardSection}
class BoardTest extends FunSuite {
  class TestPlayer extends Player("Test Player") {
  }

  test("Test postInit") {
    val player1 = new TestPlayer()
    val player2 = new TestPlayer()
    val board = new Board(player1, player2)

    board.postInit()

    assert(player1.boardSection == board.player1Section)
    assert(player2.boardSection == board.player2Section)
  }
  
}