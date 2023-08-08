package scala.gwent.model.player

import scala.gwent.controller.IObserverGame

/**
 * A trait representing a subject in the GWENT game that observers can monitor.
 *
 * The `ISubjectGame` trait defines the basic interface for subjects in the GWENT game that observers can monitor. A subject
 * represents an entity in the game that observers are interested in, and it provides methods to manage observers and notify
 * them about changes in the subject's state.
 */
trait ISubjectGame {

  /**
   * The name of the subject.
   *
   * The `name` field represents the name of the subject. It provides a unique identifier for the subject, allowing
   * observers to distinguish different subjects.
   */
  val name: String

  /**
   * Checks if the subject has no gems remaining.
   *
   * The `hasNoGems` method determines if the subject has no gems remaining. It returns `true` if the subject's gem count
   * is zero, indicating that the subject has lost the game; otherwise, it returns `false`.
   *
   * @return `true` if the subject has no gems, otherwise `false`.
   */
  def hasNoGems: Boolean

  /**
   * Subscribes an observer to the subject's notifications.
   *
   * The `subscribe` method allows an observer to subscribe to notifications from the subject. Once subscribed, the observer
   * will be notified about changes in the subject's state.
   *
   * @param observer The observer to be subscribed.
   */
  def suscribe(observer: IObserverGame): Unit

  /**
   * Notifies the subscribed observer about a change in the subject's state.
   *
   * The `notifyObserver` method triggers a notification to the observer that the subject's state has changed. This method
   * is typically called by the subject when a relevant event occurs.
   */
  def notifyObserver(): Unit

}