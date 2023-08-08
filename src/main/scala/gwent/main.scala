package scala.gwent

import scala.gwent.controller.GameController

@main
def main(): Unit = {
  println("Este codigo compila!")
  val myList: List[Int] = List[Int](3, 5, 6)
  val num = myList.head
  val gameController = new GameController()
  gameController.playGame()
}