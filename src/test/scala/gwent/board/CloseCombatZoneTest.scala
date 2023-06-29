package cl.uchile.dcc
package gwent.board

import munit.FunSuite
import scala.collection.mutable.ListBuffer
import cl.uchile.dcc.gwent.cards.CloseCombatCard

/**
 * A test suite for the `CloseCombatZone` class.
 */
class CloseCombatZoneTest extends FunSuite {

  /**
   * Tests that a `CloseCombatZone` has an initial list of close combat cards.
   */
  test("A CloseCombatZone should have an initial list of close combat cards") {
    val cards = ListBuffer(
      new CloseCombatCard("Card 1", "Description 1", 5),
      new CloseCombatCard("Card 2", "Description 2", 3)
    )
    val zone = new CloseCombatZone(cards)
    assertEquals(zone.cardsInZone, cards)
  }

  /**
   * Tests that a close combat card can be removed from the zone at a specific position.
   */
  test("It should allow removing a close combat card from the zone at a specific position") {
    val card1 = new CloseCombatCard("Card 1", "Description 1", 5)
    val card2 = new CloseCombatCard("Card 2", "Description 2", 3)
    val zone = new CloseCombatZone(ListBuffer(card1, card2))
    val removedCard = zone.removeCard(1)
    assertEquals(removedCard, card2)
    assertEquals(zone.cardsInZone, ListBuffer(card1))
  }
}
