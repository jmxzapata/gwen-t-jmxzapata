package scala.gwent.model.cards

import munit.FunSuite

import scala.gwent.model.cards.{AbstractCard, ICard, IObserverCard, ISubjectCard}
import munit.FunSuite

import scala.gwent.model.cards.unity.effects.{MoralBoostEffect, TightBondEffect}
import scala.gwent.model.cards.weather.{BitingFrostEffect, ClearWeatherEffect, ImpenetrableFogEffect, TorrentialRainEffect}

class AbstractCardTest extends FunSuite {
  class TestSubjectCard extends AbstractCard("Card", "Description") with ISubjectCard {

    override def strength: Int = 0

    override def applyCardEffect(card: ICard): Unit = {}

    override def affectedByBitingFrost(card: BitingFrostEffect): Unit = {}

    override def affectedByImpenetrableFog(card: ImpenetrableFogEffect): Unit = {}

    override def affectedByClearWeather(card: ClearWeatherEffect): Unit = {}

    override def affectedByTorrentialRain(card: TorrentialRainEffect): Unit = {}
    
    override def affectedByMoralBoostEffect(card: MoralBoostEffect): Unit = {}

    override def affectedByTightBondEffect(card: TightBondEffect): Unit = {}
    override def update(card: ICard): Unit = {}

  }

  test("Test addObserver") {
    val subjectCard = new TestSubjectCard()
    val observer = new IObserverCard {
      def update(card: ICard): Unit = {}
    }

    subjectCard.addObserver(observer)

    assertEquals(subjectCard.observers.length, 1)
    assertEquals(subjectCard.observers.head, observer)
  }

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

  test("Test affectedByBitingFrost") {
    val subjectCard = new TestSubjectCard()
    val bitingFrost = new BitingFrostEffect("Biting Frost", "Description")

    // Test logic for the affectedByBitingFrost method

    subjectCard.affectedByBitingFrost(bitingFrost)

    // Ensure any expected outcomes
  }

  test("Test affectedByImpenetrableFog") {
    val subjectCard = new TestSubjectCard()
    val impFog = new ImpenetrableFogEffect("Impenetrable Fog", "Description")

    // Test logic for the affectedByImpenetrableFog method

    subjectCard.affectedByImpenetrableFog(impFog)

    // Ensure any expected outcomes
  }

  test("Test affectedByClearWeather") {
    val subjectCard = new TestSubjectCard()
    val clearWeather = new ClearWeatherEffect("Clear Weather", "Description")

    // Test logic for the affectedByClearWeather method

    subjectCard.affectedByClearWeather(clearWeather)

    // Ensure any expected outcomes
  }

  test("Test affectedByTorrentialRain") {
    val subjectCard = new TestSubjectCard()
    val rain = new TorrentialRainEffect("Torrential Rain", "Description")

    // Test logic for the affectedByTorrentialRain method

    subjectCard.affectedByTorrentialRain(rain)

    // Ensure any expected outcomes
  }
}