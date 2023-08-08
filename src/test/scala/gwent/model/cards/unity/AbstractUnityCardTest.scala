package scala.gwent.model.cards.unity

import munit.FunSuite

import scala.gwent.model.cards.{AbstractCard, Card, ICard}
import scala.gwent.model.cards.unity.effects.IEffectCard
import scala.gwent.model.cards.weather.ClearWeatherEffect
class AbstractUnityCardTest extends FunSuite {

  /**
   * A test implementation of the AbstractUnityCard to be used for testing.
   *
   * @param name        The name of the card.
   * @param description The description of the card.
   * @param strength    The initial strength of the card.
   * @param effect      The effect card associated with the unity card.
   */
  class TestUnityCard(name: String, description: String, strength: Int, effect: IEffectCard)
    extends AbstractUnityCard(name, description, strength, effect)

  /**
   * Test case for the 'currentStrength' property of the AbstractUnityCard.
   */
  test("Test currentStrength") {
    // Create a TestUnityCard with initial strength 10 and no effect
    val unityCard: IUnityCard = new TestUnityCard("CardName", "CardDescription", 10, null)

    // Assert that the initial strength is 10
    assert(unityCard.currentStrength == 10)

    // Update the current strength to 5
    unityCard.currentStrength = 5

    // Assert that the current strength has been updated to 5
    assert(unityCard.currentStrength == 5)
  }

  /**
   * Test case for the 'update' method of the AbstractUnityCard.
   */
  test("Test update") {
    // Create a TestUnityCard with initial strength 10 and no effect
    val unityCard: IUnityCard = new TestUnityCard("CardName", "CardDescription", 10, null)

    // Update the current strength to 5
    unityCard.currentStrength = 5

    // Call the update method with the same unityCard (self-update)
    unityCard.update(unityCard)

    // Assert that the current strength has been updated back to its original value (10)
    assert(unityCard.currentStrength == 10)
  }

  /**
   * Test case for the 'affectedByClearWeather' method of the AbstractUnityCard.
   */
  test("Test affectedByClearWeather") {
    // Create a TestUnityCard with initial strength 10 and no effect
    val unityCard: IUnityCard = new TestUnityCard("CardName", "CardDescription", 10, null)

    // Create a ClearWeatherEffect
    val weatherCard: ClearWeatherEffect = new ClearWeatherEffect("Clear Weather", "Description")

    // Assert that the initial strength is 10
    assert(unityCard.currentStrength == 10)

    // Call the 'affectedByClearWeather' method on the unityCard passing the weatherCard as the parameter
    unityCard.affectedByClearWeather(weatherCard)

    // Assert that the unityCard has been added as an observer to the weatherCard
    assert(weatherCard.getObservers.contains(unityCard))

    // Assert that the current strength remains unchanged (still 10)
    assert(unityCard.currentStrength == 10)
  }
}