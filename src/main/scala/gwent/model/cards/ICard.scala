package scala.gwent.model.cards

import scala.gwent.model.cards.weather.{BitingFrostEffect, ClearWeatherEffect, ImpenetrableFogEffect, TorrentialRainEffect}
import scala.gwent.model.cards.unity.effects
import scala.gwent.model.cards.unity.effects.{MoralBoostEffect, TightBondEffect}

/**

Trait ICard represents a generic card in the Gwent game.
This trait extends IObserverCard and ISubjectCard, which are interfaces for card observers and subjects, respectively.
@note All methods in this trait are abstract and must be implemented by concrete classes that extend it.
 */
trait ICard extends IObserverCard with ISubjectCard {
  /**

  @return The name of the card.
   */
  def name: String
  /**

  @return The description of the card.
   */
  def description: String
  /**

  @return The strength of the card.
   */
  def strength: Int
  /**

  Applies the effect of another card to this card.
  @param card The card whose effect will be applied to this card.
   */
  def applyCardEffect(card: ICard): Unit
  /**

  Applies the effect of Biting Frost weather card to this card.
  @param card The Biting Frost weather card that affects this card.
   */
  def affectedByBitingFrost(card: BitingFrostEffect): Unit
  /**

  Applies the effect of Impenetrable Fog weather card to this card.
  @param card The Impenetrable Fog weather card that affects this card.
   */
  def affectedByImpenetrableFog(card: ImpenetrableFogEffect): Unit
  /**

  Applies the effect of Torrential Rain weather card to this card.
  @param card The Torrential Rain weather card that affects this card.
   */
  def affectedByTorrentialRain(card: TorrentialRainEffect): Unit
  /**

  Applies the effect of Clear Weather weather card to this card.
  @param card The Clear Weather weather card that affects this card.
   */
  def affectedByClearWeather(card: ClearWeatherEffect): Unit

  def affectedByMoralBoostEffect(card: MoralBoostEffect): Unit

  def affectedByTightBondEffect(card: TightBondEffect): Unit
  /**

  Updates the card with the data from another card.
  @param card The card with updated data.
   */
  def update(card: ICard): Unit
}