package cl.uchile.dcc
package gwent.board

import cl.uchile.dcc.gwent.cards.WeatherCard

import scala.collection.mutable.ListBuffer

class WeatherZone(
                   override val cardsInZone: ListBuffer[WeatherCard]
                 ) extends AbstractZone(cardsInZone) {

}
