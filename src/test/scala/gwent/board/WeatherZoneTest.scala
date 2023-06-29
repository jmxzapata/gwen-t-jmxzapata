package cl.uchile.dcc
package gwent.board

import munit.FunSuite
import scala.collection.mutable.ListBuffer
import cl.uchile.dcc.gwent.cards.WeatherCard
import cl.uchile.dcc.gwent.board.WeatherZone

/**
 * A test suite for the `WeatherZone` class.
 */
class WeatherZoneTest extends FunSuite {

  /**
   * Tests that a `WeatherZone` should have an initial list of weather cards.
   */
  test("A WeatherZone should have an initial list of weather cards") {
    val cards = ListBuffer(
      new WeatherCard("Card 1", "Description 1"),
      new WeatherCard("Card 2", "Description 2")
    )
    val zone = new WeatherZone(cards)
    assertEquals(zone.cardsInZone, cards)
  }

  /**
   * Tests that it should allow removing a weather card from the zone at a specific position.
   */
  test("It should allow removing a weather card from the zone at a specific position") {
    val card1 = new WeatherCard("Card 1", "Description 1")
    val card2 = new WeatherCard("Card 2", "Description 2")
    val zone = new WeatherZone(ListBuffer(card1, card2))
    val removedCard = zone.removeCard(1)
    assertEquals(removedCard, card2)
    assertEquals(zone.cardsInZone, ListBuffer(card1))
  }
}
