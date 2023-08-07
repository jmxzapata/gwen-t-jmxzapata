package scala.gwent.controller.state

import scala.gwent.controller.GameController
import scala.gwent.model.player.Player
import scala.io.StdIn

class CpuTurn(cpuPlayer: Player, gameController: GameController) extends IState {
  private var context: GameController = _

  override def setContext(context: GameController): Unit = {
    this.context = context
  }

  override def printInfo(): Unit = {
    println("Es el turno de la CPU.")
  }

  override def play(): Unit = {
    // Realizar acciones específicas para el turno de la CPU

    // 1. Imprimir opciones disponibles para la CPU
    println("Opciones:")
    println("1. Jugar una carta")
    println("2. Pasar el turno")

    // 2. Obtener la elección de la CPU (simulación de elección aleatoria)
    val choice = scala.util.Random.nextInt(2) + 1

    // 3. Realizar acciones basadas en la elección de la CPU
    choice match {
      case 1 =>
        // La CPU eligió jugar una carta (implementa la lógica según las reglas del juego)
        println("La CPU ha elegido jugar una carta.")
      // ... implementa la lógica para jugar una carta ...
      case 2 =>
        // La CPU eligió pasar el turno
        println("La CPU ha pasado el turno.")
        // Cambiar al siguiente estado (PlayerTurn)
        context.changeState(new PlayerTurn(player, gameController))
    }
  }

  // AQUI SE IMPLEMEMTA OBSERVER //

  // Método para notificar al GameController si el jugador CPU ganó la partida
  private def notifyCpuWonGame(): Unit = {
    gameController.playerWonGame(cpuPlayer)
  }

  // Método para notificar al GameController si el jugador CPU perdió la partida
  private def notifyCpuLostGame(): Unit = {
    gameController.playerLostGame(cpuPlayer)
  }

}