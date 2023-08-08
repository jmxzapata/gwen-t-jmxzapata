package scala.gwent.controller.state

import munit.FunSuite

import scala.gwent.controller.ObserverGame
import scala.gwent.model.player.Player

/**
 * The `EndGameTest` class defines test cases to ensure the correct behavior of the `EndGame` class, which represents
 * the end state of the GWENT game. The tests focus on verifying that the end game state is handled appropriately.
 */
class EndGameTest extends FunSuite {

  /**
   * The `testPlay` test case verifies the behavior of the play method in the context of the EndGame state. It simulates
   * the condition where a player has lost the game, triggering the end of the game. The test ensures that the play
   * method correctly sets the `isEndGame` flag to true, indicating that the game has ended.
   */
  test("Test play") {
    // Arrange: Create mock players and observer
    val player1 = new Player("Player 1")
    val player2 = new Player("Player 2")
    val observerGame = new ObserverGame()

    // Act: Simulate a player losing the game and trigger end game state
    observerGame.update(player1)
    val endGameState = new EndGame(null)
    endGameState.play()

    // Assert: Verify that the end game state is properly set
    assertEquals(endGameState.isEndGame, true)
  }
}
