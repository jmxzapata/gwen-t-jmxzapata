package cl.uchile.dcc
package gwent.cards

import munit.FunSuite

/**
 * A test suite for the `AbstractUnityCard` class.
 */
class AbstractUnityCardTest extends FunSuite {

  /**
   * A mock unity card class for testing purposes.
   *
   * @param name        The name of the card.
   * @param description The description of the card.
   * @param power       The power value representing the strength of the card.
   */
  class MockUnityCard(
                       name: String,
                       description: String,
                       power: Int
                     ) extends AbstractUnityCard(name, description, power) {
    override def applyMoraleBoost(deck: List[ICard]): Unit = ()
    override def applyTightBond(deck: List[ICard]): Unit = ()
  }

  /**
   * Tests the equality of `AbstractUnityCard` instances.
   */
  test("AbstractUnityCard - Equality") {
    val card1 = new MockUnityCard("Card", "Description", 10)
    val card2 = new MockUnityCard("Card", "Description", 10)

    assertEquals(card1, card2)
  }

  /**
   * Tests the hash code of `AbstractUnityCard` instances.
   */
  test("AbstractUnityCard - Hash Code") {
    val card1 = new MockUnityCard("Card", "Description", 10)
    val card2 = new MockUnityCard("Card", "Description", 10)

    assertEquals(card1.hashCode(), card2.hashCode())
  }

  /**
   * Tests the application of the morale boost effect in `AbstractUnityCard`.
   */
  test("AbstractUnityCard - Apply Morale Boost") {
    val card = new MockUnityCard("Card", "Description", 10)

    card.applyMoraleBoost(List.empty[ICard])

    assertEquals(card.currentPower, 10)
  }

  /**
   * Tests the application of the tight bond effect in `AbstractUnityCard`.
   */
  test("AbstractUnityCard - Apply Tight Bond") {
    val card = new MockUnityCard("Card", "Description", 10)

    card.applyTightBond(List.empty[ICard])

    assertEquals(card.currentPower, 10)
  }
}
