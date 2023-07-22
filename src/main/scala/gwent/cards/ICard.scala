package scala.gwent.cards

/**
 * A trait representing a card in a card game.
 *
 * This trait defines the basic properties of a card in a card game, such as its name and effect.
 * Any class implementing this trait must provide concrete implementations for the `name` and `effect` properties.
 */
trait ICard {
  /** Name of the card.
   *
   * This property represents the name or title of the card.
   * It is a read-only property that must be defined in concrete implementations of this trait.
   */
  val name: String

  /** Effect of the card. Its special ability.
   *
   * This property represents the special effect or ability of the card in the card game.
   * It is a read-only property that must be defined in concrete implementations of this trait.
   */
  val effect: String
}