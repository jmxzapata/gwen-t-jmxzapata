package scala.gwent.model.board

import scala.gwent.model.board.zone.WeatherZone
import scala.gwent.model.cards.unity.{CloseCombatCard, RangedCombatCard, SiegeCombatCard}
import scala.gwent.model.cards.weather.IWeatherCard

/**
 * A concrete class representing a null board section in the card game.
 *
 * The NullBoardSection class is a part of the card game system and represents a board section
 * that does not hold any cards or have any effect. It extends the BoardSection class and provides
 * empty implementations for all the methods defined in the BoardSection class and the IGameComponent
 * trait.
 *
 * This class is used when a player does not have a valid board section to place cards or apply weather
 * effects. It allows the game to gracefully handle scenarios where a player has an empty or invalid
 * board section.
 *
 */
class NullBoardSection(weatherZone: WeatherZone) extends BoardSection(weatherZone) {

  /**
   * Empty implementation of placing a card in the close combat zone.
   *
   */
  override def placeCardInCloseZone(card: CloseCombatCard): Unit = {}

  /**
   * Empty implementation of placing a card in the ranged combat zone.
   *
   */
  override def placeCardInRangedZone(card: RangedCombatCard): Unit = {}

  /**
   * Empty implementation of placing a card in the siege combat zone.
   *
   */
  override def placeCardInSiegeZone(card: SiegeCombatCard): Unit = {}

  /**
   * Empty implementation of placing a weather card in the weather zone.
   *
   */
  override def placeWeatherCard(card: IWeatherCard): Unit = {}

  /**
   * Empty implementation of spreading the effect of a weather card to the cards in the board section.
   *
   */
  override def spreadWeatherEffect(card: IWeatherCard): Unit = {}
}

