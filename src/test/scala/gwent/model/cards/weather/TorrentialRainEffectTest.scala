package scala.gwent.model.cards.weather

import munit.FunSuite

import scala.gwent.model.cards.ICard
import scala.gwent.model.cards.unity.RangedCombatCard

class TorrentialRainEffectTest extends FunSuite {
  test("Test applyCardEffect") {
    val effect: ImpenetrableFogEffect = new ImpenetrableFogEffect("Impenetrable Fog", "Description")
    val card: ICard = new RangedCombatCard("CardName", "CardDescription", 10, null)

    effect.applyCardEffect(card)

  }

}