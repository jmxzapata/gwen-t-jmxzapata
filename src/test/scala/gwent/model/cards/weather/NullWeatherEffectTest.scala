package scala.gwent.model.cards.weather

import munit.FunSuite

import scala.gwent.model.cards.ICard
import scala.gwent.model.cards.unity.CloseCombatCard

class NullWeatherEffectTest extends FunSuite {

  test("Test applyCardEffect") {
    val effect: NullWeatherEffect = new NullWeatherEffect()

    val card: ICard = new CloseCombatCard("CardName", "CardDescription", 10, null)

    effect.applyCardEffect(card)

    assert(card.strength == 10)
  }

}




