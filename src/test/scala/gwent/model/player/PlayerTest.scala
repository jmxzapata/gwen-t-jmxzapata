package scala.gwent.model.player

import munit.FunSuite

import scala.collection.mutable.ListBuffer
import scala.gwent.model.board.BoardSection
import scala.gwent.model.board.zone.WeatherZone
import scala.gwent.model.cards.unity.{CloseCombatCard, RangedCombatCard, SiegeCombatCard}
import scala.gwent.model.cards.unity.effects.{AbstractEffectCard, MoralBoostEffect}
import scala.gwent.model.cards.weather.{BitingFrostEffect, IWeatherCard}
import scala.gwent.model.cards.{Deck, ICard, IObserverCard}

class PlayerTest extends FunSuite {
  test("Test boardSection getter and setter") {
    val player: Player = new Player("PlayerName")
    val weatherZone: WeatherZone = new WeatherZone()
    val boardSection: BoardSection = new BoardSection(weatherZone)

    player.boardSection = boardSection

    assert(player.boardSection == boardSection)
  }

  test("Test strength getter") {
    val player: Player = new Player("PlayerName")
    val weatherZone: WeatherZone = new WeatherZone()
    val boardSection: BoardSection = new BoardSection(weatherZone)

    player.boardSection = boardSection

    assert(player.strength == 0)
  }

  test("Test gems getter") {
    val player: Player = new Player("PlayerName")

    assert(player.gems == 2)
  }


  test("Test hand getter and setter") {
    val player: Player = new Player("PlayerName")
    val hand: ListBuffer[ICard] = ListBuffer.empty

    player.hand = hand

    assert(player.hand == hand)
  }

  test("Test hasCardsToPlay with non-empty hand") {
    val player: Player = new Player("PlayerName")
    player.hand += new CloseCombatCard("CardName", "CardDescription", 10, null)

    assert(player.hasCardsToPlay)
  }

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

  test("Test loseGem") {
    val player: Player = new Player("PlayerName")

    player.loseGem()

    assert(player.gems == 1)
  }

  test("Test hasNoGems with no gems") {
    val player: Player = new Player("PlayerName")

    assert(!player.hasNoGems)
  }


}