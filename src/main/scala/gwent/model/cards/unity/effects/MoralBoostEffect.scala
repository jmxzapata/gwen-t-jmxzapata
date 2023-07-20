package scala.gwent.model.cards.unity.effects

import scala.gwent.model.cards.ICard
import scala.gwent.model.cards.unity.IUnityCard

/**
 * A class representing a Moral Boost Effect Card in a card game.
 *
 * The Moral Boost Effect Card is a type of Effect Card that boosts the current strength of a Unity Card by 1.
 * When applied, it checks if the target card is an instance of IUnityCard, and if so, increases its current strength by 1.
 *
 * @constructor Creates a new MoralBoostEffect instance.
 */
class MoralBoostEffect extends AbstractEffectCard {
  /**
   * Applies the Moral Boost effect to the target card.
   *
   * This method is called to apply the Moral Boost effect to the specified target card.
   * If the target card is an instance of IUnityCard, its current strength is increased by 1.
   *
   * @param card The target card to which the effect is applied.
   */
  override def applyEffect(card: ICard): Unit = {
    card match {
      case unityCard: IUnityCard =>
        unityCard.currentStrength = unityCard.currentStrength + 1
      case _ =>
    }
  }
}
