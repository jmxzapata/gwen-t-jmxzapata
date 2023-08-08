package scala.gwent.controller.state

import munit.FunSuite

import scala.gwent.controller.GameController
import scala.gwent.model.player.Player

/**
 * The `InitGameTest` class defines test cases to ensure the correct behavior of the `InitGame` class, which represents
 * the initial state of the GWENT game. The tests focus on verifying that the game transitions from the initial state
 * to the `PlayerTurn` state after the `play` method is called.
 */
class InitGameTest extends FunSuite {

  /**
   * The `testPlayStateTransitionToPlayerTurn` test case verifies that the game transitions from the initial state
   * to the `PlayerTurn` state after the `play` method is called. It creates mock players and a game context,
   * then triggers the `play` method of the `InitGame` state. The test ensures that the game's state changes to
   * `PlayerTurn` as expected.
   */
  test("Test play - State Transition to PlayerTurn") {
    // Arrange: Create mock players and game context
    val player1 = new Player("Player 1")
    val player2 = new Player("Player 2")
    val context = new GameController()
    val initState = new InitGame(context)

    // Act: Trigger the play method of the InitGame state
    initState.play()

    // Assert: Verify that the state transitions to PlayerTurn
    assert(context.state.isInstanceOf[PlayerTurn])
  }
}
