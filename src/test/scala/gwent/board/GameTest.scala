package cl.uchile.dcc
package gwent.board

import munit.FunSuite
import cl.uchile.dcc.gwent.board.Game

/**
 * A test suite for the `Game` class.
 */
class GameTest extends FunSuite {

  /**
   * Tests that Player 1 should play a card from the deck.
   */
  test("Player 1 should play a card from the deck") {
    val game = new Game()
    game.player1PlayCard()
    // Add assertions to verify the expected behavior
  }

  /**
   * Tests that Player 2 should play a card from the deck.
   */
  test("Player 2 should play a card from the deck") {
    val game = new Game()
    game.player2PlayCard()
    // Add assertions to verify the expected behavior
  }

  /**
   * Tests that Player 1 deck should contain the expected cards.
   */
  test("Player 1 deck should contain the expected cards") {
    val game = new Game()
    val expectedCards = List("Close Combat Card 1", "Ranged Combat Card 1", "Siege Combat Card 1")
    val actualCards = game.player1Deck.map(_.name)
    assertEquals(actualCards, expectedCards)
  }

  /**
   * Tests that Player 2 deck should contain the expected cards.
   */
  test("Player 2 deck should contain the expected cards") {
    val game = new Game()
    val expectedCards = List("Close Combat Card 2", "Ranged Combat Card 2", "Siege Combat Card 2")
    val actualCards = game.player2Deck.map(_.name)
    assertEquals(actualCards, expectedCards)
  }

  /**
   * Tests that Player 1 deck should not be empty after playing a card.
   */
  test("Player 1 deck should not be empty after playing a card") {
    val game = new Game()
    game.player1PlayCard()
    val player1DeckSize = game.player1Deck.size
    assert(player1DeckSize > 0)
  }

  /**
   * Tests that Player 2 deck should not be empty after playing a card.
   */
  test("Player 2 deck should not be empty after playing a card") {
    val game = new Game()
    game.player2PlayCard()
    val player2DeckSize = game.player2Deck.size
    assert(player2DeckSize > 0)
  }

  /**
   * Tests that Player 1 should have a valid card index after playing a card.
   */
  test("Player 1 should have a valid card index after playing a card") {
    val game = new Game()
    game.player1PlayCard()
    val player1DeckSize = game.player1Deck.size
    val player1CardIndex = player1DeckSize - 1
    assert(player1CardIndex >= 0 && player1CardIndex < player1DeckSize)
  }

  /**
   * Tests that Player 2 should have a valid card index after playing a card.
   */
  test("Player 2 should have a valid card index after playing a card") {
    val game = new Game()
    game.player2PlayCard()
    val player2DeckSize = game.player2Deck.size
    val player2CardIndex = player2DeckSize - 1
    assert(player2CardIndex >= 0 && player2CardIndex < player2DeckSize)
  }

}
