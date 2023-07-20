package scala.gwent.model.cards.weather

import scala.gwent.model.cards.ICard

/**
 * A trait representing a weather card in a card game.
 *
 * Weather cards have special effects that can affect other cards in the game.
 */
trait IWeatherCard extends ICard {

  /**
   * Applies the effect of the weather card to another card.
   *
   * This method is used to apply the effect of the weather card to another card during gameplay.
   *
   * @param card The card to which the weather effect is being applied.
   */
  def applyCardEffect(card: ICard): Unit

}

