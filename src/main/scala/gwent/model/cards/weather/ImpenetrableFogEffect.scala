package scala.gwent.model.cards.weather

import scala.gwent.model.cards.ICard

/**
 * A class representing an Impenetrable Fog weather effect card in a card game.
 *
 * Impenetrable Fog is a type of weather effect card that can affect other cards in the game.
 * This class extends the AbstractWeatherCard class and implements the necessary methods.
 *
 * @param name        The name of the Impenetrable Fog card.
 * @param description A brief description of the Impenetrable Fog card.
 */
class ImpenetrableFogEffect(
                             override val name: String,
                             override val description: String
                           ) extends AbstractWeatherCard(name, description) {

  /**
   * The strength of the Impenetrable Fog effect.
   *
   * This variable represents the strength or intensity of the Impenetrable Fog effect.
   */
  var strength: Int = _

  /**
   * Applies the Impenetrable Fog weather effect to another card.
   *
   * This method is used to apply the Impenetrable Fog effect to another card during gameplay.
   *
   * @param card The card to which the Impenetrable Fog effect is being applied.
   */
  override def applyCardEffect(card: ICard): Unit = {
    card.affectedByImpenetrableFog(this)
  }
}
