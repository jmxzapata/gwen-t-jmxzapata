package cl.uchile.dcc
package gwent.board

import scala.collection.mutable.ListBuffer

/**
 * An abstract class representing a zone in the Gwent game.
 *
 * @tparam TCard The type of cards stored in the zone.
 * @param cardsInZone The list buffer holding the cards in the zone.
 */
abstract class AbstractZone[TCard](
                                    override val cardsInZone: ListBuffer[TCard]
                                  ) extends IZone[TCard] {

  /**
   * Adds a card to the zone at the specified position.
   *
   * @param card The card to add.
   * @param position The position at which to add the card.
   */
  def addCard(card: TCard, position: Int): Unit = {
    cardsInZone(position) = card
  }

  /**
   * Removes and returns the card at the specified position from the zone.
   *
   * @param position The position of the card to remove.
   * @return The removed card.
   */
  def removeCard(position: Int): TCard = {
    val card = cardsInZone(position)
    cardsInZone.remove(position)
    card
  }

}
