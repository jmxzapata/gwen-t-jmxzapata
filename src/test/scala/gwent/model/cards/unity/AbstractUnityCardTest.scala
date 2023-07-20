package scala.gwent.model.cards.unity

import munit.FunSuite

import scala.gwent.model.cards.{AbstractCard, Card, ICard}
import scala.gwent.model.cards.unity.effects.IEffectCard
import scala.gwent.model.cards.weather.ClearWeatherEffect
class AbstractUnityCardTest extends FunSuite {
  class TestUnityCard(name: String, description: String, strength: Int, effect: IEffectCard)
    extends AbstractUnityCard(name, description, strength, effect)


  test("Test currentStrength") {
    val unityCard: IUnityCard = new TestUnityCard("CardName", "CardDescription", 10, null)

    assert(unityCard.currentStrength == 10)

    unityCard.currentStrength = 5

    assert(unityCard.currentStrength == 5)
  }

  test("Test update") {
    val unityCard: IUnityCard = new TestUnityCard("CardName", "CardDescription", 10, null)
    unityCard.currentStrength = 5

    unityCard.update(unityCard)

    assert(unityCard.currentStrength == 10)
  }

  test("Test affectedByClearWeather") {
    val unityCard: IUnityCard = new TestUnityCard("CardName", "CardDescription", 10, null)
    val weatherCard: ClearWeatherEffect = new ClearWeatherEffect("Clear Weather", "Description")

    assert(unityCard.currentStrength == 10)

    unityCard.affectedByClearWeather(weatherCard)

    assert(weatherCard.getObservers.contains(unityCard))

    assert(unityCard.currentStrength == 10)
  }
}