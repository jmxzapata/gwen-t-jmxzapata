package scala.gwent.model.player

import munit.FunSuite

import scala.collection.mutable.ListBuffer
import scala.gwent.model.board.BoardSection
import scala.gwent.model.board.zone.WeatherZone
import scala.gwent.model.cards.unity.{CloseCombatCard, RangedCombatCard, SiegeCombatCard}
import scala.gwent.model.cards.unity.effects.{AbstractEffectCard, MoralBoostEffect}
import scala.gwent.model.cards.weather.{BitingFrostEffect, IWeatherCard}
import scala.gwent.model.cards.{Deck, ICard, IObserverCard}

/**
 * The `PlayerTest` class defines test cases to ensure the correct behavior of the `Player` class, which represents a player
 * in the GWENT game. The tests focus on verifying the getter and setter methods, as well as the behavior of the player's
 * turn and resource management.
 */
class PlayerTest extends FunSuite {

  /**
   * The `testBoardSectionGetterAndSetter` test case verifies that the `boardSection` getter and setter methods of the
   * `Player` class function correctly. It creates a player, a board section, and assigns the board section to the player.
   * The test asserts that the board section retrieved from the player matches the assigned board section.
   */
  test("Test boardSection getter and setter") {
    // Arrange: Create a player, a board section, and assign the board section to the player
    val player: Player = new Player("PlayerName")
    val weatherZone: WeatherZone = new WeatherZone()
    val boardSection: BoardSection = new BoardSection(weatherZone)
    player.boardSection = boardSection
    // Act & Assert: Verify that the retrieved board section matches the assigned board section
    assert(player.boardSection == boardSection)
  }

  /**
   * This test verifies that the `strength` getter of the `Player` class returns the expected initial value of 0.
   */
  test("Test strength getter") {
    val player: Player = new Player("PlayerName")
    val weatherZone: WeatherZone = new WeatherZone()
    val boardSection: BoardSection = new BoardSection(weatherZone)

    player.boardSection = boardSection

    assert(player.strength == 0)
  }

  /**
   * This test ensures that the `gems` getter of the `Player` class returns the expected initial value of 2.
   */
  test("Test gems getter") {
    val player: Player = new Player("PlayerName")

    assert(player.gems == 2)
  }

  /**
   * This test checks the functionality of the `hand` getter and setter methods of the `Player` class. It assigns a hand of
   * cards to the player and verifies if the retrieved hand matches the assigned one.
   */
  test("Test hand getter and setter") {
    val player: Player = new Player("PlayerName")
    val hand: ListBuffer[ICard] = ListBuffer.empty

    player.hand = hand

    assert(player.hand == hand)
  }

  /**
   * This test checks whether the `hasCardsToPlay` method of the `Player` class returns `true` when the player's hand contains
   * at least one card.
   */
  test("Test hasCardsToPlay with non-empty hand") {
    val player: Player = new Player("PlayerName")
    player.hand += new CloseCombatCard("CardName", "CardDescription", 10, null)

    assert(player.hasCardsToPlay)
  }

  /**
   * This test ensures that the `hasCardsToPlay` method of the `Player` class returns `false` when the player's hand is empty.
   */
  test("Test hasCardsToPlay with empty hand") {
    val player: Player = new Player("PlayerName")

    assert(!player.hasCardsToPlay)
  }

  test("Test takeTurn with CloseCombatCard") {
    val player: Player = new Player("PlayerName")
    val weatherZone: WeatherZone = new WeatherZone()
    val boardSection: BoardSection = new BoardSection(weatherZone)
    player.boardSection = boardSection
    val card: CloseCombatCard = new CloseCombatCard("CardName", "CardDescription", 10, null)
    player.hand += card

    player.takeTurn()

    assert(boardSection.closeZone.cards.contains(card))
    assert(player.hand.isEmpty)
  }

  test("Test takeTurn with RangedCombatCard") {
    val player: Player = new Player("PlayerName")
    val weatherZone: WeatherZone = new WeatherZone()
    val boardSection: BoardSection = new BoardSection(weatherZone)
    player.boardSection = boardSection
    val card: RangedCombatCard = new RangedCombatCard("CardName", "CardDescription", 10, null)
    player.hand += card

    player.takeTurn()

    assert(boardSection.rangedZone.cards.contains(card))
    assert(player.hand.isEmpty)
  }

  test("Test takeTurn with SiegeCombatCard") {
    val player: Player = new Player("PlayerName")
    val weatherZone: WeatherZone = new WeatherZone()
    val boardSection: BoardSection = new BoardSection(weatherZone)
    player.boardSection = boardSection
    val card: SiegeCombatCard = new SiegeCombatCard("CardName", "CardDescription", 10, null)
    player.hand += card

    player.takeTurn()

    assert(boardSection.siegeZone.cards.contains(card))
    assert(player.hand.isEmpty)
  }

  /**
   * This test validates that the `hasNoGems` method of the `Player` class returns `true` when the player has no gems left.
   */
  test("Test hasNoGems with no gems") {
    val player: Player = new Player("PlayerName")

    assert(!player.hasNoGems)
  }

}