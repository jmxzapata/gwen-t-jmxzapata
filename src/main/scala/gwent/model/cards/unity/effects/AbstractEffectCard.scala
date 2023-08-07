package scala.gwent.model.cards.unity.effects

import scala.gwent.model.board.zone.IZone
import scala.gwent.model.cards.ICard
import scala.gwent.model.cards.unity.effects.IEffectCard

/**
 * An abstract class representing an effect card in the game.
 *
 * Effect cards are cards that apply a specific effect to the target card when played.
 * They can be played on unity cards or weather cards, affecting their behavior or strength.
 *
 * @constructor Create a new AbstractEffectCard instance.
 */
abstract class AbstractEffectCard extends IEffectCard {

  private var _zone: Option[IZone] = None

  /**
   * Get the zone in which this effect card is placed, if any.
   *
   * @return An option representing the zone in which this effect card is placed.
   */
  override def zone: Option[IZone] = _zone

  /**
   * Set the zone in which this effect card is placed.
   *
   * @param value An option representing the zone in which this effect card is placed.
   */
  def zone_= (value: Option[IZone]): Unit = {
    _zone = value
  }

  /**
   * Apply the effect of this card to the target card.
   *
   * This method should be overridden in subclasses to define the specific effect.
   *
   * @param target The target card to apply the effect to.
   */
  def applyEffect(target: ICard): Unit
}


