package scala.gwent.model.cards.weather

import munit.FunSuite

import scala.gwent.model.cards.ICard
import scala.gwent.model.cards.unity.CloseCombatCard

class ClearWeatherEffectTest extends FunSuite {

  test("Test applyCardEffect") {
    val effect: ClearWeatherEffect = new ClearWeatherEffect("Clear Weather", "Description")
    val card: ICard = new CloseCombatCard("CardName", "CardDescription", 10, null)

    effect.applyCardEffect(card)

  }

}