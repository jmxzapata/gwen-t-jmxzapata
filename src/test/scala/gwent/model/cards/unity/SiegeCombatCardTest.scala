package scala.gwent.model.cards.unity

import munit.FunSuite

import scala.gwent.model.cards.weather.TorrentialRainEffect

class SiegeCombatCardTest extends FunSuite {

  /**
   * Test case for the 'affectedByTorrentialRain' method of the SiegeCombatCard.
   */
  test("Test affectedByTorrentialRain") {
    // Create a SiegeCombatCard with initial strength 10 and no effect
    val card: SiegeCombatCard = new SiegeCombatCard("CardName", "CardDescription", 10, null)

    // Create a TorrentialRainEffect
    val weatherCard: TorrentialRainEffect = new TorrentialRainEffect("Torrential Rain", "Description")

    // Assert that the initial strength is 10
    assert(card.currentStrength == 10)

    // Call the 'affectedByTorrentialRain' method on the card passing the weatherCard as the parameter
    card.affectedByTorrentialRain(weatherCard)

    // Assert that the card has been added as an observer to the weatherCard
    assert(weatherCard.getObservers.contains(card))

    // Assert that the current strength of the card has been affected by the weatherCard
    // In the case of TorrentialRainEffect, the current strength of SiegeCombatCard is set to 1
    assert(card.currentStrength == 1)
  }
}




