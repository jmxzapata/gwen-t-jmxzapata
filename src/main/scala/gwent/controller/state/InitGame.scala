package scala.gwent.controller.state

import scala.collection.mutable.ListBuffer
import scala.gwent.controller.GameController
import scala.gwent.controller.state
import scala.gwent.model.player.Player

/**
 * Represents the initial state of the game where players' decks are shuffled, cards are dealt, and the game begins.
 *
 * This state is reached at the beginning of the game, setting up the initial conditions for the gameplay.
 *
 * @param context The game controller managing the game state.
 */
class InitGame(override val context: GameController) extends IState {

  /**
   * Prints information about the start of the game.
   */
  override def printInfo(): Unit = {
    println("Iniciando el juego...")
  }

  /**
   * Executes the initial actions for starting the game.
   *
   * This method shuffles the players' decks, deals cards to each player's hand, subscribes players to the game observer,
   * and transitions the game state to the PlayerTurn.
   */
  override def play(): Unit = {

    val player1 = context.player1
    val player2 = context.player2

    println("Mezclando mazos...")
    player1.deck.shuffle()
    player2.deck.shuffle()

    println("Los jugadores están tomando cartas...")
    player1.hand = ListBuffer(player1.deck.deal(10): _*)
    player2.hand = ListBuffer(player2.deck.deal(10): _*)

    // Subscribe players to the game observer
    player1.suscribe(context.observerGame)
    player2.suscribe(context.observerGame)
    
    // Transition to the PlayerTurn state
    context.changeState(new PlayerTurn(context))
  }
}