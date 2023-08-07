package scala.gwent.controller.state

import scala.gwent.controller.GameController
import scala.gwent.controller.state
import scala.gwent.model.player.Player

class InitGame extends IState {
  private var context: GameController = _

  private val player: Player = null
  private val gameController: GameController = null

  override def setContext(context: GameController): Unit = {
    this.context = context
  }

  override def printInfo(): Unit = {
    println("Iniciando el juego...")
  }

  override def play(): Unit = {
    // Los metodos de juego estan en GameController, no se si es necesario anotar algo mas aca, pienso que no

    // Cambiar al siguiente estado (PlayerTurn)
    context.changeState(new PlayerTurn(player, gameController))
  }
}