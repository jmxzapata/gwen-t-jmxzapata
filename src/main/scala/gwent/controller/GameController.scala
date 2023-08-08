package scala.gwent.controller

import scala.collection.mutable.ListBuffer
import scala.gwent.model.player.Player
import scala.gwent.controller.state
import scala.gwent.controller.state.{IState, InitGame}

/**
 * Manages the game state and gameplay logic for the GWENT game.
 *
 * The `GameController` class handles various aspects of the game, including managing player turns, playing rounds,
 * changing game states, and determining the winner. It interacts with the player, observer, and state classes to
 * control the flow of the game.
 */
class GameController {

  /**
   * The first player in the game.
   */
  val player1 = new Player("Player 1")

  /**
   * The second player in the game.
   */
  val player2 = new Player("Player 2")

  /**
   * The observer responsible for tracking game events.
   */
  val observerGame = new ObserverGame()

  /**
   * Plays a single round of the game.
   *
   * The `playRound` method simulates a single round of the game. Players take turns playing their cards until both
   * players pass or have no more cards to play. After the round is complete, the winner of the round is determined
   * based on the total strength of their cards. The winner's gem count is reduced by 1.
   */
  def playRound(): Unit = {
    // Play turns until both players pass or have no more cards
    var player1Passed = false
    var player2Passed = false
    var currentPlayer = player1

    while (!(player1Passed && player2Passed) && currentPlayer.hasCardsToPlay) {
      println(s"--- ${currentPlayer.name}'s Turn ---")
      currentPlayer.takeTurn()
      currentPlayer = if (currentPlayer == player1) player2 else player1
      player1Passed = player1Passed || (currentPlayer == player1 && !currentPlayer.hasCardsToPlay)
      player2Passed = player2Passed || (currentPlayer == player2 && !currentPlayer.hasCardsToPlay)
    }

    // Determine the winner of the round
    val winner = if (player1.strength > player2.strength) player1 else player2

    // Reduce the winner's gems by 1
    winner.loseGem()

    // Check if the game is over
    if (player1.gems == 0 || player2.gems == 0) {
      println(s"The winner is ${winner.name}!")
      System.exit(0)
    }
  }

  /**
   * The current state of the game.
   */
  var state: IState = new InitGame(this)

  /**
   * Changes the state of the game to the specified new state.
   *
   * @param newState The new state to transition to.
   */
  def changeState(newState: IState): Unit = {
    state = newState
  }

  /**
   * Initiates and manages the entire game.
   *
   * The `playGame` method starts and oversees the entire game. It continuously iterates through game states, printing
   * information and allowing gameplay until a winner is determined and the game ends.
   */
  def playGame(): Unit = {
    while (!state.isEndGame) {
      println()  // Print a blank line for formatting
      state.printInfo()
      state.play()
    }
  }
}


