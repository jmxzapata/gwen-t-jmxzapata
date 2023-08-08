package scala.gwent.controller.state

import scala.gwent.controller.GameController


/**
 * Represents the state of the game when it has reached the end due to a player losing.
 *
 * This state is reached when one of the players has lost all their gems, signifying the end of the game.
 *
 * @param context The game controller managing the game state.
 */
class EndGame(override val context: GameController) extends IState {

  /**
   * Prints information about the end of the game and the losing player.
   */
  override def printInfo(): Unit = {
    val loserName = context.observerGame.nameLoserPlayer
    println(s"El jugador '$loserName' ha perdido")
    println("El juego GWENT ha terminado.")
  }

  /**
   * Sets the game's end flag to true, indicating that the game has ended.
   */
  override def play(): Unit = {
    this.isEndGame = true
  }
}