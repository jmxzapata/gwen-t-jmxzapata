package scala.gwent.model.cards.weather

import scala.gwent.model.cards.ICard

/**
 * A class representing a Null Weather Effect card in a card game.
 *
 * Null Weather Effect is a type of weather effect card that has no impact on other cards in the game.
 * This class extends the AbstractWeatherCard class and implements the necessary methods.
 */
class NullWeatherEffect extends AbstractWeatherCard("Null Weather Effect", "") {

  /**
   * The strength of the Null Weather Effect.
   *
   * This variable represents the strength or intensity of the Null Weather Effect.
   */
  var strength: Int = _

  /**
   * Applies no effect to another card.
   *
   * This method is used to apply no effect to another card during gameplay, as Null Weather Effect
   * has no impact on other cards.
   *
   * @param card The card to which no effect is being applied.
   */
  override def applyCardEffect(card: ICard): Unit = {
  }
}
