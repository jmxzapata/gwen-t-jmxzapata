package cl.uchile.dcc
package gwent.cards

class WeatherCardTest extends AbstractCardTest {
	
	// For a simple card
	val classification: Classification = Classification.Siege
	val strength = 15
	var WeatherCard: WeatherCard = _
	
	// For other simple card
	val classification2: Classification = Classification.Distance
	val strength2 = 20
	var WeatherCard2: WeatherCard = _
	
	// What is repeated before each test, to work on equal terms
	override def beforeEach(context: BeforeEach): Unit = {
		WeatherCard = new WeatherCard(name, effect, classification, strength)
		WeatherCard2 = new WeatherCard2(name2, effect2, classification2, strength2)
	}
	
	/**
	 * USUALLY it holds that if inst1 == inst2 ==> inst1.hashCode() == inst2.hashCode()
	 * On the other way, the conversation is not necessarily fulfilled, i.e.
	 * inst1.hashCode() == inst2.hashCode() =/=> inst1 == inst2
	 */
	test("The hash code do not work.") {
		// it will be verified that two instances with different fields have different hashCode
		assertNotEquals(WeatherCard.hashCode(), WeatherCard2.hashCode())
		
		// Testing the case in which there is an instance with the same fields
		val similarWeatherCard = new WeatherCard(name, effect, classification, strength)
		assertEquals(WeatherCard.hashCode(), similarUnityCard.hashCode())
	}
	
	test("The equals method do not work.") {
		// it will be verified that two instances with different fields have different hashCode
		assertNotEquals(WeatherCard, WeatherCard2)
		
		// Testing the case in which there is an instance with the same fields
		val similarWeatherCard = new WeatherCard(name, effect, classification, strength)
		assertEquals(WeatherCard, similarWeatherCard)
		
		// Comparison test between two different cards
		val weatherCard = new WeatherCard(name, effect)
		// assertNotEquals(unityCard, weatherCard)
	}
}