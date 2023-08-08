package scala.gwent.model.board

import munit.FunSuite

import scala.gwent.model.cards.unity.{CloseCombatCard, RangedCombatCard, SiegeCombatCard}
import scala.gwent.model.cards.weather.{BitingFrostEffect, IWeatherCard}
import scala.gwent.model.board.zone.WeatherZone
import scala.gwent.model.board.NullBoardSection

class NullBoardSectionTest extends FunSuite {

  /**
   * Test case for the 'placeCardInCloseZone' method of the NullBoardSection with a CloseCombatCard.
   */
  test("Test placeCardInCloseZone") {
    // Create a null WeatherZone
    val weatherZone: WeatherZone = null

    // Create a NullBoardSection with the null WeatherZone
    val boardSection: BoardSection = new NullBoardSection(weatherZone)

    // Create a CloseCombatCard
    val card: CloseCombatCard = new CloseCombatCard("CardName", "CardDescription", 10, null)

    // Call the 'placeCardInCloseZone' method on the NullBoardSection with the CloseCombatCard
    boardSection.placeCardInCloseZone(card)

  }

  /**
   * Test case for the 'placeCardInRangedZone' method of the NullBoardSection with a RangedCombatCard.
   */
  test("Test placeCardInRangedZone") {
    // Create a null WeatherZone
    val weatherZone: WeatherZone = null

    // Create a NullBoardSection with the null WeatherZone
    val boardSection: BoardSection = new NullBoardSection(weatherZone)

    // Create a RangedCombatCard
    val card: RangedCombatCard = new RangedCombatCard("CardName", "CardDescription", 10, null)

    // Call the 'placeCardInRangedZone' method on the NullBoardSection with the RangedCombatCard
    boardSection.placeCardInRangedZone(card)

  }

  /**
   * Test case for the 'placeCardInSiegeZone' method of the NullBoardSection with a SiegeCombatCard.
   */
  test("Test placeCardInSiegeZone") {
    // Create a new WeatherZone
    val weatherZone: WeatherZone = new WeatherZone()

    // Create a NullBoardSection with the new WeatherZone
    val boardSection: BoardSection = new NullBoardSection(weatherZone)

    // Create a SiegeCombatCard
    val card: SiegeCombatCard = new SiegeCombatCard("CardName", "CardDescription", 10, null)

    // Call the 'placeCardInSiegeZone' method on the NullBoardSection with the SiegeCombatCard
    boardSection.placeCardInSiegeZone(card)

  }

  /**
   * Test case for the 'placeWeatherCard' method of the NullBoardSection with a weather card.
   */
  test("Test placeWeatherCard") {
    // Create a null WeatherZone
    val weatherZone: WeatherZone = null

    // Create a NullBoardSection with the null WeatherZone
    val boardSection: BoardSection = new NullBoardSection(weatherZone)

    // Create a weather card (BitingFrostEffect)
    val card: IWeatherCard = new BitingFrostEffect("Biting Frost", "Description")

    // Call the 'placeWeatherCard' method on the NullBoardSection with the weather card
    boardSection.placeWeatherCard(card)

  }

  /**
   * Test case for the 'spreadWeatherEffect' method of the NullBoardSection with a weather card.
   */
  test("Test spreadWeatherEffect") {
    // Create a new WeatherZone
    val weatherZone: WeatherZone = new WeatherZone()

    // Create a NullBoardSection with the new WeatherZone
    val boardSection: BoardSection = new NullBoardSection(weatherZone)

    // Create a weather card (BitingFrostEffect)
    val card: IWeatherCard = new BitingFrostEffect("Biting Frost", "Description")

    // Call the 'spreadWeatherEffect' method on the NullBoardSection with the weather card
    boardSection.spreadWeatherEffect(card)

  }
}