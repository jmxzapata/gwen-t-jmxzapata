package scala.gwent.controller

import scala.gwent.model.player.ISubjectGame

/**
 * Represents an observer in the GWENT game that monitors player losses.
 *
 * The `ObserverGame` class implements the `IObserverGame` trait, defining an observer responsible for monitoring game
 * events related to player losses. This observer keeps track of players who have lost the game by running out of gems.
 * It updates its state based on notifications from subjects (players) and provides information about the losing player.
 *
 * @constructor Creates a new instance of the `ObserverGame` observer.
 */
class ObserverGame extends IObserverGame {
  private var loserPlayer: ISubjectGame = _

  /**
   * Updates the observer with information about a change in the specified subject.
   *
   * The `update` method is invoked by subjects to notify the observer about changes in the subject's state. In this
   * implementation, the observer keeps track of the player who has lost the game (i.e., run out of gems).
   *
   * @param subject The subject (player) that triggered the update.
   */
  override def update(subject: ISubjectGame): Unit = {
    if (subject.hasNoGems) {
      loserPlayer = subject
    }
  }

  /**
   * Retrieves the name of the player who lost the game.
   *
   * The `nameLoserPlayer` method provides the name of the player who has lost the game. It returns the name of the
   * player that was detected as losing the game based on the observer's state.
   *
   * @return The name of the losing player, or `null` if no player has lost yet.
   */
  def nameLoserPlayer: String = loserPlayer.name

  /**
   * Checks if any player has lost the game.
   *
   * The `somePlayerLost` method determines if any player has lost the game based on the state of the observer. It returns
   * `true` if a losing player has been detected; otherwise, it returns `false`.
   *
   * @return `true` if a player has lost the game, otherwise `false`.
   */
  def somePlayerLost(): Boolean = {
    loserPlayer != null
  }
}

