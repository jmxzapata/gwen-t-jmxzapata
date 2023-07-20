package scala.gwent.model.player

import scala.collection.mutable.ListBuffer
import scala.gwent.model.cards.ICard

/**
 * A class representing a hand of cards in a card game.
 *
 * The Hand class stores a collection of cards and provides methods to interact with the cards in the hand,
 * such as calculating the total strength of the cards and checking if there are cards to play.
 *
 * @constructor Creates a new Hand instance.
 */
class Hand {
  /** The maximum number of cards that can be held in the hand. */
  val maxCards: Int = 10

  /** The list of cards currently held in the hand. */
  val cards: ListBuffer[ICard] = ListBuffer.empty[ICard]

  /**
   * Calculates the total strength of all the cards in the hand.
   *
   * This method sums up the strength of each card in the hand and returns the total strength.
   *
   * @return The total strength of all the cards in the hand.
   */
  def calculateTotalStrength: Int = {
    cards.map(_.strength).sum
  }

  /**
   * Checks if there are cards in the hand that can be played.
   *
   * This method checks if the hand is not empty, indicating that there are cards available to be played.
   *
   * @return true if there are cards in the hand to play, false otherwise.
   */
  def hasCardsToPlay: Boolean = {
    cards.nonEmpty
  }

  /**
   * Returns a string representation of the hand.
   *
   * The string representation includes the list of cards currently held in the hand.
   *
   * @return A string representation of the hand.
   */
  override def toString: String = s"Hand(cards=$cards)"
}
