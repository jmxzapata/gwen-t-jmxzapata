package scala.gwent.model.cards.unity.effects

import scala.gwent.model.board.zone.IZone
import scala.gwent.model.cards.ICard

/**
 * A trait representing an Effect Card in a card game.
 *
 * Effect Cards are cards that have an effect on other cards or zones when applied.
 * Classes implementing this trait should define the specific effect they have on the target card.
 *
 */
trait IEffectCard {
  /**
   * Applies the effect of this Effect Card to the target card.
   *
   * This method is called to apply the effect of this Effect Card to the specified target card.
   * The exact nature of the effect depends on the implementing class.
   */
  def applyEffect(target: ICard): Unit

  /**
   * The zone in which this Effect Card is located, if applicable.
   *
   * This method returns an optional IZone object representing the zone in which this Effect Card is located.
   * Some Effect Cards may not belong to any specific zone, in which case this method returns None.
   *
   * @return An option containing the IZone object representing the zone of this Effect Card, or None if it has no zone.
   */
  def zone: Option[IZone]

}
