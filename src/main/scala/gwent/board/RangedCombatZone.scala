package cl.uchile.dcc
package gwent.board

import cl.uchile.dcc.gwent.cards.RangedCombatCard

import scala.collection.mutable.ListBuffer

/**
 * Class representing a ranged combat card zone in the Gwent game.
 *
 * @param cardsInZone List buffer containing ranged combat cards in the zone.
 */
class RangedCombatZone(
                        override val cardsInZone: ListBuffer[RangedCombatCard]
                      ) extends AbstractZone(cardsInZone) {

}
