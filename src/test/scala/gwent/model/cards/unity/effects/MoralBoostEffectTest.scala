package scala.gwent.model.cards.unity.effects

import munit.FunSuite

import scala.gwent.model.board.zone.AbstractZone
import scala.gwent.model.cards.ICard
import scala.gwent.model.cards.unity.{CloseCombatCard, IUnityCard, RangedCombatCard}
import scala.gwent.model.cards.weather.{BitingFrostEffect, IWeatherCard}

class MoralBoostEffectTest extends FunSuite {

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


  test("Test applyEffect") {
    val effectCard: IEffectCard = new MoralBoostEffect()
    val unityCard: IUnityCard = new CloseCombatCard("CardName", "CardDescription", 10, null)

    effectCard.applyEffect(unityCard)

    assert(unityCard.currentStrength == 11)
  }
}