package scala.gwent.model.board

import munit.FunSuite

import scala.gwent.model.cards.ICard
import scala.gwent.model.cards.weather.{BitingFrostEffect, IWeatherCard}
import scala.gwent.model.player.Player
import scala.gwent.model.board.{Board, BoardSection}
class BoardTest extends FunSuite {
  /**
   * TestPlayer class used for testing purposes, extending the Player class.
   * In a real implementation, this class would have more functionalities.
   */
  class TestPlayer extends Player("Test Player") {
    // Implement any additional functionalities specific to the TestPlayer class, if needed.
  }

  /**
   * Test case for the 'postInit' method of the Board class.
   */
  test("Test postInit") {
    // Create two TestPlayer instances
    val player1 = new TestPlayer()
    val player2 = new TestPlayer()

    // Create a new Board with the two TestPlayer instances
    val board = new Board(player1, player2)

    // Call the 'postInit' method on the Board
    board.postInit()

    // Verify that the 'boardSection' field of player1 is set to 'player1Section' of the Board
    assert(player1.boardSection == board.player1Section)

    // Verify that the 'boardSection' field of player2 is set to 'player2Section' of the Board
    assert(player2.boardSection == board.player2Section)
  }
  
}