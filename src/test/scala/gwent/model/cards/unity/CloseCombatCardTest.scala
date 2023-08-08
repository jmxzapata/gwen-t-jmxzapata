package scala.gwent.model.cards.unity

import munit.FunSuite

import scala.gwent.model.cards.weather.BitingFrostEffect

class CloseCombatCardTest extends FunSuite {
  /**
   * Test case for the 'affectedByBitingFrost' method of the CloseCombatCard.
   */
  test("Test affectedByBitingFrost") {
    // Create a CloseCombatCard with initial strength 10 and no effect
    val card: CloseCombatCard = new CloseCombatCard("CardName", "CardDescription", 10, null)

    // Create a BitingFrostEffect
    val weatherCard: BitingFrostEffect = new BitingFrostEffect("Biting Frost", "Description")

    // Assert that the initial strength is 10
    assert(card.currentStrength == 10)

    // Call the 'affectedByBitingFrost' method on the card passing the weatherCard as the parameter
    card.affectedByBitingFrost(weatherCard)

    // Assert that the card has been added as an observer to the weatherCard
    assert(weatherCard.getObservers.contains(card))

    // Assert that the current strength of the card has been affected by the weatherCard
    // In the case of BitingFrostEffect, the current strength of CloseCombatCard is set to 1
    assert(card.currentStrength == 1)
  }
}