package scala.gwent.model.cards.unity.effects

import munit.FunSuite

import scala.gwent.model.cards.{Card, ICard}
import scala.gwent.model.cards.unity.{CloseCombatCard, IUnityCard}

class TightBondEffectTest extends FunSuite {
  test("Test applyEffect with unity card") {
    val effectCard: IEffectCard = new TightBondEffect()
    val unityCard: IUnityCard = new CloseCombatCard("CardName", "CardDescription", 10, null)

    effectCard.applyEffect(unityCard)

    assert(unityCard.currentStrength == 20)
  }

}