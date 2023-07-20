package scala.gwent.model.board

/**
 * A trait representing a composite component in the card game.
 *
 * The IGameComposite trait is a part of the card game system and represents a composite component that can
 * contain other game components. It extends the IGameComponent trait, which means that it is also affected
 * by weather cards like other game components.
 *
 * This trait serves as a marker trait for composite components and does not add any additional methods or
 * functionality on top of the IGameComponent trait.
 */
trait IGameComposite extends IGameComponent
