package scala.gwent.model.board

/**
 * A trait representing a leaf component in the card game.
 *
 * The IGameLeaf trait is a part of the card game system and represents a leaf component that cannot
 * contain other game components. It extends the IGameComponent trait, which means that it is affected
 * by weather cards like other game components.
 *
 * This trait serves as a marker trait for leaf components and does not add any additional methods or
 * functionality on top of the IGameComponent trait.
 */
trait IGameLeaf extends IGameComponent
