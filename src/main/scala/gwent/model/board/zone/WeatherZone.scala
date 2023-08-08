package scala.gwent.model.board.zone

import scala.gwent.model.cards.weather.{IWeatherCard, NullWeatherEffect}

/**
 * A zone for weather cards.
 *
 * The WeatherZone class represents a zone in the game for weather cards. It extends the AbstractZone class,
 * which provides a basic implementation of the IZone trait. This zone can hold one weather card at a time,
 * and it represents the current weather condition in the game.
 *
 * @constructor Creates a new WeatherZone with a default weather card (NullWeatherEffect).
 */
class WeatherZone extends AbstractZone {

  var weatherCard: IWeatherCard = new NullWeatherEffect()

  /**
   * Clears the weather zone by setting the weather card to the default weather card (NullWeatherEffect).
   */
  override def clear(): Unit = {
    weatherCard = new NullWeatherEffect()
  }

  /**
   * Removes the specified weather card from the zone. If the card is the current weather card, the zone is cleared.
   *
   * @param card The weather card to be removed from the zone.
   */
  def removeCard(card: IWeatherCard): Unit = {
    if (card.equals(weatherCard)) clear()
  }

  /**
   * Adds a weather card to the zone, replacing the existing weather card.
   *
   * @param card The weather card to be added to the zone.
   */
  def addCard(card: IWeatherCard): Unit = {
    weatherCard = card
  }

  /**
   * Spreads the effect of a weather card to the weather zone.
   * This method is called when a weather card is played and its effect needs to be applied to the weather zone.
   *
   * @param card The weather card whose effect is to be spread to the weather zone.
   */
  override def spreadWeatherEffect(card: IWeatherCard): Unit = addCard(card)

  /**
   * Get the current weather card in the zone.
   *
   * @return The current weather card in the zone.
   */
  def getWeatherCard: IWeatherCard = weatherCard
}

