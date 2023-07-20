package scala.gwent.model.cards.unity

import munit.FunSuite

import scala.gwent.model.cards.weather.BitingFrostEffect

class CloseCombatCardTest extends FunSuite {
  test("Test affectedByBitingFrost") {
    val card: CloseCombatCard = new CloseCombatCard("CardName", "CardDescription", 10, null)
    val weatherCard: BitingFrostEffect = new BitingFrostEffect("Biting Frost", "Description")

    assert(card.currentStrength == 10)

    card.affectedByBitingFrost(weatherCard)

    assert(weatherCard.getObservers.contains(card))

    assert(card.currentStrength == 1)
  }
}