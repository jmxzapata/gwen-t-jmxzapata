package scala.gwent.model.cards.weather

import scala.gwent.model.cards.{AbstractCard, ICard}

/**
 * An abstract class representing a weather card in a card game.
 *
 * Weather cards are a type of card with special effects that can affect other cards in the game.
 * This abstract class extends the AbstractCard class and implements the IWeatherCard trait.
 *
 * @param name        The name of the weather card.
 * @param description A brief description of the weather card.
 */
abstract class AbstractWeatherCard(
                                    name: String,
                                    description: String
                                  ) extends AbstractCard(name, description) with IWeatherCard {

  /**
   * Applies the effect of the weather card to another card.
   *
   * This method is used to apply the effect of the weather card to another card during gameplay.
   *
   * @param card The card to which the weather effect is being applied.
   */
  override def applyCardEffect(card: ICard): Unit = {
  }

  /**
   * Updates the weather card based on changes in the game state.
   *
   * This method is called when the game state changes and allows the weather card to react to those changes.
   *
   * @param card The card that triggered the update.
   */
  override def update(card: ICard): Unit = {
  }

}


