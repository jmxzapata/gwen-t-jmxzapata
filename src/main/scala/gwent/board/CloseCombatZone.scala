package cl.uchile.dcc
package gwent.board

import gwent.cards.CloseCombatCard

import scala.collection.mutable.ListBuffer

/**
 * Class representing a close combat card zone in the Gwent game.
 *
 * @param cardsInZone List buffer containing close combat cards in the zone.
 */
class CloseCombatZone(
                       override val cardsInZone: ListBuffer[CloseCombatCard]
                     ) extends AbstractZone(cardsInZone) {

}

