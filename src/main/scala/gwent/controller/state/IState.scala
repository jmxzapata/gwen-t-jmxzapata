package scala.gwent.controller.state

import scala.gwent.controller.GameController

trait IState {
  // Establecer el contexto del estado para la comunicación bidireccional
  def setContext(context: GameController): Unit

  // Imprimir información sobre el estado actual
  def printInfo(): Unit

  // Método principal para ejecutar la lógica del estado actual
  def play(): Unit
}
