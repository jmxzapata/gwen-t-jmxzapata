package cl.uchile.dcc
package gwent

import cl.uchile.dcc.gwent.cards.{Deck, ICard}

import scala.collection.Seq

/**
 * A class representing a player in the Gwent game.
 *
 * @param name        The name of the player.
 * @param gemsCounter The number of gems the player has.
 * @param deck        The player's deck of cards.
 */
class Player(
              val name: String,
              var gemsCounter: Int,
              var deck: List[ICard]
            ) {
  var cardsInHand: List[ICard] = List()

  /**
   * A private method that takes two parameters and returns a boolean value.
   *
   * @param x An integer parameter.
   * @param y A string parameter.
   * @return True.
   */
  protected def metodoPrivado(x: Int, y: String): Boolean = {
    true
  }

  /**
   * Draws a card from the player's deck and adds it to their hand.
   */
  def drawCard(): Unit = {
    if (deck.nonEmpty) {
      val card = deck.head
      deck = deck.tail
      cardsInHand = cardsInHand :+ card
    }
  }

  /**
   * Plays a card from the player's hand.
   * TODO: Implement this method!
   */
  def playCard(): Unit = {
    // Write the implementation here!
  }

  /**
   * Returns a string representation of the player.
   *
   * @return The string representation of the player.
   */
  override def toString: String =
    s"Player(cardsInHand=$cardsInHand, name=$name, gemsCounter=$gemsCounter, deck=$deck)"

  /**
   * Checks if this player can be compared to the given object for equality.
   *
   * @param other The object to compare.
   * @return True if the other object is an instance of `Player`, false otherwise.
   */
  private def canEqual(other: Any): Boolean = other.isInstanceOf[Player]

  /**
   * Checks if this player is equal to the given object.
   *
   * @param other The object to compare.
   * @return True if the other object is an instance of `Player` and has the same properties, false otherwise.
   */
  override def equals(other: Any): Boolean = other match {
    case that: Player =>
      (that canEqual this) &&
        cardsInHand == that.cardsInHand &&
        name == that.name &&
        gemsCounter == that.gemsCounter &&
        deck == that.deck
    case _ => false
  }

  /**
   * Calculates the hash code value for the player.
   *
   * @return The hash code value.
   */
  override def hashCode(): Int = {
    val state = Seq(cardsInHand, name, gemsCounter, deck)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}

