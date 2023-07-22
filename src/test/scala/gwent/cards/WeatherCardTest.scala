package scala.gwent.cards

import munit.FunSuite

class WeatherCardTest extends FunSuite {

  // For a simple card
  val classification: Classification = Classification.Asedio
  val strength = 15
  val name: String = "Card1"
  val effect: String = "effect1"
  var WeatherCard: WeatherCard = _

  // For other simple card
  val classification2: Classification = Classification.Distance
  val strength2 = 20
  val name2: String = "Card2"
  val effect2: String = "effect2"
  var WeatherCard2: WeatherCard = _

  // What is repeated before each test, to work on equal terms
  override def beforeEach(context: BeforeEach): Unit = {
    WeatherCard = new WeatherCard(name, effect)
    WeatherCard2 = new WeatherCard(name2, effect2)
  }

  /**
   * USUALLY it holds that if inst1 == inst2 ==> inst1.hashCode() == inst2.hashCode()
   * On the other way, the conversation is not necessarily fulfilled, i.e.
   * inst1.hashCode() == inst2.hashCode() =/=> inst1 == inst2
   */

  test("The equals method do not work.") {
    // it will be verified that two instances with different fields have different hashCode
    assertNotEquals(WeatherCard, WeatherCard2)

    // Testing the case in which there is an instance with the same fields
    val similarWeatherCard = new WeatherCard(name, effect)
    assertEquals(WeatherCard, similarWeatherCard)

    // Comparison test between two different cards
    val weatherCard = new WeatherCard(name, effect)
    // assertNotEquals(unityCard, weatherCard)
  }
}
