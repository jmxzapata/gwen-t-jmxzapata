package scala.gwent.model.cards.unity.effects

import munit.FunSuite

import scala.gwent.model.cards.ICard
import scala.gwent.model.cards.unity.CloseCombatCard

class NullEffectTest extends FunSuite {
  /**
   * Test case for the 'applyEffect' method of the NullEffect.
   */
  test("Test applyEffect") {
    // Create a NullEffect
    val effectCard: IEffectCard = new NullEffect()

    // Create a card with initial strength 10 and no effect
    val card: ICard = new CloseCombatCard("CardName", "CardDescription", 10, null)

    // Call the 'applyEffect' method on the NullEffect, applying no effect to the card
    effectCard.applyEffect(card)

    // Assert that the card's strength remains unchanged after applying the NullEffect
    assert(card.strength == 10)
  }
}