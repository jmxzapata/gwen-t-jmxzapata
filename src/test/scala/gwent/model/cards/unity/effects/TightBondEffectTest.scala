package scala.gwent.model.cards.unity.effects

import munit.FunSuite

import scala.gwent.model.cards.{Card, ICard}
import scala.gwent.model.cards.unity.{CloseCombatCard, IUnityCard}

class TightBondEffectTest extends FunSuite {
  /**
   * Test case for the 'applyEffect' method of the TightBondEffect with a unity card.
   */
  test("Test applyEffect with unity card") {
    // Create a TightBondEffect
    val effectCard: IEffectCard = new TightBondEffect()

    // Create a unity card with initial strength 10 and no effect
    val unityCard: IUnityCard = new CloseCombatCard("CardName", "CardDescription", 10, null)

    // Call the 'applyEffect' method on the TightBondEffect, doubling the unity card's strength
    effectCard.applyEffect(unityCard)

    // Assert that the unity card's strength is doubled to 20 after applying the TightBondEffect
    assert(unityCard.currentStrength == 20)
  }
}