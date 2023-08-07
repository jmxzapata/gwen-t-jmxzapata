package scala.gwent.model.cards.unity

import munit.FunSuite

import scala.gwent.model.cards.weather.ImpenetrableFogEffect

class RangedCombatCardTest extends FunSuite {
  test("Test affectedByImpenetrableFog") {
    val card: RangedCombatCard = new RangedCombatCard("CardName", "CardDescription", 10, null)
    val weatherCard: ImpenetrableFogEffect = new ImpenetrableFogEffect("Impenetrable Fog", "Description")

    assert(card.currentStrength == 10)

    card.affectedByImpenetrableFog(weatherCard)

    assert(weatherCard.getObservers.contains(card))

    assert(card.currentStrength == 1)
  }
}