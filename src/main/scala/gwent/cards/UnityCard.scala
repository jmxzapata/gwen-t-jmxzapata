package scala.gwent.cards

/**
 * A concrete class representing a unity card in GWENT.
 *
 * This class extends the `AbstractCard` class and implements the `IUnityCard` trait to represent a specific type of card
 * in the card game. Unity cards are cards that have a classification (from the `Classification` enumeration) and a strength value.
 * The `UnityCard` class provides a complete implementation for unity cards, including their name, effect, classification, and strength.
 *
 * @param name           The name of the unity card.
 * @param effect         The effect of the unity card, representing its special ability or functionality.
 * @param classification The classification of the unity card (from the `Classification` enumeration).
 * @param strength       The strength value of the unity card.
 */
class UnityCard(
                 name: String,
                 effect: String,
                 override val classification: Classification,
                 override val strength: Int
               ) extends AbstractCard(name, effect) with IUnityCard {

  /**
   * Converts the unity card to a string representation.
   *
   * @return A string representation of the unity card, including its name, effect, classification, and strength.
   */
  override def toString: String = s"UnityCard(name=$name, effect=$effect, " +
    s"classification=$classification, strength=$strength)"

  /**
   * Checks if this unity card can be compared with the given object.
   *
   * @param other The other object to compare with.
   * @return True if the other object is an `UnityCard` instance, otherwise false.
   */
  override def canEqual(other: Any): Boolean = other.isInstanceOf[UnityCard]

  /**
   * Checks if this unity card is equal to the given object.
   *
   * @param other The other object to compare with.
   * @return True if the other object is an `UnityCard` instance with the same properties, otherwise false.
   */
  override def equals(other: Any): Boolean = other match {
    case that: UnityCard =>
      super.equals(that) &&
        (that canEqual this) &&
        classification == that.classification &&
        strength == that.strength
    case _ => false
  }

  /**
   * Computes the hash code for this unity card.
   *
   * @return The hash code value for this unity card based on its properties.
   */
  override def hashCode(): Int = {
    val state = Seq(super.hashCode(), classification, strength)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}
