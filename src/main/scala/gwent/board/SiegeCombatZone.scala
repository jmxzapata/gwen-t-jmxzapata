package cl.uchile.dcc
package gwent.board

import cl.uchile.dcc.gwent.cards.SiegeCombatCard

import scala.collection.mutable.ListBuffer

class SiegeCombatZone(
                       override val cardsInZone: ListBuffer[SiegeCombatCard]
                     ) extends AbstractZone(cardsInZone) {

}
