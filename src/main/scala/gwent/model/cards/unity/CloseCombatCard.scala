package scala.gwent.model.cards.unity

import scala.gwent.model.cards.unity.effects.IEffectCard
import scala.gwent.model.cards.weather.BitingFrostEffect

/**
 * A class representing a Close Combat Card in a card game.
 *
 * Close Combat Cards are a type of Unity Card that are used in close combat situations.
 * This class extends the [[AbstractUnityCard]] class, inheriting its properties and methods.
 *
 * @param name The name of the Close Combat Card.
 * @param description The description of the Close Combat Card.
 * @param strength The base strength of the Close Combat Card, a constant value.
 * @param effect The effect of the Close Combat Card represented by an instance of [[IEffectCard]].
 */
class CloseCombatCard(
                       name: String,
                       description: String,
                       strength: Int,
                       effect: IEffectCard
                     ) extends AbstractUnityCard(name, description, strength, effect) {

  /**
   * Applies the effect of a BitingFrostEffect to the Close Combat Card.
   *
   * This method is called when the Close Combat Card is affected by a BitingFrostEffect.
   * It adds this Close Combat Card as an observer to the BitingFrostEffect and sets its current strength to 1.
   *
   * @param wc The BitingFrostEffect affecting the Close Combat Card.
   */
  override def affectedByBitingFrost(wc: BitingFrostEffect): Unit = {
    wc.addObserver(this)
    currentStrength = 1
  }

}


