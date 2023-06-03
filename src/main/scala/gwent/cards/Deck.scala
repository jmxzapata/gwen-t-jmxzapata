package cl.uchile.dcc
package gwent.cards

import scala.collection.mutable

/**
 * TODO: Tarea -> Escribir una interfaz a esta clase
 */


class Deck {
  val container: mutable.Stack[ICard] = mutable.Stack()

  def add(seq: collection.Iterable[ICard]): Unit = {
    container.pushAll(seq)
  }

  def pickCard(): ICard = {
    container.pop()
  }

}
