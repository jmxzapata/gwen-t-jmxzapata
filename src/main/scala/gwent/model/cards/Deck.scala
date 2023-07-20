package scala.gwent.model.cards

import scala.collection.mutable.ListBuffer
import scala.gwent.model.board.IGameLeaf
import scala.gwent.model.cards.weather.IWeatherCard
import scala.util.Random

/**
 * A class representing a deck of cards in a card game.
 *
 * A deck is a collection of cards from which players draw cards during the game.
 * It can also be used to deal cards to players at the beginning of the game.
 *
 * @constructor Create a new empty deck.
 */
class Deck extends IGameLeaf {

  /**
   * Deals a specified number of cards from the deck.
   *
   * @param numberOfCards The number of cards to deal.
   * @return A list of cards that were dealt.
   */
  def deal(numberOfCards: Int): List[Card] = {
    // Create a new list to hold the dealt cards
    val dealtCards = ListBuffer.empty[Card]

    // Loop through the deck and deal the specified number of cards
    for (_ <- 1 to numberOfCards) {
      val cardOption = drawCard()

      cardOption.foreach { card =>
        dealtCards += card.asInstanceOf[Card]
      }
    }

    // Return the list of dealt cards
    dealtCards.toList
  }

  private var _cards: ListBuffer[ICard] = ListBuffer.empty[ICard]

  /**
   * Retrieves the list of cards in the deck.
   *
   * @return The list of cards in the deck.
   */
  def cards: ListBuffer[ICard] = _cards

  /**
   * Adds a card to the deck.
   *
   * @param card The card to add to the deck.
   */
  def addCard(card: ICard): Unit = {
    _cards += card
  }

  /**
   * Checks if the deck has any cards.
   *
   * @return true if the deck has cards, false otherwise.
   */
  def hasCards: Boolean = {
    _cards.nonEmpty
  }

  /**
   * Removes a card from the deck.
   *
   * @param card The card to remove from the deck.
   */
  def removeCard(card: ICard): Unit = {
    _cards -= card
  }

  /**
   * Draws a card from the deck.
   *
   * @return An option containing the drawn card, or None if the deck is empty.
   */
  def drawCard(): Option[ICard] = {
    if (_cards.nonEmpty) {
      val randomIndex = Random.nextInt(_cards.length)
      val card = _cards(randomIndex)
      removeCard(card)
      Some(card)
    } else {
      None
    }
  }

  /**
   * Shuffles the cards in the deck.
   */
  def shuffle(): Unit = {
    _cards = Random.shuffle(_cards)
  }

  /**
   * Returns a string representation of the deck.
   *
   * @return A string containing the list of cards in the deck.
   */
  override def toString: String = s"Deck(cards=${_cards.mkString(", ")})"

  /**
   * Spreads the weather effect of a weather card to all cards in the deck.
   *
   * @param weatherCard The weather card with the weather effect to spread.
   */
  def spreadWeatherEffect(weatherCard: IWeatherCard): Unit = {
    for (card <- _cards) weatherCard.applyCardEffect(card)
  }
}
