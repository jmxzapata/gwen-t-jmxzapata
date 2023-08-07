package scala.gwent.controller

import scala.collection.mutable.ListBuffer
import scala.gwent.model.player.Player
import scala.gwent.controller.state
import scala.gwent.controller.state.{IState, InitGame}

/**
 * The GameController class handles the game flow and logic.
 *
 * The GameController class is responsible for managing the game flow and logic. It controls the rounds and turns
 * of the game, deals cards to players, and determines the winner at the end of the game.
 *
 * @constructor Creates a new GameController with two players, each having their own deck and hand.
 */
class GameController {

  /**
   * The first player in the game.
   */
  var player1 = new Player("Player 1")

  /**
   * The second player in the game.
   */
  var player2 = new Player("Player 2")

  /**
   * Plays a single round of the game.
   *
   * The playRound method simulates a single round of the game. Players take turns playing their cards until both
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
      player1Passed = player1Passed || currentPlayer == player1 && !currentPlayer.hasCardsToPlay
      player2Passed = player2Passed || currentPlayer == player2 && !currentPlayer.hasCardsToPlay
    }

    // Check who won the round
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
   * Plays the entire game.
   *
   * The playGame method starts and manages the entire game. It shuffles the players' decks, deals cards to each player,
   * and continues playing rounds until one of the players runs out of gems. The game ends when there is a winner,
   * and the winner is displayed.
   * 
   */
  def playGame(args: Array[String]): Unit = {
    // Shuffle the players' decks
    player1.deck.shuffle()
    player2.deck.shuffle()

    // Deal 10 cards to each player
    player1.hand = ListBuffer(player1.deck.deal(10): _*)
    player2.hand = ListBuffer(player2.deck.deal(10): _*)

    // Play the game
    while (player1.gems > 0 && player2.gems > 0) {
      playRound()
    }
  }


  // AQUI SE IMPLEMENTA EL METODO STATE//

  private var currentState: IState = _

  // Método para cambiar el estado del juego
  def changeState(newState: IState): Unit = {
    currentState = newState
    currentState.setContext(this)
  }

  def startGame(): Unit = {
    // Comenzar el juego estableciendo el estado inicial (InitGame)
    currentState = new InitGame()
    currentState.setContext(this)

    // Iniciar la recursión del juego
    playGame()
  }

  private def playGame(): Unit = {
    currentState.printInfo()
    currentState.play()

    // Verificar si el juego ha terminado (estado actual es null)
    if (currentState != null) {
      playGame() // Continuar la recursión con el siguiente estado
    }
  }

  // AQUI SE IMPLEMENTA EL METODO OBSERVER //

  // Lista de observadores interesados en el resultado del juego (jugadores)
  private val players: ListBuffer[Player] = ListBuffer.empty[Player]

  // Método para agregar jugadores (observadores) al controlador
  def addPlayer(player: Player): Unit = {
    players += player
  }

  // Método para eliminar jugadores (observadores) del controlador
  def removePlayer(player: Player): Unit = {
    players -= player
  }

  // Método para notificar al PlayerTurn que el jugador ganó la partida
  def playerWonGame(player: Player): Unit = {
    players.foreach(_.playerWonGame(player))
  }

  // Método para notificar al PlayerTurn que el jugador perdió la partida
  def playerLostGame(player: Player): Unit = {
    players.foreach(_.playerLostGame(player))
  }

}
