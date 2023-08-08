package scala.gwent.model.cards

/**

The ISubjectCard trait represents a subject for observers in the Gwent game.
A subject maintains a list of observers and notifies them when there are updates to the subject.
@note All methods in this trait are abstract and must be implemented by concrete classes that extend it.
 */
trait ISubjectCard {
  /**

  Adds an observer to the list of observers.
   */
  def addObserver(observer: IObserverCard): Unit
  /**

  Removes an observer from the list of observers.
   */
  def removeObserver(observer: IObserverCard): Unit
  /**

  Notifies all registered observers about an update to the subject.
  @param card The card that the observers will be notified about.
   */
  def notifyObservers(card: ICard): Unit
}