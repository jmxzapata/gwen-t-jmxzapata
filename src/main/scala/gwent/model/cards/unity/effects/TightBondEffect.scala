package scala.gwent.model.cards.unity.effects

import scala.gwent.model.cards.ICard
import scala.gwent.model.cards.unity.IUnityCard
import scala.gwent.model.cards.unity.effects.AbstractEffectCard

/**
 * A class representing a Tight Bond Effect Card in a card game.
 *
 * The Tight Bond Effect Card is a type of Effect Card that applies a tight bond effect to a target Unity Card.
 * When this card is applied to a Unity Card, the card's current strength is multiplied by 2, effectively doubling its strength.
 *
 * @constructor Creates a new TightBondEffect instance.
 */
class TightBondEffect extends AbstractEffectCard {
  /**
   * Applies the Tight Bond effect to the target card.
   *
   * This method is called to apply the Tight Bond effect to the specified target card.
   * If the target card is a Unity Card, its current strength is multiplied by 2, effectively doubling its strength.
   *
   * @param card The target card to which the effect is applied.
   */
  override def applyEffect(card: ICard): Unit = {
    card.affectedByTightBondEffect(this)
  }
}
