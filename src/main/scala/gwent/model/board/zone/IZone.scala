package scala.gwent.model.board.zone

import scala.gwent.model.board.IGameLeaf
import scala.gwent.model.cards.ICard

/**
 * A trait representing a game zone.
 *
 * The IZone trait defines the common behavior for different game zones in the card game system. It extends the
 * IGameLeaf trait, which means it can act as a leaf in the composite pattern and cannot have child components.
 * Zones are areas where cards can be placed during the game, and they provide methods to add cards, remove cards,
 * and clear the zone.
 */
trait IZone extends IGameLeaf {

  /**
   * Add a card to the zone.
   *
   * This method adds the given card to the zone.
   *
   */
  def addCard(card: ICard): Unit

  /**
   * Remove a card from the zone.
   *
   * This method removes the given card from the zone.
   *
   * @param card The card to remove from the zone.
   */
  def removeCard(card: ICard): Unit

  /**
   * Clear the zone.
   *
   * This method removes all cards from the zone, effectively clearing it.
   */
  def clear(): Unit
}


