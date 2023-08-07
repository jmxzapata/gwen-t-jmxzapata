package scala.gwent.controller.state

import scala.gwent.model.player.Player

trait IObserverGame {
  def playerWonGame(player: Player): Unit

  def playerLostGame(player: Player): Unit
  
}
