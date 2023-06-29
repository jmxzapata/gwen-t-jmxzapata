package cl.uchile.dcc
package gwent.board

import munit.FunSuite
import scala.collection.mutable.ListBuffer
import cl.uchile.dcc.gwent.cards.SiegeCombatCard
import cl.uchile.dcc.gwent.board.SiegeCombatZone

/**
 * A test suite for the `SiegeCombatZone` class.
 */
class SiegeCombatZoneTest extends FunSuite {

  /**
   * Tests that a `SiegeCombatZone` should have an initial list of siege combat cards.
   */
  test("A SiegeCombatZone should have an initial list of siege combat cards") {
    val cards = ListBuffer(
      new SiegeCombatCard("Card 1", "Description 1", 7),
      new SiegeCombatCard("Card 2", "Description 2", 6)
    )
    val zone = new SiegeCombatZone(cards)
    assertEquals(zone.cardsInZone, cards)
  }

  /**
   * Tests that it should allow removing a siege combat card from the zone at a specific position.
   */
  test("It should allow removing a siege combat card from the zone at a specific position") {
    val card1 = new SiegeCombatCard("Card 1", "Description 1", 7)
    val card2 = new SiegeCombatCard("Card 2", "Description 2", 6)
    val zone = new SiegeCombatZone(ListBuffer(card1, card2))
    val removedCard = zone.removeCard(1)
    assertEquals(removedCard, card2)
    assertEquals(zone.cardsInZone, ListBuffer(card1))
  }
}
