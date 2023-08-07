package scala.gwent.model.board

import munit.FunSuite

import scala.gwent.model.cards.unity.{CloseCombatCard, RangedCombatCard, SiegeCombatCard}
import scala.gwent.model.cards.weather.{BitingFrostEffect, IWeatherCard}
import scala.gwent.model.board.zone.WeatherZone
import scala.gwent.model.board.NullBoardSection

class NullBoardSectionTest extends FunSuite {

  test("Test placeCardInCloseZone") {
    val weatherZone: WeatherZone = null
    val boardSection: BoardSection = new NullBoardSection(weatherZone)
    val card: CloseCombatCard = new CloseCombatCard("CardName", "CardDescription", 10, null)

    boardSection.placeCardInCloseZone(card)

  }

  test("Test placeCardInRangedZone") {
    val weatherZone: WeatherZone = null
    val boardSection: BoardSection = new NullBoardSection(weatherZone)
    val card: RangedCombatCard = new RangedCombatCard("CardName", "CardDescription", 10, null)

    boardSection.placeCardInRangedZone(card)

    // Verify any expected outcomes
  }

  test("Test placeCardInSiegeZone") {
    val weatherZone: WeatherZone = new WeatherZone() 
    val boardSection: BoardSection = new NullBoardSection(weatherZone)
    val card: SiegeCombatCard = new SiegeCombatCard("CardName", "CardDescription", 10, null)

    boardSection.placeCardInSiegeZone(card)

  }

  test("Test placeWeatherCard") {
    val weatherZone: WeatherZone = null
    val boardSection: BoardSection = new NullBoardSection(weatherZone)
    val card: IWeatherCard = new BitingFrostEffect("Biting Frost", "Description")

    boardSection.placeWeatherCard(card)

  }

  test("Test spreadWeatherEffect") {
    val weatherZone: WeatherZone = new WeatherZone()
    val boardSection: BoardSection = new NullBoardSection(weatherZone)
    val card: IWeatherCard = new BitingFrostEffect("Biting Frost", "Description")

    boardSection.spreadWeatherEffect(card)

  }
}