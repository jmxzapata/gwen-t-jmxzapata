package scala.gwent.model.cards

import munit.FunSuite

import scala.gwent.model.cards.{AbstractCard, ICard, IObserverCard, ISubjectCard}
import munit.FunSuite

import scala.gwent.model.cards.unity.effects.{MoralBoostEffect, TightBondEffect}
import scala.gwent.model.cards.weather.{BitingFrostEffect, ClearWeatherEffect, ImpenetrableFogEffect, TorrentialRainEffect}


/**
 * AbstractCardTest Class Documentation
 *
 * The `AbstractCardTest` class contains test cases for the `TestSubjectCard`, which extends the `AbstractCard` class
 * and implements the `ISubjectCard` trait. The test cases focus on testing the functionalities related to adding,
 * removing observers and notifying them in the `AbstractCard` and `TestSubjectCard` classes.
 */
class AbstractCardTest extends FunSuite {

  /**
   * TestSubjectCard Class Documentation
   *
   * The `TestSubjectCard` class is a concrete implementation of the `AbstractCard` class that also implements the
   * `ISubjectCard` trait. It overrides various methods of `AbstractCard` and `ISubjectCard` interfaces.
   */
  class TestSubjectCard extends AbstractCard("Card", "Description") with ISubjectCard {

    /**
     * Method Documentation
     *
     * Override of the `strength` method to provide a specific implementation for the strength of the card.
     * In this case, it returns 0.
     *
     * @return The strength of the card, which is 0 in this implementation.
     */
    override def strength: Int = 0

    /**
     * Method Documentation
     *
     * Override of the `applyCardEffect` method to provide a specific implementation for applying the effect
     * of another card to this card.
     *
     * @param card The card whose effect will be applied to this card.
     */
    override def applyCardEffect(card: ICard): Unit = {}

    override def affectedByBitingFrost(card: BitingFrostEffect): Unit = {}

    override def affectedByImpenetrableFog(card: ImpenetrableFogEffect): Unit = {}

    override def affectedByClearWeather(card: ClearWeatherEffect): Unit = {}

    override def affectedByTorrentialRain(card: TorrentialRainEffect): Unit = {}

    override def affectedByMoralBoostEffect(card: MoralBoostEffect): Unit = {}

    override def affectedByTightBondEffect(card: TightBondEffect): Unit = {}

    /**
     * Method Documentation
     *
     * Override of the `update` method to provide a specific implementation for updating the card with the data from
     * another card.
     *
     * @param card The card with updated data.
     */
    override def update(card: ICard): Unit = {}

  }
  // Test cases for observer pattern functionality
  /**
   * Test case for the `addObserver` method.
   * It tests whether the `addObserver` method correctly adds an observer to the `observers` list in the `TestSubjectCard`.
   */
  test("Test addObserver") {
    val subjectCard = new TestSubjectCard()
    val observer = new IObserverCard {
      def update(card: ICard): Unit = {}
    }

    subjectCard.addObserver(observer)

    assertEquals(subjectCard.observers.length, 1)
    assertEquals(subjectCard.observers.head, observer)
  }

  /**
   * Test case for the `removeObserver` method.
   * It tests whether the `removeObserver` method correctly removes an observer from the `observers` list in the `TestSubjectCard`.
   */
  test("Test removeObserver") {
    val subjectCard = new TestSubjectCard()
    val observer1 = new IObserverCard {
      def update(card: ICard): Unit = {}
    }
    val observer2 = new IObserverCard {
      def update(card: ICard): Unit = {}
    }

    subjectCard.addObserver(observer1)
    subjectCard.addObserver(observer2)

    subjectCard.removeObserver(observer1)

    assertEquals(subjectCard.observers.length, 1)
    assertEquals(subjectCard.observers.head, observer2)
  }
  /**
   * Test case for the `notifyObservers` method.
   * It tests whether the `notifyObservers` method correctly notifies all observers in the `observers` list in the `TestSubjectCard`.
   */
  test("Test notifyObservers") {
    var counter = 0
    val subjectCard = new TestSubjectCard()
    val observer1 = new IObserverCard {
      def update(card: ICard): Unit = {
        counter += 1
      }
    }
    val observer2 = new IObserverCard {
      def update(card: ICard): Unit = {
        counter += 1
      }
    }

    subjectCard.addObserver(observer1)
    subjectCard.addObserver(observer2)

    subjectCard.notifyObservers(subjectCard)

    assertEquals(counter, 2)
  }
  /**
   * Test case for the `affectedByBitingFrost` method.
   * It tests the behavior of the `affectedByBitingFrost` method when a `BitingFrostEffect` is applied to the `TestSubjectCard`.
   * Add specific test assertions for the expected behavior.
   */
  test("Test affectedByBitingFrost") {
    val subjectCard = new TestSubjectCard()
    val bitingFrost = new BitingFrostEffect("Biting Frost", "Description")

    // Test logic for the affectedByBitingFrost method

    subjectCard.affectedByBitingFrost(bitingFrost)

    // Ensure any expected outcomes
  }
  /**
   * Test case for the `affectedByImpenetrableFog` method.
   * It tests the behavior of the `affectedByImpenetrableFog` method when an `ImpenetrableFogEffect` is applied to the `TestSubjectCard`.
   * Add specific test assertions for the expected behavior.
   */
  test("Test affectedByImpenetrableFog") {
    val subjectCard = new TestSubjectCard()
    val impFog = new ImpenetrableFogEffect("Impenetrable Fog", "Description")

    // Test logic for the affectedByImpenetrableFog method

    subjectCard.affectedByImpenetrableFog(impFog)

    // Ensure any expected outcomes
  }
  /**
   * Test case for the `affectedByClearWeather` method.
   * It tests the behavior of the `affectedByClearWeather` method when a `ClearWeatherEffect` is applied to the `TestSubjectCard`.
   * Add specific test assertions for the expected behavior.
   */
  test("Test affectedByClearWeather") {
    val subjectCard = new TestSubjectCard()
    val clearWeather = new ClearWeatherEffect("Clear Weather", "Description")

    // Test logic for the affectedByClearWeather method

    subjectCard.affectedByClearWeather(clearWeather)

    // Ensure any expected outcomes
  }
  /**
   * Test case for the `affectedByTorrentialRain` method.
   * It tests the behavior of the `affectedByTorrentialRain` method when a `TorrentialRainEffect` is applied to the `TestSubjectCard`.
   * Add specific test assertions for the expected behavior.
   */
  test("Test affectedByTorrentialRain") {
    val subjectCard = new TestSubjectCard()
    val rain = new TorrentialRainEffect("Torrential Rain", "Description")

    // Test logic for the affectedByTorrentialRain method

    subjectCard.affectedByTorrentialRain(rain)

    // Ensure any expected outcomes
  }
}