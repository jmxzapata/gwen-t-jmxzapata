package cl.uchile.dcc
package gwent.cards

import scala.collection.mutable

/**
 * A composite deck that represents a collection of cards.
 * It implements the CardComponent trait.
 */
class CompositeDeck extends ICardComponent with ICardObserver {
  private val cards: mutable.ListBuffer[ICardComponent] = mutable.ListBuffer()

  def update(card: IUnityCard): Unit = {
  }
  
  /**
   * Adds a card to the composite deck.
   *
   * @param card The card to add.
   */
  def addCard(card: ICardComponent): Unit = {
    cards += card
  }

  /**
   * Removes a card from the composite deck.
   *
   * @param card The card to remove.
   */
  def removeCard(card: ICardComponent): Unit = {
    cards -= card
  }

  /**
   * Retrieves the total power of all cards in the composite deck.
   *
   * @return The total power of the deck.
   */
  def totalPower: Int = cards.map(_.totalPower).sum

  /**
   * Applies the morale boost effect to all cards in the composite deck.
   */
  def applyMoraleBoost(): Unit = {
    cards.foreach(_.applyMoraleBoost())
  }

  /**
   * Applies the tight bond effect to all cards in the composite deck.
   */
  def applyTightBond(): Unit = {
    val cardCounts = cards.groupBy(identity).view.mapValues(_.size).toMap
    cards.foreach {
      case card: CloseCombatCard =>
        val cardName: ICardComponent = card
        cardCounts.get(cardName) match {
          case Some(count) if count > 1 =>
            card.currentPower *= 2
          case _ =>
        }
      case _ =>
    }
  }
}
