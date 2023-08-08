package scala.gwent.model.board.zone

import munit.FunSuite
import scala.gwent.model.cards.ICard
import scala.gwent.model.cards.unity.{CloseCombatCard, RangedCombatCard}
import scala.gwent.model.cards.weather.{AbstractWeatherCard, IWeatherCard, BitingFrostEffect}

class AbstractZoneTest extends FunSuite {
  class TestZone extends AbstractZone

  /**
   * Test case for the 'clear' method of the AbstractZone class.
   */
  test("Test clear") {
    // Create a new TestZone (subclass of AbstractZone)
    val zone: AbstractZone = new TestZone()

    // Create a new CloseCombatCard
    val card: ICard = new CloseCombatCard("CardName", "CardDescription", 10, null)

    // Add the card to the zone
    zone.addCard(card)

    // Ensure that the zone is not empty before clearing
    assert(zone.cards.nonEmpty)

    // Call the 'clear' method on the zone
    zone.clear()

    // Ensure that the zone is empty after clearing
    assert(zone.cards.isEmpty)
  }

  /**
   * Test case for the 'addCard' method of the AbstractZone class.
   */
  test("Test addCard") {
    // Create a new TestZone (subclass of AbstractZone)
    val zone: AbstractZone = new TestZone()

    // Create a new RangedCombatCard
    val card: ICard = new RangedCombatCard("CardName", "CardDescription", 10, null)

    // Call the 'addCard' method on the zone to add the card
    zone.addCard(card)

    // Ensure that the card is added to the zone
    assert(zone.cards.contains(card))
  }

  /**
   * Test case for the 'removeCard' method of the AbstractZone class.
   */
  test("Test removeCard") {
    // Create a new TestZone (subclass of AbstractZone)
    val zone: AbstractZone = new TestZone()

    // Create a new CloseCombatCard
    val card: ICard = new CloseCombatCard("CardName", "CardDescription", 10, null)

    // Add the card to the zone
    zone.addCard(card)

    // Ensure that the card is present in the zone before removal
    assert(zone.cards.contains(card))

    // Call the 'removeCard' method on the zone to remove the card
    zone.removeCard(card)

    // Ensure that the card is no longer present in the zone after removal
    assert(!zone.cards.contains(card))
  }
}