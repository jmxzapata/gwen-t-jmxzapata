package cl.uchile.dcc
package gwent.board

import munit.FunSuite
import scala.collection.mutable.ListBuffer
import cl.uchile.dcc.gwent.cards.RangedCombatCard
import cl.uchile.dcc.gwent.board.RangedCombatZone

/**
 * A test suite for the `RangedCombatZone` class.
 */
class RangedCombatZoneTest extends FunSuite {

  /**
   * Tests that a `RangedCombatZone` should have an initial list of ranged combat cards.
   */
  test("A RangedCombatZone should have an initial list of ranged combat cards") {
    val cards = ListBuffer(
      new RangedCombatCard("Card 1", "Description 1", 5),
      new RangedCombatCard("Card 2", "Description 2", 3)
    )
    val zone = new RangedCombatZone(cards)
    assertEquals(zone.cardsInZone, cards)
  }

  /**
   * Tests that it should allow removing a ranged combat card from the zone at a specific position.
   */
  test("It should allow removing a ranged combat card from the zone at a specific position") {
    val card1 = new RangedCombatCard("Card 1", "Description 1", 5)
    val card2 = new RangedCombatCard("Card 2", "Description 2", 3)
    val zone = new RangedCombatZone(ListBuffer(card1, card2))
    val removedCard = zone.removeCard(1)
    assertEquals(removedCard, card2)
    assertEquals(zone.cardsInZone, ListBuffer(card1))
  }
}
