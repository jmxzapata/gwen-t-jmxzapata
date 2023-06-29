package cl.uchile.dcc
package gwent.board

import cl.uchile.dcc.gwent.cards.SiegeCombatCard

import scala.collection.mutable.ListBuffer

/**
 * Class representing a siege combat card zone in the Gwent game.
 *
 * @param cardsInZone List buffer containing siege combat cards in the zone.
 */
class SiegeCombatZone(
                       override val cardsInZone: ListBuffer[SiegeCombatCard]
                     ) extends AbstractZone(cardsInZone) {

}
