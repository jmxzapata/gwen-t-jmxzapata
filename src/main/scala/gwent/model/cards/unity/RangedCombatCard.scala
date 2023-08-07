package scala.gwent.model.cards.unity

import scala.gwent.model.cards.unity.effects.IEffectCard
import scala.gwent.model.cards.weather.ImpenetrableFogEffect

/**
 * A class representing a Ranged Combat Card in a card game.
 *
 * Ranged Combat Cards are a type of Unity Card that are used in ranged combat situations.
 * This class extends the [[AbstractUnityCard]] class, inheriting its properties and methods.
 *
 * @param name The name of the Ranged Combat Card.
 * @param description The description of the Ranged Combat Card.
 * @param strength The base strength of the Ranged Combat Card, a constant value.
 * @param effect The effect of the Ranged Combat Card represented by an instance of [[IEffectCard]].
 */
class RangedCombatCard(
                        name: String,
                        description: String,
                        strength: Int,
                        effect: IEffectCard
                      ) extends AbstractUnityCard(name, description, strength, effect) {

  /**
   * Applies the effect of an ImpenetrableFogEffect to the Ranged Combat Card.
   *
   * This method is called when the Ranged Combat Card is affected by an ImpenetrableFogEffect.
   * It adds this Ranged Combat Card as an observer to the ImpenetrableFogEffect and sets its current strength to 1.
   *
   * @param wc The ImpenetrableFogEffect affecting the Ranged Combat Card.
   */
  override def affectedByImpenetrableFog(wc: ImpenetrableFogEffect): Unit = {
    wc.addObserver(this)
    currentStrength = 1
  }

}
