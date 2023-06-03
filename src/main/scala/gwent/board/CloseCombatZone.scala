package cl.uchile.dcc
package gwent.board

import gwent.cards.CloseCombatCard

import scala.collection.mutable.ListBuffer

class CloseCombatZone(
                       override val cardsInZone: ListBuffer[CloseCombatCard]
                     ) extends AbstractZone(cardsInZone) {


}
