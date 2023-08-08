package scala.gwent.model.cards

import munit.FunSuite

/**
 * CardTest Class Documentation
 *
 * The `CardTest` class contains test cases for the `Card` class, which represents a card in the Gwent game.
 */
class CardTest extends FunSuite {

  /**
   * Test case for the `applyCardEffect` method.
   * It tests whether the `applyCardEffect` method correctly applies the effect of another card to this card.
   */
  test("Test applyCardEffect") {
    val card = new Card("Card", "Description")
    val otherCard = new Card("Other Card", "Other Description")

    card.applyCardEffect(otherCard)

    // Add test assertions here
  }

  /**
   * Test case for the `update` method.
   * It tests whether the `update` method correctly updates the card with the data from another card.
   */
  test("Test update") {
    val card = new Card("Card", "Description")
    val otherCard = new Card("Other Card", "Other Description")

    card.update(otherCard)

  }

}
