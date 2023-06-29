package cl.uchile.dcc
package gwent.cards

import munit.FunSuite
import cl.uchile.dcc.gwent.cards.{ICard, CloseCombatCard}

/**
 * A test suite for the `ICard` trait.
 */
class ICardTest extends FunSuite {

  /**
   * Tests that an `ICard` has a name.
   */
  test("ICard should have a name") {
    val card: ICard = new CloseCombatCard("Close Combat Card 1", "Description 1", 1)
    assertEquals(card.name, "Close Combat Card 1")
  }

  /**
   * Tests that an `ICard` has a description.
   */
  test("ICard should have a description") {
    val card: ICard = new CloseCombatCard("Close Combat Card 1", "Description 1", 1)
    assertEquals(card.description, "Description 1")
  }

  /**
   * Tests that an `ICard` applies morale boost to a deck.
   */
  test("ICard should apply morale boost to a deck") {
    val card: ICard = new CloseCombatCard("Close Combat Card 1", "Description 1", 1)
    val deck: List[ICard] = List(
      new CloseCombatCard("Card 2", "Description 2", 2),
      new CloseCombatCard("Card 3", "Description 3", 3)
    )
    card.applyMoraleBoost(deck)
    // Add assertions to verify the expected behavior after applying the effect
  }

  /**
   * Tests that an `ICard` applies tight bond to a deck.
   */
  test("ICard should apply tight bond to a deck") {
    val card: ICard = new CloseCombatCard("Close Combat Card 1", "Description 1", 1)
    val deck: List[ICard] = List(
      new CloseCombatCard("Card 2", "Description 2", 2),
      new CloseCombatCard("Card 3", "Description 3", 3)
    )
    card.applyTightBond(deck)
    // Add assertions to verify the expected behavior after applying the effect
  }
}
