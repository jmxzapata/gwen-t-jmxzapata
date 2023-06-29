package cl.uchile.dcc
package gwent.cards

import scala.collection.mutable

/**
 * A deck of cards used in the Gwent game.
 *
 * This class represents a deck of cards and manages its contents using a mutable Stack data structure.
 * It also provides functionality to observe and notify changes to the deck.
 */
class Deck {
  private val container: mutable.Stack[ICard] = mutable.Stack()
  private val observers: mutable.ListBuffer[ICardObserver] = mutable.ListBuffer()

  /**
   * Adds an observer to the deck.
   *
   * @param observer The observer to add.
   */
  def addObserver(observer: ICardObserver): Unit = {
    observers += observer
  }

  /**
   * Removes an observer from the deck.
   *
   * @param observer The observer to remove.
   */
  def removeObserver(observer: ICardObserver): Unit = {
    observers -= observer
  }

  /**
   * Notifies all observers of a card update in the deck.
   *
   * @param card The card that was updated.
   */
  def notifyObservers(card: AbstractUnityCard): Unit = {
    observers.foreach(_.update(card))
  }

  /**
   * Adds a sequence of cards to the deck.
   *
   * @param seq The sequence of cards to add.
   */
  def add(seq: collection.Iterable[ICard]): Unit = {
    container.pushAll(seq)
  }

  /**
   * Picks a card from the top of the deck.
   *
   * @return The card picked from the deck.
   */
  def pickCard(): ICard = {
    container.pop()
  }
}
