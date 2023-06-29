package cl.uchile.dcc
package gwent.board

import scala.collection.mutable.ListBuffer

/**
 * A trait representing a zone in the Gwent game.
 *
 * @tparam TCard The type of cards stored in the zone.
 */
trait IZone[TCard] {

  /**
   * The list buffer holding the cards in the zone.
   */
  val cardsInZone: ListBuffer[TCard]

}

