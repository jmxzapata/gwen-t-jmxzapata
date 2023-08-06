package scala.gwent.controller.state

import scala.gwent.controller.GameController

class InitGame extends IState {
  private var context: GameController = _

  override def setContext(context: GameController): Unit = {
    this.context = context
  }

  override def printInfo(): Unit = {
    println("Iniciando el juego...")
  }

  override def play(): Unit = {
    // Los metodos de juego estan en GameController, no se si es necesario anotar algo mas aca, pienso que no

    // Cambiar al siguiente estado (PlayerTurn)
    context.changeState(new PlayerTurn())
  }
}