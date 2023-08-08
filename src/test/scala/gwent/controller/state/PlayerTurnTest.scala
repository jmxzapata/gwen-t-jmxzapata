package scala.gwent.controller.state

import munit.FunSuite

import scala.gwent.controller.{GameController, IObserverGame, ObserverGame}
import scala.gwent.model.board.BoardSection
import scala.gwent.model.board.zone.WeatherZone
import scala.gwent.model.player.Player
import munit.Clue.generate

/**
 * The `PlayerTurnTest` class defines test cases to ensure the correct behavior of the `PlayerTurn` class, which represents
 * the state where a player takes their turn in the GWENT game. The tests focus on verifying the initialization and behavior
 * of the `PlayerTurn` state.
 */
class PlayerTurnTest extends FunSuite {

  /**
   * The `GameControllerStub` class is a stubbed version of the `GameController` class. It provides mock implementations
   * of players and an observer game for testing purposes.
   */
  class GameControllerStub extends GameController {
    override val player1: Player = new Player("Player 1")
    override val player2: Player = new Player("Player 2")
    override val observerGame: ObserverGame = new ObserverGame()
  }

  /**
   * The `testPlayerTurnShouldDoSomething` test case verifies that the `PlayerTurn` class behaves as expected. It creates
   * a `GameControllerStub` as the game context and instantiates a `PlayerTurn` state. The test focuses on initializing
   * the `PlayerTurn` state and does not perform further assertions.
   */
  test("PlayerTurn should do something") {
    // Arrange: Create a stubbed GameController for testing
    val gameControllerStub = new GameControllerStub()

    // Act: Instantiate a PlayerTurn state
    val playerTurn = new PlayerTurn(gameControllerStub)

  }

}

