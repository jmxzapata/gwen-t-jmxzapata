package cl.uchile.dcc
package gwent.board

import cl.uchile.dcc.gwent.cards.RangedCombatCard

import scala.collection.mutable.ListBuffer

class RangedCombatZone(
                        override val cardsInZone: ListBuffer[RangedCombatCard]
                      ) extends AbstractZone(cardsInZone) {

}