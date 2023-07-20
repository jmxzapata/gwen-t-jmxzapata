package scala.gwent.model.cards.unity.effects

import munit.FunSuite

import scala.gwent.model.cards.ICard
import scala.gwent.model.cards.unity.CloseCombatCard

class NullEffectTest extends FunSuite {
  test("Test applyEffect") {
    val effectCard: IEffectCard = new NullEffect()
    val card: ICard = new CloseCombatCard("CardName", "CardDescription", 10, null)

    effectCard.applyEffect(card)

    assert(card.strength == 10)
  }
}