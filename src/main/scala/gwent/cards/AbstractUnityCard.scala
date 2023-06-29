package cl.uchile.dcc
package gwent.cards

/**
 * An abstract class representing a unity card in the Gwent game.
 *
 * @param name        The name of the card.
 * @param description The description of the card.
 * @param power       The power value of the card.
 */
abstract class AbstractUnityCard(
                                  override val name: String,
                                  override val description: String,
                                  override val power: Int
                                ) extends AbstractCard(name, description) with IUnityCard {

  /**
   * The current power value of the card.
   */
  var currentPower: Int = power

  /**
   * Checks if the provided object can be equal to this unity card.
   *
   * @param other The object to compare.
   * @return True if the object can be equal to this unity card, false otherwise.
   */
  override def canEqual(other: Any): Boolean = other.isInstanceOf[AbstractUnityCard]

  /**
   * Compares this unity card with another object for equality.
   *
   * @param other The object to compare.
   * @return True if the unity cards are equal, false otherwise.
   */
  override def equals(other: Any): Boolean = other match {
    case that: AbstractUnityCard =>
      super.equals(that) &&
        (that canEqual this) &&
        currentPower == that.currentPower &&
        power == that.power
    case _ => false
  }

  /**
   * Generates a hash code for this unity card.
   *
   * @return The hash code of the unity card.
   */
  override def hashCode(): Int = {
    val state = Seq(super.hashCode(), currentPower, power)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}
