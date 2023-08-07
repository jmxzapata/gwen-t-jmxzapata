package scala.gwent.model.cards.unity

import munit.FunSuite

import scala.gwent.model.cards.weather.TorrentialRainEffect

class SiegeCombatCardTest extends FunSuite {
  test("Test affectedByTorrentialRain") {
    val card: SiegeCombatCard = new SiegeCombatCard("CardName", "CardDescription", 10, null)
    val weatherCard: TorrentialRainEffect = new TorrentialRainEffect("Torrential Rain", "Description")

    assert(card.currentStrength == 10)

    card.affectedByTorrentialRain(weatherCard)

    assert(weatherCard.getObservers.contains(card))

    assert(card.currentStrength == 1)
  }
}