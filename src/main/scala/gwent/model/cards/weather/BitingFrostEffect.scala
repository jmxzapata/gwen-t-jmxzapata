package scala.gwent.model.cards.weather

import scala.gwent.model.cards.ICard

/**
 * A class representing a Biting Frost weather effect card in a card game.
 *
 * Biting Frost is a type of weather effect card that can affect other cards in the game.
 * This class extends the AbstractWeatherCard class and implements the necessary methods.
 *
 * @param name        The name of the Biting Frost card.
 * @param description A brief description of the Biting Frost card.
 */
class BitingFrostEffect(
                         override val name: String,
                         override val description: String
                       ) extends AbstractWeatherCard(name, description) {

  /**
   * The strength of the Biting Frost effect.
   *
   * This variable represents the strength or intensity of the Biting Frost effect.
   */
  var strength: Int = _

  /**
   * Applies the Biting Frost weather effect to another card.
   *
   * This method is used to apply the Biting Frost effect to another card during gameplay.
   *
   * @param card The card to which the Biting Frost effect is being applied.
   */
  override def applyCardEffect(card: ICard): Unit = {
    card.affectedByBitingFrost(this)
  }
}


