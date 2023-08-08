package scala.gwent.model.cards.weather

import munit.FunSuite

import scala.gwent.model.cards.ICard
import scala.gwent.model.cards.unity.CloseCombatCard

/**
 * NullWeatherEffectTest Class Documentation
 *
 * The `NullWeatherEffectTest` class contains a test case for the `applyCardEffect` method in the `NullWeatherEffect` class.
 * It focuses on testing the behavior of the `applyCardEffect` method when applied to a `CloseCombatCard`.
 */
class NullWeatherEffectTest extends FunSuite {

  // Test case for the `applyCardEffect` method in NullWeatherEffect

  /**
   * Test case for the `applyCardEffect` method in `NullWeatherEffect`.
   * It tests the behavior of the `applyCardEffect` method when a `NullWeatherEffect` is applied to a `CloseCombatCard`.
   * The test should check that the `CloseCombatCard` remains unaffected by the `NullWeatherEffect`.
   * The `applyCardEffect` method is expected to have no impact on the `CloseCombatCard`, and its strength should remain unchanged.
   * Therefore, the test should assert that the strength of the `CloseCombatCard` is equal to its initial strength before applying the `NullWeatherEffect`.
   */
  test("Test applyCardEffect") {
    val effect: NullWeatherEffect = new NullWeatherEffect()

    // Create a `CloseCombatCard` with initial strength of 10
    val card: ICard = new CloseCombatCard("CardName", "CardDescription", 10, null)

    // Apply the `NullWeatherEffect` to the `CloseCombatCard`
    effect.applyCardEffect(card)

    // Assert that the strength of the `CloseCombatCard` remains unchanged (i.e., equal to 10)
    assert(card.strength == 10)
  }

}





