package scala.gwent.model.player

import munit.FunSuite

import scala.gwent.model.cards.ICard
import scala.gwent.model.cards.unity.{CloseCombatCard, RangedCombatCard, SiegeCombatCard}

class HandTest extends FunSuite {
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

  test("Test hasCardsToPlay with cards") {
    val hand: Hand = new Hand()
    val card: ICard = new CloseCombatCard("Card", "Description", 10, null)

    hand.cards += card

    assertEquals(hand.hasCardsToPlay, true)
  }

  test("Test hasCardsToPlay without cards") {
    val hand: Hand = new Hand()

    assertEquals(hand.hasCardsToPlay, false)
  }

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