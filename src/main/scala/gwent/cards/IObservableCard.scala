package cl.uchile.dcc
package gwent.cards

import scala.collection.mutable.ListBuffer

// Interfaz del sujeto observado
trait IObservableCard {
  private val observers: ListBuffer[ICardObserver] = ListBuffer()

  def addObserver(observer: ICardObserver): Unit = {
    observers += observer
  }

  def removeObserver(observer: ICardObserver): Unit = {
    observers -= observer
  }

  def notifyObservers(card: AbstractUnityCard): Unit = {
    observers.foreach(_.update(card))
  }
}
