package scala.gwent.model.board

import munit.FunSuite

import scala.gwent.model.board.zone.WeatherZone
import scala.gwent.model.board.BoardSection
import scala.gwent.model.cards.ICard
import scala.gwent.model.cards.unity.{CloseCombatCard, RangedCombatCard, SiegeCombatCard}
import scala.gwent.model.cards.weather.{AbstractWeatherCard, BitingFrostEffect}

class BoardSectionTest extends FunSuite {
  test("Test placeCardInCloseZone") {
    val boardSection = new BoardSection(new WeatherZone())
    val card = new CloseCombatCard("CardName", "CardDescription", 10, null)

    boardSection.placeCardInCloseZone(card)

  }

  test("Test placeCardInRangedZone") {
    val boardSection = new BoardSection(new WeatherZone())
    val card = new RangedCombatCard("CardName", "CardDescription", 10, null)

    boardSection.placeCardInRangedZone(card)

  }

  test("Test placeCardInSiegeZone") {
    val boardSection = new BoardSection(new WeatherZone())
    val card = new SiegeCombatCard("CardName", "CardDescription", 10, null)

    boardSection.placeCardInSiegeZone(card)

  }

}