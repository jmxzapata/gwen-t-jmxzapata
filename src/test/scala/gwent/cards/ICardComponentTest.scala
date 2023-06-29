package cl.uchile.dcc
package gwent.cards

import munit.FunSuite

/**
 * A test suite for the `CardComponent` trait.
 */
class ICardComponentTest extends FunSuite {

  /**
   * A mock card component class for testing purposes.
   */
  class MockCardComponent extends ICardComponent {
    var power: Int = 0
    var moraleBoostApplied: Boolean = false
    var tightBondApplied: Boolean = false

    override def totalPower: Int = power

    override def applyMoraleBoost(): Unit = {
      moraleBoostApplied = true
    }

    override def applyTightBond(): Unit = {
      tightBondApplied = true
    }
  }

  /**
   * Tests the calculation of the total power in `CardComponent`.
   */
  test("CardComponent should calculate the total power correctly") {
    val cardComponent = new MockCardComponent
    cardComponent.power = 5

    assertEquals(cardComponent.totalPower, 5)
  }

  /**
   * Tests the application of the morale boost effect in `CardComponent`.
   */
  test("CardComponent should apply the morale boost effect") {
    val cardComponent = new MockCardComponent

    cardComponent.applyMoraleBoost()

    assert(cardComponent.moraleBoostApplied)
  }

  /**
   * Tests the application of the tight bond effect in `CardComponent`.
   */
  test("CardComponent should apply the tight bond effect") {
    val cardComponent = new MockCardComponent

    cardComponent.applyTightBond()

    assert(cardComponent.tightBondApplied)
  }

  /**
   * Tests that the total power is zero when no power values are set in `CardComponent`.
   */
  test("CardComponent total power should be zero when no power values are set") {
    val cardComponent = new MockCardComponent

    assertEquals(cardComponent.totalPower, 0)
  }

  /**
   * Tests the calculation of total power with multiple card components in `CardComponent`.
   */
  test("CardComponent should correctly calculate total power with multiple card components") {
    val cardComponent1 = new MockCardComponent
    cardComponent1.power = 3

    val cardComponent2 = new MockCardComponent
    cardComponent2.power = 4

    val cardComponent3 = new MockCardComponent
    cardComponent3.power = 2

    val cardComponent4 = new MockCardComponent
    cardComponent4.power = 6

    val cardComponent5 = new MockCardComponent
    cardComponent5.power = 1

    val compositeCardComponent = new MockCardComponent
    compositeCardComponent.power = 0

    assertEquals(compositeCardComponent.totalPower, 0)

    compositeCardComponent.power += cardComponent1.totalPower
    assertEquals(compositeCardComponent.totalPower, 3)

    compositeCardComponent.power += cardComponent2.totalPower
    assertEquals(compositeCardComponent.totalPower, 7)

    compositeCardComponent.power += cardComponent3.totalPower
    assertEquals(compositeCardComponent.totalPower, 9)

    compositeCardComponent.power += cardComponent4.totalPower
    assertEquals(compositeCardComponent.totalPower, 15)

    compositeCardComponent.power += cardComponent5.totalPower
    assertEquals(compositeCardComponent.totalPower, 16)
  }
}
