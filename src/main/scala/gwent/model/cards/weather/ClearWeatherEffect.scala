package scala.gwent.model.cards.weather

import scala.gwent.model.cards.ICard

/**
 * A class representing a Clear Weather weather effect card in a card game.
 *
 * Clear Weather is a type of weather effect card that can affect other cards in the game.
 * This class extends the AbstractWeatherCard class and implements the necessary methods.
 *
 * @param name        The name of the Clear Weather card.
 * @param description A brief description of the Clear Weather card.
 */
class ClearWeatherEffect(
                          override val name: String,
                          override val description: String
                        ) extends AbstractWeatherCard(name, description) {

  /**
   * The strength of the Clear Weather effect.
   *
   * This variable represents the strength or intensity of the Clear Weather effect.
   */
  var strength: Int = _

  /**
   * Applies the Clear Weather weather effect to another card.
   *
   * This method is used to apply the Clear Weather effect to another card during gameplay.
   *
   * @param card The card to which the Clear Weather effect is being applied.
   */
  override def applyCardEffect(card: ICard): Unit = {
    card.affectedByClearWeather(this)
  }
}
