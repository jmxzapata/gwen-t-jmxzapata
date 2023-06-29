package cl.uchile.dcc
package gwent.board

import cl.uchile.dcc.gwent.cards.WeatherCard

import scala.collection.mutable.ListBuffer

/**
 * Class representing a weather card zone in the Gwent game.
 *
 * @param cardsInZone Mutable list of weather cards in the zone.
 */
class WeatherZone(
                   override val cardsInZone: ListBuffer[WeatherCard]
                 ) extends AbstractZone(cardsInZone) {

}

