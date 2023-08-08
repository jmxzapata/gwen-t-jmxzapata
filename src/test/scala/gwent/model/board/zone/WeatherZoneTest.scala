package scala.gwent.model.board.zone

import munit.FunSuite
import scala.gwent.model.board.zone.WeatherZone
import scala.gwent.model.cards.weather.NullWeatherEffect

class WeatherZoneTest extends FunSuite {
  /**
   * Test case for the 'clear' method of the WeatherZone class.
   */
  test("Test clear") {
    // Create a new WeatherZone
    val weatherZone = new WeatherZone()

    // Add a weather card to the WeatherZone
    weatherZone.addCard(new NullWeatherEffect())

    // Ensure that the weather card is not null before clearing
    assert(weatherZone.weatherCard != null)

    // Call the 'clear' method on the WeatherZone
    weatherZone.clear()

    // Ensure that the weather card is now an instance of NullWeatherEffect after clearing
    assert(weatherZone.weatherCard.isInstanceOf[NullWeatherEffect])
  }

  /**
   * Test case for the 'removeCard' method of the WeatherZone class.
   */
  test("Test removeCard") {
    // Create a new WeatherZone
    val weatherZone = new WeatherZone()

    // Create a new NullWeatherEffect weather card
    val weatherCard = new NullWeatherEffect()

    // Add the weather card to the WeatherZone
    weatherZone.addCard(weatherCard)

    // Ensure that the added weather card is the same as the weather card in the WeatherZone
    assert(weatherZone.weatherCard == weatherCard)

    // Call the 'removeCard' method on the WeatherZone to remove the weather card
    weatherZone.removeCard(weatherCard)

    // Ensure that the weather card in the WeatherZone is now an instance of NullWeatherEffect
    assert(weatherZone.weatherCard.isInstanceOf[NullWeatherEffect])
  }

  /**
   * Test case for the 'addCard' method of the WeatherZone class.
   */
  test("Test addCard") {
    // Create a new WeatherZone
    val weatherZone = new WeatherZone()

    // Create a new NullWeatherEffect weather card
    val weatherCard = new NullWeatherEffect()

    // Call the 'addCard' method on the WeatherZone to add the weather card
    weatherZone.addCard(weatherCard)

    // Ensure that the added weather card is the same as the weather card in the WeatherZone
    assert(weatherZone.weatherCard == weatherCard)
  }

  /**
   * Test case for the 'spreadWeatherEffect' method of the WeatherZone class.
   */
  test("Test spreadWeatherEffect") {
    // Create a new WeatherZone
    val weatherZone = new WeatherZone()

    // Create a new NullWeatherEffect weather card
    val weatherCard = new NullWeatherEffect()

    // Call the 'spreadWeatherEffect' method on the WeatherZone to spread the weather effect
    weatherZone.spreadWeatherEffect(weatherCard)

    // Ensure that the spread weather card is the same as the weather card in the WeatherZone
    assert(weatherZone.weatherCard == weatherCard)
  }
}