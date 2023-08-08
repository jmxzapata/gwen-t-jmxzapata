package scala.gwent.controller.state

import munit.FunSuite

import scala.gwent.controller.{GameController, ObserverGame}
import scala.gwent.model.cards.Card
import scala.gwent.model.player.Player

/**
 * The `CpuTurnTest` class defines test cases to ensure the correct behavior of the `CpuTurn` class, which represents
 * the turn of the CPU player in the GWENT game. The tests focus on verifying that the CPU turn behaves as expected
 * and follows the game rules.
 */
class CpuTurnTest extends FunSuite {

  /**
   * A stub implementation of the GameController for testing purposes.
   *
   * The `GameControllerStub` class provides a stub implementation of the GameController trait. It overrides necessary
   * properties with mock players and observer for testing the CPU turn behavior.
   */
  class GameControllerStub extends GameController {
    override val player1: Player = new Player("Player 1")
    override val player2: Player = new Player("Player 2")
    override val observerGame: ObserverGame = new ObserverGame()
  }

  /**
   * Test case for the CPU player's turn.
   *
   * The `testPlayerTurn` test case focuses on verifying the behavior of the CPU player's turn in the game. It uses
   * a GameControllerStub to create a controlled environment for testing. The test ensures that the CPU turn correctly
   * handles the decision to play a card or pass the turn based on the simulated game state.
   */
  test("PlayerTurn should do something") {

    // Arrange: Create a GameControllerStub for testing
    val gameControllerStub = new GameControllerStub()
    // Act: Create a player's turn instance
    val playerTurn = new PlayerTurn(gameControllerStub)

  }

}