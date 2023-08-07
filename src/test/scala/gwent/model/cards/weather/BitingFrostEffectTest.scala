package scala.gwent.model.cards.weather

import munit.FunSuite

import scala.gwent.model.board.zone.CloseCombatZone
import scala.gwent.model.cards.ICard
import scala.gwent.model.cards.unity.{CloseCombatCard, RangedCombatCard, SiegeCombatCard}
import scala.gwent.model.cards.weather.BitingFrostEffect
class BitingFrostEffectTest extends FunSuite {

  test("Test applyCardEffect") {
    val effect: BitingFrostEffect = new BitingFrostEffect("Biting Frost", "Description")
    val card: ICard = new CloseCombatCard("CardName", "CardDescription", 10, null)

    effect.applyCardEffect(card)

  }

}