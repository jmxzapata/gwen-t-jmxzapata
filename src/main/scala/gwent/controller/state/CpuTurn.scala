package scala.gwent.controller.state

import scala.gwent.controller.GameController
import scala.gwent.model.player.Player
import scala.io.StdIn

/**
 * Represents the state of the game when it's the CPU's turn to play.
 *
 * @param context The game controller managing the game state.
 */
class CpuTurn(override val context: GameController) extends IState {
  private val player: Player = this.context.player2

  /**
   * Prints information about the current state.
   */
  override def printInfo(): Unit = {
    println("Es el turno de la CPU.")
  }

  /**
   * Plays the CPU's turn.
   */
  override def play(): Unit = {
    val choice = scala.util.Random.nextInt(2) + 1

    choice match {
      case 1 =>
        println("La CPU ha elegido jugar una carta.")

        // Check if the player has lost all gems and change the game state if needed
        if (context.observerGame.somePlayerLost()) {
          context.changeState(new EndGame(context))
        }
      case 2 =>
        println("La CPU ha pasado el turno.")
        context.changeState(new PlayerTurn(context))
    }
  }
}