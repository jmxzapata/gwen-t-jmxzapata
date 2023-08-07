package scala.gwent.model.board.zone

import munit.FunSuite
import scala.gwent.model.cards.ICard
import scala.gwent.model.cards.unity.{CloseCombatCard, RangedCombatCard}
import scala.gwent.model.cards.weather.{AbstractWeatherCard, IWeatherCard, BitingFrostEffect}

class AbstractZoneTest extends FunSuite {
  class TestZone extends AbstractZone

  test("Test clear") {
    val zone: AbstractZone = new TestZone()
    val card: ICard = new CloseCombatCard("CardName", "CardDescription", 10, null)

    zone.addCard(card)
    assert(zone.cards.nonEmpty)

    zone.clear()
    assert(zone.cards.isEmpty)
  }

  test("Test addCard") {
    val zone: AbstractZone = new TestZone()
    val card: ICard = new RangedCombatCard("CardName", "CardDescription", 10, null)

    zone.addCard(card)
    assert(zone.cards.contains(card))
  }

  test("Test removeCard") {
    val zone: AbstractZone = new TestZone()
    val card: ICard = new CloseCombatCard("CardName", "CardDescription", 10, null)

    zone.addCard(card)
    assert(zone.cards.contains(card))

    zone.removeCard(card)
    assert(!zone.cards.contains(card))
  }

}