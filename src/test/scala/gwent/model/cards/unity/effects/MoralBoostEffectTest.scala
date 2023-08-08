package scala.gwent.model.cards.unity.effects

import munit.FunSuite

import scala.gwent.model.board.zone.AbstractZone
import scala.gwent.model.cards.ICard
import scala.gwent.model.cards.unity.{CloseCombatCard, IUnityCard, RangedCombatCard}
import scala.gwent.model.cards.weather.{BitingFrostEffect, IWeatherCard}

class MoralBoostEffectTest extends FunSuite {

  class TestZone extends AbstractZone

  /**
   * Test case for the 'clear' method of the AbstractZone.
   */
  test("Test clear") {
    // Create a TestZone
    val zone: AbstractZone = new TestZone()

    // Create a card and add it to the zone
    val card: ICard = new CloseCombatCard("CardName", "CardDescription", 10, null)
    zone.addCard(card)

    // Assert that the zone is not empty after adding the card
    assert(zone.cards.nonEmpty)

    // Call the 'clear' method on the zone
    zone.clear()

    // Assert that the zone is empty after clearing it
    assert(zone.cards.isEmpty)
  }

  /**
   * Test case for the 'addCard' method of the AbstractZone.
   */
  test("Test addCard") {
    // Create a TestZone
    val zone: AbstractZone = new TestZone()

    // Create a card
    val card: ICard = new RangedCombatCard("CardName", "CardDescription", 10, null)

    // Call the 'addCard' method on the zone, adding the card to the zone
    zone.addCard(card)

    // Assert that the zone contains the added card
    assert(zone.cards.contains(card))
  }

  /**
   * Test case for the 'removeCard' method of the AbstractZone.
   */
  test("Test removeCard") {
    // Create a TestZone
    val zone: AbstractZone = new TestZone()

    // Create a card and add it to the zone
    val card: ICard = new CloseCombatCard("CardName", "CardDescription", 10, null)
    zone.addCard(card)

    // Assert that the zone contains the added card
    assert(zone.cards.contains(card))

    // Call the 'removeCard' method on the zone, removing the card from the zone
    zone.removeCard(card)

    // Assert that the zone no longer contains the removed card
    assert(!zone.cards.contains(card))
  }

  /**
   * Test case for the 'applyEffect' method of the MoralBoostEffect.
   */
  test("Test applyEffect") {
    // Create a MoralBoostEffect
    val effectCard: IEffectCard = new MoralBoostEffect()

    // Create a unity card with initial strength 10 and no effect
    val unityCard: IUnityCard = new CloseCombatCard("CardName", "CardDescription", 10, null)

    // Call the 'applyEffect' method on the effect card, applying the effect to the unity card
    effectCard.applyEffect(unityCard)

    // Assert that the effect has increased the current strength of the unity card by 1 (MoralBoostEffect increases strength by 1)
    assert(unityCard.currentStrength == 11)
  }
}