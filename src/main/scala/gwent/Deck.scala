package cl.uchile.dcc
package gwent

import scala.collection.mutable

/**
 * TODO: Futuro desarrollo -> Escribir una interfaz a esta clase
 */


class Deck {
  val container: mutable.Stack[ICard] = mutable.Stack()

  def add(seq: collection.Iterable[ICard]): Unit = {
    for (card <- seq) {
      container.push(card)
    }
  }

}
