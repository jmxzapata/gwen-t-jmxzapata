package cl.uchile.dcc
package gwent.cards

import gwent.cards.ICard

/**
 * An abstract class representing a card in the Gwent game.
 *
 * @param name        The name of the card.
 * @param description The description of the card.
 */
abstract class AbstractCard(
                             override val name: String,
                             override val description: String
                           ) extends ICard with Equals {

  /**
   * Checks if the provided object can be equal to this card.
   *
   * @param that The object to compare.
   * @return True if the object can be equal to this card, false otherwise.
   */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[AbstractCard]

  /**
   * Compares this card with another object for equality.
   *
   * @param other The object to compare.
   * @return True if the cards are equal, false otherwise.
   */
  override def equals(other: Any): Boolean = other match {
    case that: AbstractCard =>
      (that canEqual this) &&
        name == that.name &&
        description == that.description
    case _ => false
  }

  /**
   * Generates a hash code for this card.
   *
   * @return The hash code of the card.
   */
  override def hashCode(): Int = {
    val state = Seq(name, description)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}