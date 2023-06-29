package cl.uchile.dcc
package gwent.board

import munit.FunSuite
import scala.collection.mutable.ListBuffer

/**
 * A test suite for the `AbstractZone` class.
 */
class AbstractZoneTest extends FunSuite {

  /**
   * A test implementation of `AbstractZone` for testing purposes.
   */
  class TestZone extends AbstractZone[String](ListBuffer("Card 1", "Card 2"))

  /**
   * Tests that a zone has an initial list of cards.
   */
  test("A zone should have an initial list of cards") {
    val zone = new TestZone()
    assertEquals(zone.cardsInZone, ListBuffer("Card 1", "Card 2"))
  }

  /**
   * Tests that a card can be added to the zone at a specific position.
   */
  test("It should allow adding a card to the zone at a specific position") {
    val zone = new TestZone()
    zone.addCard("Card 3", 1)
    assertEquals(zone.cardsInZone, ListBuffer("Card 1", "Card 3"))
  }

  /**
   * Tests that a card can be removed from the zone at a specific position.
   */
  test("It should allow removing a card from the zone at a specific position") {
    val zone = new TestZone()
    val removedCard = zone.removeCard(0)
    assertEquals(removedCard, "Card 1")
    assertEquals(zone.cardsInZone, ListBuffer("Card 2"))
  }
}
