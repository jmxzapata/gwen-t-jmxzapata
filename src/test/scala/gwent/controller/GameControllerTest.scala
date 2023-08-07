package scala.gwent.controller


import munit.FunSuite

import scala.collection.mutable.ListBuffer
import scala.gwent.model.board.BoardSection
import scala.gwent.model.board.zone.WeatherZone
import scala.gwent.model.cards.{Deck, ICard}
import scala.gwent.model.cards.unity.CloseCombatCard
import scala.gwent.model.cards.unity.effects.{IEffectCard, NullEffect}
import scala.gwent.model.player.{Hand, Player}

/**
 * A test suite for the `GameController` class.
 *
 * This test suite contains multiple test cases to verify the correctness of the `GameController` class
 * and its associated functionality.
 */
class GameControllerTest extends FunSuite {

  /**
   * Test whether the `hasCardsToPlay` method works correctly when there are cards in the hand.
   *
   * This test verifies that the `hasCardsToPlay` method returns `true` when there are cards in the player's hand.
   */
  test("Test hasCardsToPlay with cards") {
    // Test setup
    val hand: Hand = new Hand()
    val effect: IEffectCard = new NullEffect()
    val card: ICard = new CloseCombatCard("Card", "Description", 10, effect)
    hand.cards += card

    // Test execution and assertion
    assert(hand.hasCardsToPlay)
  }

  /**
   * Test whether the `hasCardsToPlay` method works correctly when there are no cards in the hand.
   *
   * This test verifies that the `hasCardsToPlay` method returns `false` when there are no cards in the player's hand.
   */
  test("Test hasCardsToPlay without cards") {
    // Test setup
    val hand: Hand = new Hand()

    // Test execution and assertion
    assert(!hand.hasCardsToPlay)
  }

  /**
   * Test whether the `calculateTotalStrength` method calculates the total strength of the hand correctly.
   *
   * This test verifies that the `calculateTotalStrength` method correctly calculates the sum of the strengths
   * of all cards in the player's hand.
   */
  test("Test calculateTotalStrength") {
    // Test setup
    val hand: Hand = new Hand()
    val card1: ICard = new CloseCombatCard("Card1", "Description1", 10, new NullEffect())
    val card2: ICard = new CloseCombatCard("Card2", "Description2", 20, new NullEffect())
    hand.cards += card1
    hand.cards += card2

    // Test execution and assertion
    assert(hand.calculateTotalStrength == 30)
  }
}
