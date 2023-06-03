package cl.uchile.dcc
package gwent.cards

class WeatherCard(
                   override val name: String,
                   override val description: String
                 ) extends AbstractCard(name, description) with IWeatherCard {

  override def canEqual(other: Any): Boolean = other.isInstanceOf[WeatherCard]

  override def toString = s"WeatherCard(name=$name, description=$description)"
}

