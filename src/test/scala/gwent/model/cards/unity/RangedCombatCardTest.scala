package scala.gwent.model.cards.unity

import munit.FunSuite

import scala.gwent.model.cards.weather.ImpenetrableFogEffect

class RangedCombatCardTest extends FunSuite {
  /**
   * Test case for the 'affectedByImpenetrableFog' method of the RangedCombatCard.
   */
  test("Test affectedByImpenetrableFog") {
    // Create a RangedCombatCard with initial strength 10 and no effect
    val card: RangedCombatCard = new RangedCombatCard("CardName", "CardDescription", 10, null)

    // Create an ImpenetrableFogEffect
    val weatherCard: ImpenetrableFogEffect = new ImpenetrableFogEffect("Impenetrable Fog", "Description")

    // Assert that the initial strength is 10
    assert(card.currentStrength == 10)

    // Call the 'affectedByImpenetrableFog' method on the card passing the weatherCard as the parameter
    card.affectedByImpenetrableFog(weatherCard)

    // Assert that the card has been added as an observer to the weatherCard
    assert(weatherCard.getObservers.contains(card))

    // Assert that the current strength of the card has been affected by the weatherCard
    // In the case of ImpenetrableFogEffect, the current strength of RangedCombatCard is set to 1
    assert(card.currentStrength == 1)
  }
}