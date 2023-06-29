package cl.uchile.dcc
package gwent.board

import munit.FunSuite
import scala.collection.mutable.ListBuffer

/**
 * A test suite for the `IZone` trait.
 */
class IZoneTest extends FunSuite {

  /**
   * Defines a test implementation of `IZone` for testing purposes.
   */
  class TestZone extends IZone[String] {
    override val cardsInZone: ListBuffer[String] = ListBuffer("Card 1", "Card 2")
  }

  /**
   * Tests that a zone should have an initial list of cards.
   */
  test("A zone should have an initial list of cards") {
    val zone = new TestZone()
    assertEquals(zone.cardsInZone, ListBuffer("Card 1", "Card 2"))
  }

  /**
   * Tests that it should allow adding a card to the zone.
   */
  test("It should allow adding a card to the zone") {
    val zone = new TestZone()
    zone.cardsInZone += "Card 3"
    assert(zone.cardsInZone.contains("Card 3"))
  }

  /**
   * Tests that it should allow removing a card from the zone.
   */
  test("It should allow removing a card from the zone") {
    val zone = new TestZone()
    zone.cardsInZone -= "Card 2"
    assert(!zone.cardsInZone.contains("Card 2"))
  }
}
