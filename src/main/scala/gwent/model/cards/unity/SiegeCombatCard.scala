package scala.gwent.model.cards.unity

import scala.gwent.model.cards.unity.effects.IEffectCard
import scala.gwent.model.cards.weather.TorrentialRainEffect

/**
 * A class representing a Siege Combat Card in a card game.
 *
 * Siege Combat Cards are a type of Unity Card that are used in siege combat situations.
 * This class extends the [[AbstractUnityCard]] class, inheriting its properties and methods.
 *
 * @param name The name of the Siege Combat Card.
 * @param description The description of the Siege Combat Card.
 * @param strength The base strength of the Siege Combat Card, a constant value.
 * @param effect The effect of the Siege Combat Card represented by an instance of [[IEffectCard]].
 */
class SiegeCombatCard(
                       name: String,
                       description: String,
                       strength: Int,
                       effect: IEffectCard
                     ) extends AbstractUnityCard(name, description, strength, effect) {

  /**
   * Applies the effect of a TorrentialRainEffect to the Siege Combat Card.
   *
   * This method is called when the Siege Combat Card is affected by a TorrentialRainEffect.
   * It adds this Siege Combat Card as an observer to the TorrentialRainEffect and sets its current strength to 1.
   *
   * @param wc The TorrentialRainEffect affecting the Siege Combat Card.
   */
  override def affectedByTorrentialRain(wc: TorrentialRainEffect): Unit = {
    wc.addObserver(this)
    currentStrength = 1
  }

}
