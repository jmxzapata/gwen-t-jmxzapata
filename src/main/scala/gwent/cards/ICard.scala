package cl.uchile.dcc
package gwent.cards

/**
 * An interface representing a card in the Gwent game.
 */
trait ICard {
  /**
   * The name of the card.
   */
  val name: String

  /**
   * The description of the card.
   */
  val description: String

  /**
   * Applies the morale boost effect to a deck of cards.
   *
   * @param deck The deck of cards to apply the effect to.
   */
  def applyMoraleBoost(deck: List[ICard]): Unit

  /**
   * Applies the tight bond effect to a deck of cards.
   *
   * @param deck The deck of cards to apply the effect to.
   */
  def applyTightBond(deck: List[ICard]): Unit
}

