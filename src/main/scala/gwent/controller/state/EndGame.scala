package scala.gwent.controller.state

import scala.gwent.controller.GameController

class EndGame extends IState {
  private var context: GameController = _

  override def setContext(context: GameController): Unit = {
    this.context = context
  }

  override def printInfo(): Unit = {
    println("El juego GWENT ha terminado.")
  }

  override def play(): Unit = {

    // En este caso, no hay siguiente estado ya que el juego ha terminado
  }
}