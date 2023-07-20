package scala.gwent.model.cards.unity

import scala.gwent.model.cards.ICard
import scala.gwent.model.cards.unity.effects.IEffectCard

/**
 * A trait representing a Unity Card in a card game.
 *
 * Unity Cards are a type of card that have a current strength, a base strength, and an effect.
 * This trait extends the [[ICard]] trait and defines the necessary properties and methods for Unity Cards.
 */
trait IUnityCard extends ICard {

  /**
   * The current strength of the Unity Card.
   *
   * This variable represents the current strength or value of the Unity Card during gameplay.
   */
  var currentStrength: Int

  /**
   * The base strength of the Unity Card.
   *
   * This method returns the base strength or value of the Unity Card, which is a constant value.
   *
   * @return The base strength of the Unity Card.
   */
  def strength: Int

  /**
   * The effect of the Unity Card.
   *
   * This method returns the effect of the Unity Card, which is represented by an instance of [[IEffectCard]].
   *
   * @return The effect of the Unity Card.
   */
  def effect: IEffectCard
}
