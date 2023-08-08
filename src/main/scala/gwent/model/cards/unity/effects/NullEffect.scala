package scala.gwent.model.cards.unity.effects

import scala.gwent.model.cards.ICard
import scala.gwent.model.cards.unity.effects.AbstractEffectCard

/**
 * A class representing a Null Effect Card in a card game.
 *
 * The Null Effect Card is a type of Effect Card that does not have any effect when applied to a target card.
 * When this card is applied, it does nothing and the target card's state remains unchanged.
 *
 * @constructor Creates a new NullEffect instance.
 */
class NullEffect extends AbstractEffectCard {
  /**
   * Applies the Null effect to the target card.
   *
   * This method is called to apply the Null effect to the specified target card.
   * However, the Null effect does not modify the target card's state and therefore does nothing when applied.
   *
   * @param card The target card to which the effect is applied.
   */
  override def applyEffect(card: ICard): Unit = {
    // The Null effect does not have any impact on the target card.
    // Therefore, this method does nothing.
  }
}
