package scala.gwent.controller.state

import scala.gwent.controller.GameController
import scala.gwent.model.player.Player
import scala.io.StdIn
import scala.gwent.controller.state.CpuTurn
import scala.gwent.model.cards.Card
import scala.gwent.model.cards.unity.{CloseCombatCard, RangedCombatCard, SiegeCombatCard}
import scala.gwent.model.board.Board

/**
 * Represents the player's turn state in the game GWENT.
 *
 * This class defines the behavior of the game when it's the player's turn. It provides methods for printing
 * information about the state and for executing the gameplay logic associated with the player's turn.
 *
 * @param context The game controller managing the game state.
 */
class PlayerTurn(override val context: GameController) extends IState {
  /**
   * The player whose turn it is.
   */
  private val player: Player = this.context.player1

  /**
   * Prints information about the player's turn state.
   */
  override def printInfo(): Unit = {
    println("Es el turno del jugador.")
  }

  /**
   * Executes the gameplay logic for the player's turn state.
   */
  override def play(): Unit = {
    println("Opciones:")
    println("1. Jugar una carta")
    println("2. Pasar el turno")

    print("> ")
    val choice = StdIn.readInt()

    choice match {
      case 1 =>
        println("Has elegido jugar una carta.")

        println("Quitando una gema de forma manual...")
        context.player2.loseGem()

        if (context.observerGame.somePlayerLost()) {
          context.changeState(new EndGame(context))
        }
      case 2 =>
        println("Has pasado el turno.")
        context.changeState(new CpuTurn(context))
    }
  }
}
