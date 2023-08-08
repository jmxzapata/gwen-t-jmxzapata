package scala.gwent.model.cards.weather

import scala.gwent.model.cards.ICard

/**
 * A class representing a Torrential Rain Effect card in a card game.
 *
 * Torrential Rain Effect is a type of weather effect card that affects certain cards in the game.
 * This class extends the AbstractWeatherCard class and implements the necessary methods.
 *
 * @param name        The name of the Torrential Rain Effect card.
 * @param description The description of the Torrential Rain Effect card.
 */
class TorrentialRainEffect(override val name: String, override val description: String)
  extends AbstractWeatherCard(name, description) {

  /**
   * The strength of the Torrential Rain Effect.
   *
   * This variable represents the strength or intensity of the Torrential Rain Effect.
   */
  var strength: Int = _

  /**
   * Applies the Torrential Rain Effect to another card.
   *
   * This method is used to apply the Torrential Rain Effect to another card during gameplay.
   *
   * @param card The card to which the Torrential Rain Effect is being applied.
   */
  override def applyCardEffect(card: ICard): Unit = {
    card.affectedByTorrentialRain(this)
  }
}
