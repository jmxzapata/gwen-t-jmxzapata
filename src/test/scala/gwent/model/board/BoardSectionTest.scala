package scala.gwent.model.board

import munit.FunSuite

import scala.gwent.model.board.zone.WeatherZone
import scala.gwent.model.board.BoardSection
import scala.gwent.model.cards.ICard
import scala.gwent.model.cards.unity.{CloseCombatCard, RangedCombatCard, SiegeCombatCard}
import scala.gwent.model.cards.weather.{AbstractWeatherCard, BitingFrostEffect}

class BoardSectionTest extends FunSuite {
  /**
   * Test case for the 'placeCardInCloseZone' method of the BoardSection class.
   */
  test("Test placeCardInCloseZone") {
    // Create a new BoardSection with a WeatherZone
    val boardSection = new BoardSection(new WeatherZone())

    // Create a new CloseCombatCard
    val card = new CloseCombatCard("CardName", "CardDescription", 10, null)

    // Call the 'placeCardInCloseZone' method on the BoardSection
    boardSection.placeCardInCloseZone(card)

  }

  /**
   * Test case for the 'placeCardInRangedZone' method of the BoardSection class.
   */
  test("Test placeCardInRangedZone") {
    // Create a new BoardSection with a WeatherZone
    val boardSection = new BoardSection(new WeatherZone())

    // Create a new RangedCombatCard
    val card = new RangedCombatCard("CardName", "CardDescription", 10, null)

    // Call the 'placeCardInRangedZone' method on the BoardSection
    boardSection.placeCardInRangedZone(card)

  }

  /**
   * Test case for the 'placeCardInSiegeZone' method of the BoardSection class.
   */
  test("Test placeCardInSiegeZone") {
    // Create a new BoardSection with a WeatherZone
    val boardSection = new BoardSection(new WeatherZone())

    // Create a new SiegeCombatCard
    val card = new SiegeCombatCard("CardName", "CardDescription", 10, null)

    // Call the 'placeCardInSiegeZone' method on the BoardSection
    boardSection.placeCardInSiegeZone(card)

  }
}