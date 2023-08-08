package scala.gwent.model.cards.weather

import munit.FunSuite

import scala.gwent.model.cards.ICard
import scala.gwent.model.cards.unity.CloseCombatCard

/**
 * AbstractWeatherCardTest Class Documentation
 *
 * The `AbstractWeatherCardTest` class contains a test case for the `update` method in classes that implement the `IWeatherCard` interface.
 * It focuses on testing the behavior of the `update` method when applied to a `BitingFrostEffect` weather card.
 */
class AbstractWeatherCardTest extends FunSuite {

  // Test case for the `update` method in IWeatherCard

  /**
   * Test case for the `update` method in `IWeatherCard`.
   * It tests the behavior of the `update` method when a `BitingFrostEffect` weather card updates a `CloseCombatCard`.
   * The test checks if the strength of the `CloseCombatCard` is not affected by the weather update.
   */
  test("Test update") {
    val weatherCard: IWeatherCard = new BitingFrostEffect("Biting Frost", "Description")

    // Create a `CloseCombatCard` with initial strength of 10
    val card: ICard = new CloseCombatCard("CardName", "CardDescription", 10, null)

    // Apply the weather update to the card using the `update` method
    weatherCard.update(card)

    // Assert that the strength of the card remains unchanged (should be 10)
    assert(card.strength == 10)
  }

}
