package scala.gwent.model.cards

import munit.FunSuite

class CardTest extends FunSuite {
  test("Test applyCardEffect") {
    val card = new Card("Card", "Description")
    val otherCard = new Card("Other Card", "Other Description")

    card.applyCardEffect(otherCard)

    // Add test assertions here
  }

  test("Test update") {
    val card = new Card("Card", "Description")
    val otherCard = new Card("Other Card", "Other Description")

    card.update(otherCard)

    // Add test assertions here
  }

}
