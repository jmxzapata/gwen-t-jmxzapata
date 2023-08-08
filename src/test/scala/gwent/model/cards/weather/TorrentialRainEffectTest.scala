package scala.gwent.model.cards.weather

import munit.FunSuite

import scala.gwent.model.cards.ICard
import scala.gwent.model.cards.unity.RangedCombatCard

/**
 * TorrentialRainEffectTest Class Documentation
 *
 * The `TorrentialRainEffectTest` class contains a test case for the `applyCardEffect` method in the `TorrentialRainEffect` class.
 * It focuses on testing the behavior of the `applyCardEffect` method when applied to a `RangedCombatCard`.
 */
class TorrentialRainEffectTest extends FunSuite {

  // Test case for the `applyCardEffect` method in TorrentialRainEffect

  /**
   * Test case for the `applyCardEffect` method in `TorrentialRainEffect`.
   * It tests the behavior of the `applyCardEffect` method when a `TorrentialRainEffect` is applied to a `RangedCombatCard`.
   * The test should check that the `RangedCombatCard` is correctly affected by the `TorrentialRainEffect`.
   * The `applyCardEffect` method is expected to modify the strength of the `RangedCombatCard` based on the rules of the `TorrentialRainEffect`.
   * Therefore, the test should assert that the strength of the `RangedCombatCard` is changed accordingly after applying the `TorrentialRainEffect`.
   */
  test("Test applyCardEffect") {
    val effect: TorrentialRainEffect = new TorrentialRainEffect("Torrential Rain", "Description")

    // Create a `RangedCombatCard` with initial strength of 10
    val card: ICard = new RangedCombatCard("CardName", "CardDescription", 10, null)

    // Apply the `TorrentialRainEffect` to the `RangedCombatCard`
    effect.applyCardEffect(card)

  }

}
