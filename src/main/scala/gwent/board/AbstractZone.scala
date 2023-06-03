package cl.uchile.dcc
package gwent.board

import scala.collection.mutable.ListBuffer

abstract class AbstractZone[TCard](
                                    override val cardsInZone: ListBuffer[TCard]
                                  ) extends IZone[TCard] {

  def addCard(card: TCard, position: Int): Unit = {
    cardsInZone(position) = card
  }

  def removeCard(position: Int): TCard = {
    val card = cardsInZone(position)
    cardsInZone.remove(position)
    card
  }

}