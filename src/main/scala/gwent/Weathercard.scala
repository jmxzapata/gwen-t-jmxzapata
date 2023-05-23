package cl.uchile.dcc
package gwent

class WeatherCard(name: String, effect: String) extends AbstractCard(name, effect) with IWeatherCard {

  override def canEqual(other: Any): Boolean = other.isInstanceOf[WeatherCard]

  override def toString = s"WeatherCard(name=$name, effect=$effect)"
}
