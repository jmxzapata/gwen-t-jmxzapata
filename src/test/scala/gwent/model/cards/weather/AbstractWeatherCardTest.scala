package scala.gwent.model.cards.weather

import munit.FunSuite

import scala.gwent.model.cards.ICard
import scala.gwent.model.cards.unity.CloseCombatCard

class AbstractWeatherCardTest extends FunSuite {
  test("Test update") {
    val weatherCard: IWeatherCard = new BitingFrostEffect("Biting Frost", "Description")

    val card: ICard = new CloseCombatCard("CardName", "CardDescription", 10, null)

    weatherCard.update(card)

    assert(card.strength == 10)
  }

}