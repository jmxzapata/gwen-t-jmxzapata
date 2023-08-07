package scala.gwent.model.board

import scala.gwent.model.board.zone.{CloseCombatZone, RangedCombatZone, SiegeCombatZone, WeatherZone}
import scala.gwent.model.cards.unity.{CloseCombatCard, RangedCombatCard, SiegeCombatCard}
import scala.gwent.model.cards.weather.IWeatherCard

/**
 * A class representing a board section in the card game.
 *
 * The BoardSection class is a part of the card game system and represents a section of the game board where
 * players can place their cards. It implements the IGameComposite trait, which means it can act as a composite
 * in the composite pattern and can spread weather effects to its children (close combat, ranged combat, and siege combat zones).
 *
 * @constructor Creates a new BoardSection with the given weather zone.
 */
class BoardSection(val weatherZone: WeatherZone) extends IGameComposite {

  /** The close combat zone in the board section. */
  val closeZone: CloseCombatZone = new CloseCombatZone()

  /** The ranged combat zone in the board section. */
  val rangedZone: RangedCombatZone = new RangedCombatZone()

  /** The siege combat zone in the board section. */
  val siegeZone: SiegeCombatZone = new SiegeCombatZone()

  /**
   * Place a card in the close combat zone.
   *
   */
  def placeCardInCloseZone(card: CloseCombatCard): Unit = {
    closeZone.addCard(card)
  }

  /**
   * Place a card in the ranged combat zone.
   *
   */
  def placeCardInRangedZone(card: RangedCombatCard): Unit = {
    rangedZone.addCard(card)
  }

  /**
   * Place a card in the siege combat zone.
   *
   */
  def placeCardInSiegeZone(card: SiegeCombatCard): Unit = {
    siegeZone.addCard(card)
  }

  /**
   * Place a weather card in the weather zone.
   *
   */
  def placeWeatherCard(card: IWeatherCard): Unit = {
    weatherZone.addCard(card)
  }

  /**
   * Spread the effect of a weather card to the combat zones in the board section.
   *
   * This method spreads the effect of a weather card to the close combat, ranged combat, and siege combat zones
   * in the board section.
   *
   */
  override def spreadWeatherEffect(card: IWeatherCard): Unit = {
    closeZone.spreadWeatherEffect(card)
    rangedZone.spreadWeatherEffect(card)
    siegeZone.spreadWeatherEffect(card)
  }
}
