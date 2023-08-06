package scala.gwent.controller.state

import scala.gwent.controller.GameController
import scala.io.StdIn

class PlayerTurn extends IState {
  private var context: GameController = _

  override def setContext(context: GameController): Unit = {
    this.context = context
  }

  override def printInfo(): Unit = {
    println("Es el turno del jugador.")
  }

  override def play(): Unit = {
    // Realizar acciones específicas para el turno del jugador:

    // 1. Imprimir opciones disponibles para el jugador
    println("Opciones:")
    println("1. Jugar una carta")
    println("2. Pasar el turno")

    // 2. Obtener la elección del jugador
    val choice = StdIn.readInt()

    // 3. Realizar acciones basadas en la elección del jugador
    choice match {
      case 1 =>
        // El jugador eligió jugar una carta (implementa la lógica según las reglas del juego)
        println("Has elegido jugar una carta.")
      // ... implementa la lógica para jugar una carta ...
      case 2 =>
        // El jugador eligió pasar el turno
        println("Has pasado el turno.")
        // Cambiar al siguiente estado (CpuTurn)
        context.changeState(new CpuTurn())
    }
  }
}