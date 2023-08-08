package scala.gwent.model.cards.unity

import scala.gwent.model.cards.unity.effects.{IEffectCard, MoralBoostEffect, TightBondEffect}
import scala.gwent.model.cards.{AbstractCard, ICard, IObserverCard}
import scala.gwent.model.cards.weather.ClearWeatherEffect

/**
 * An abstract class representing a Unity Card in a card game.
 *
 * Unity Cards are a type of card that have a current strength, a base strength, and an effect.
 * This class extends the [[AbstractCard]] class and implements the [[IUnityCard]] trait,
 * defining the necessary properties and methods for Unity Cards.
 *
 * @param name The name of the Unity Card.
 * @param description The description of the Unity Card.
 * @param strength The base strength of the Unity Card, a constant value.
 * @param effect The effect of the Unity Card represented by an instance of [[IEffectCard]].
 */
abstract class AbstractUnityCard(
                                  name: String,
                                  description: String,
                                  override val strength: Int,
                                  override val effect: IEffectCard
                                ) extends AbstractCard(name, description) with IUnityCard {

  /**
   * The current strength of the Unity Card.
   *
   * This variable represents the current strength or value of the Unity Card during gameplay.
   */
  private var _currentStrength: Int = strength

  /**
   * Getter for the current strength of the Unity Card.
   *
   * @return The current strength of the Unity Card.
   */
  def currentStrength: Int = _currentStrength

  /**
   * Setter for the current strength of the Unity Card.
   *
   * @param value The new value for the current strength of the Unity Card.
   */
  def currentStrength_=(value: Int): Unit = {
    _currentStrength = value
  }

  /**
   * Applies the card effect to a target card.
   *
   * This method calls the `applyEffect` method of the effect of the Unity Card,
   * passing the target card as the argument.
   *
   * @param card The target card to apply the effect to.
   */
  override def applyCardEffect(card: ICard): Unit = {
    effect.applyEffect(card)
  }

  /**
   * Updates the Unity Card after it has been played or used.
   *
   * This method resets the current strength of the Unity Card to its base strength.
   *
   * @param card The Unity Card that has been played or used.
   */
  override def update(card: ICard): Unit = {
    currentStrength = strength
  }

  /**
   * Applies the effect of a ClearWeatherEffect to the Unity Card.
   *
   * This method is called when the Unity Card is affected by a ClearWeatherEffect.
   * It adds this Unity Card as an observer to the ClearWeatherEffect and resets its current strength to its base strength.
   *
   * @param wc The ClearWeatherEffect affecting the Unity Card.
   */
  override def affectedByClearWeather(wc: ClearWeatherEffect): Unit = {
    wc.addObserver(this)
    currentStrength = strength
  }

  override def affectedByMoralBoostEffect(card: MoralBoostEffect): Unit = {
    currentStrength += 1
  }

  override def affectedByTightBondEffect(card: TightBondEffect): Unit = {
    currentStrength *= 2
  }

}
