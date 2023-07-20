package scala.gwent.model.board.zone

import munit.FunSuite
import scala.gwent.model.board.zone.WeatherZone
import scala.gwent.model.cards.weather.NullWeatherEffect

class WeatherZoneTest extends FunSuite {
  test("Test clear") {
    val weatherZone = new WeatherZone()
    weatherZone.addCard(new NullWeatherEffect())

    assert(weatherZone.weatherCard != null)

    weatherZone.clear()

    assert(weatherZone.weatherCard.isInstanceOf[NullWeatherEffect])
  }

  test("Test removeCard") {
    val weatherZone = new WeatherZone()
    val weatherCard = new NullWeatherEffect()

    weatherZone.addCard(weatherCard)

    assert(weatherZone.weatherCard == weatherCard)

    weatherZone.removeCard(weatherCard)

    assert(weatherZone.weatherCard.isInstanceOf[NullWeatherEffect])
  }

  test("Test addCard") {
    val weatherZone = new WeatherZone()
    val weatherCard = new NullWeatherEffect()

    weatherZone.addCard(weatherCard)

    assert(weatherZone.weatherCard == weatherCard)
  }

  test("Test spreadWeatherEffect") {
    val weatherZone = new WeatherZone()
    val weatherCard = new NullWeatherEffect()

    weatherZone.spreadWeatherEffect(weatherCard)

    assert(weatherZone.weatherCard == weatherCard)
  }
}