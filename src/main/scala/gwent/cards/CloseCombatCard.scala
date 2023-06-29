package cl.uchile.dcc
package gwent.cards

import scala.collection.mutable.ListBuffer

/**
 * A class representing a close combat card in the Gwent game.
 *
 * This class extends the `AbstractUnityCard` class and inherits its properties and behavior.
 *
 * @param name        The name of the card.
 * @param description The description of the card.
 * @param power       The power value of the card.
 */
class CloseCombatCard(
                       override val name: String,
                       override val description: String,
                       override val power: Int
                     ) extends AbstractUnityCard(name, description, power) with ICardObserver {

  private val observers: ListBuffer[ICardObserver] = ListBuffer()

  /**
   * Adds an observer to the card.
   *
   * @param observer The observer to be added.
   */
  def addObserver(observer: ICardObserver): Unit = {
    observers += observer
  }

  /**
   * Removes an observer from the card.
   *
   * @param observer The observer to be removed.
   */
  def removeObserver(observer: ICardObserver): Unit = {
    observers -= observer
  }

  /**
   * Applies morale boost to the card and notifies the observers.
   *
   * @param deck The deck of cards.
   */
  def applyMoraleBoost(deck: List[ICard]): Unit = {
    observers.foreach(_.update(this))
  }

  /**
   * Applies tight bond to the card and notifies the observers.
   *
   * @param deck The deck of cards.
   */
  def applyTightBond(deck: List[ICard]): Unit = {
    observers.foreach(_.update(this))
  }

  /**
   * Updates the current power of the card based on an observed card.
   *
   * @param card The observed card.
   */
  override def update(card: IUnityCard): Unit = {
    if (card != this)
      currentPower += 1
  }

  /**
   * Checks if the provided object can be equal to this close combat card.
   *
   * @param other The object to compare.
   * @return True if the object can be equal to this close combat card, false otherwise.
   */
  override def canEqual(other: Any): Boolean = other.isInstanceOf[CloseCombatCard]
}
