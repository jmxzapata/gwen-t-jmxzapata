package scala.gwent.cards

import scala.collection.mutable

/**
 * TODO: Tarea -> Escribir una interfaz a esta clase
 */

import scala.collection.mutable

/**
 * A class representing a deck of cards in a card game.
 *
 * This class provides a container to store cards using a mutable stack. Cards can be added to the deck using the `add` method.
 *
 * @constructor Creates a new instance of the `Deck` class with an empty container (mutable stack).
 */
class Deck {
  /**
   * The container to store cards in the deck.
   */
  val container: mutable.Stack[ICard] = mutable.Stack()

  /**
   * Adds a collection of cards to the deck.
   *
   * @param seq The collection of cards to be added to the deck.
   */
  def add(seq: collection.Iterable[ICard]): Unit = {
    for (card <- seq) {
      container.push(card)
    }
  }
}
