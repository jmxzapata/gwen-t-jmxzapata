package cl.uchile.dcc
package gwent.cards

/**
 * The `CardComponent` trait represents the common interface for card components in the Gwent game.
 * It defines the operations that can be performed on card components, such as calculating the total power,
 * applying morale boost, and applying tight bond effect.
 * This trait is part of the Composite pattern.
 */
trait ICardComponent {

  /**
   * Calculates the total power of the card component.
   *
   * @return The total power of the card component.
   */
  def totalPower: Int

  /**
   * Applies the morale boost effect to the card component.
   */
  def applyMoraleBoost(): Unit

  /**
   * Applies the tight bond effect to the card component.
   */
  def applyTightBond(): Unit
}
