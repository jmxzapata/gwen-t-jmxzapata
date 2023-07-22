package scala.gwent.cards

/**
 * An abstract class representing a generic card in a card game.
 *
 * This class extends the `ICard` trait and provides a base implementation for generic cards in the card game.
 * The `AbstractCard` class includes properties for the card's name and effect, and it also implements the `Equals` trait.
 * Subclasses of `AbstractCard` should implement their specific card types by providing appropriate values for the name and effect.
 *
 * @param name   The name of the card.
 * @param effect The effect of the card, representing its special ability or functionality.
 */
abstract class AbstractCard(
                             override val name: String,
                             override val effect: String
                           ) extends ICard with Equals {

  /**
   * Checks if this card is equal to the given object.
   *
   * @param other The other object to compare with.
   * @return True if the other object is an `AbstractCard` instance with the same name and effect, otherwise false.
   */
  override def equals(other: Any): Boolean = other match {
    case that: AbstractCard =>
      (that canEqual this) &&
        name == that.name &&
        effect == that.effect
    case _ => false
  }

  /**
   * Computes the hash code for this card.
   *
   * @return The hash code value for this card based on its name and effect.
   */
  override def hashCode(): Int = {
    val state = Seq(name, effect)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}


