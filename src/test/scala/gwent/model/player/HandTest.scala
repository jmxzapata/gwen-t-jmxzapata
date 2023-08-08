package scala.gwent.model.player

import munit.FunSuite

import scala.gwent.model.cards.ICard
import scala.gwent.model.cards.unity.{CloseCombatCard, RangedCombatCard, SiegeCombatCard}

/**
 * The `HandTest` class contains test cases to verify the behavior of the `Hand` class in the GWENT game. It focuses on
 * testing methods related to hand management, card calculation, and card availability within the hand.
 */
class HandTest extends FunSuite {

  /**
   * This test checks whether the `calculateTotalStrength` method of the `Hand` class correctly calculates the total strength
   * of the cards present in the hand. It creates a hand with three cards of varying strengths and verifies if the calculated
   * total strength matches the expected value.
   */
  test("Test calculateTotalStrength") {
    val hand: Hand = new Hand()
    val card1: ICard = new CloseCombatCard("Card1", "Description1", 5, null)
    val card2: ICard = new RangedCombatCard("Card2", "Description2", 8, null)
    val card3: ICard = new SiegeCombatCard("Card3", "Description3", 3, null)

    hand.cards += card1
    hand.cards += card2
    hand.cards += card3

    val expectedTotalStrength: Int = card1.strength + card2.strength + card3.strength

    assertEquals(hand.calculateTotalStrength, expectedTotalStrength)
  }

  /**
   * This test ensures that the `hasCardsToPlay` method of the `Hand` class returns `true` when there are cards available
   * in the hand.
   */
  test("Test hasCardsToPlay with cards") {
    val hand: Hand = new Hand()
    val card: ICard = new CloseCombatCard("Card", "Description", 10, null)

    hand.cards += card

    assertEquals(hand.hasCardsToPlay, true)
  }

  /**
   * This test checks whether the `hasCardsToPlay` method of the `Hand` class returns `false` when the hand is empty.
   */
  test("Test hasCardsToPlay without cards") {
    val hand: Hand = new Hand()

    assertEquals(hand.hasCardsToPlay, false)
  }

  /**
   * This test ensures that the `toString` method of the `Hand` class produces the expected string representation of the hand
   * object, including the list of cards present in the hand.
   */
  test("Test toString") {
    val hand: Hand = new Hand()
    val card1: ICard = new CloseCombatCard("Card1", "Description1", 5, null)
    val card2: ICard = new RangedCombatCard("Card2", "Description2", 8, null)

    hand.cards += card1
    hand.cards += card2

    val expectedString: String = s"Hand(cards=${hand.cards})"

    assertEquals(hand.toString, expectedString)
  }
}