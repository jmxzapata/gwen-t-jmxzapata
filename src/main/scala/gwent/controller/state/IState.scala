package scala.gwent.controller.state

import scala.gwent.controller.GameController

/**
 * Represents a state in the game GWENT.
 *
 * This trait defines the common structure for different game states, providing methods for printing information
 * about the state and for executing the gameplay logic associated with the state.
 */
trait IState {
  /**
   * The game controller that manages the game state.
   */
  val context: GameController

  /**
   * Flag indicating whether the current state represents the end of the game.
   */
  var isEndGame: Boolean = false

  /**
   * Prints information specific to the current game state.
   */
  def printInfo(): Unit

  /**
   * Executes the gameplay logic associated with the current game state.
   */
  def play(): Unit
}
