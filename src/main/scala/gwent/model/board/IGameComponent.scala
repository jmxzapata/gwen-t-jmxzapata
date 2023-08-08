package scala.gwent.model.board

import scala.gwent.model.cards.weather.IWeatherCard

/**
 * A trait representing a component in the card game.
 *
 * The IGameComponent trait is a part of the card game system and represents a component that can be affected
 * by weather cards. Components implementing this trait are able to spread the weather effect to other parts
 * of the game.
 */
trait IGameComponent {

  /**
   * Spreads the effect of a weather card to the game component.
   *
   * This method applies the effect of a weather card to the game component. The specific implementation
   * of this method will depend on the type of game component. For example, a board section or a deck may
   * have different ways of applying the weather effect to its contained cards.
   *
   */
  def spreadWeatherEffect(card: IWeatherCard): Unit

}
