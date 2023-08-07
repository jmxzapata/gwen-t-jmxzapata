package scala.gwent.model.board.zone

import scala.collection.mutable.ListBuffer
import scala.gwent.model.cards.ICard
import scala.gwent.model.cards.weather.IWeatherCard

/**
 * An abstract implementation of the IZone trait.
 *
 * The AbstractZone class provides a basic implementation of the IZone trait. It uses a ListBuffer to store the cards
 * in the zone and implements the methods to add cards, remove cards, and clear the zone. It also overrides the
 * spreadWeatherEffect method to apply the weather effect of a given weather card to all the cards in the zone.
 */
class AbstractZone extends IZone {

  /** The list buffer to store the cards in the zone. */
  var cards: ListBuffer[ICard] = ListBuffer.empty

  /**
   * Clear the zone.
   *
   * This method removes all cards from the zone, effectively clearing it.
   */
  override def clear(): Unit = {
    cards = ListBuffer.empty
  }

  /**
   * Add a card to the zone.
   *
   * This method adds the given card to the zone.
   *
   * @param card The card to add to the zone.
   */
  override def addCard(card: ICard): Unit = {
    cards += card
  }

  /**
   * Remove a card from the zone.
   *
   * This method removes the given card from the zone.
   *
   * @param card The card to remove from the zone.
   */
  override def removeCard(card: ICard): Unit = {
    cards -= card
  }

  /**
   * Spread the weather effect to all cards in the zone.
   *
   * This method applies the weather effect of a given weather card to all the cards in the zone.
   *
   * @param weatherCard The weather card that applies the weather effect.
   */
  override def spreadWeatherEffect(weatherCard: IWeatherCard): Unit = {
    for (card <- cards) {
      weatherCard.applyCardEffect(card)
    }
  }
}
