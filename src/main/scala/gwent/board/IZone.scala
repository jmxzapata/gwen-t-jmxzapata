package cl.uchile.dcc
package gwent.board

import scala.collection.mutable.ListBuffer


trait IZone[TCard] {

  val cardsInZone: ListBuffer[TCard]

}
