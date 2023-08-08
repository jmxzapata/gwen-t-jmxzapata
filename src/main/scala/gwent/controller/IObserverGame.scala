package scala.gwent.controller

import scala.gwent.model.player.{ISubjectGame, Player}

/**
 * Represents an observer in the GWENT game, responsible for monitoring game events.
 *
 * The `IObserverGame` trait defines a contract for implementing game observers. Game observers are entities that
 * monitor specific subjects (players or other game components) and react to changes or events that occur during the
 * course of the game. Observers are notified by subjects when events of interest happen.
 */
trait IObserverGame {
  /**
   * Updates the observer with information about a change in the specified subject.
   *
   * The `update` method is invoked by subjects to notify the observer about changes in the subject's state. This
   * method is intended to be overridden by concrete observer implementations to define specific behavior when updates
   * occur.
   *
   * @param subject The subject that triggered the update.
   */
  def update(subject: ISubjectGame): Unit
}
