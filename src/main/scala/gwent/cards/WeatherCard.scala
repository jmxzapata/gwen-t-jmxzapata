package scala.gwent.cards

/**
 * A concrete class representing a weather card in GWENT.
 *
 * This class extends the `AbstractCard` class and implements the `IWeatherCard` trait to represent a specific type of card
 * in the card game. Weather cards are cards that affect the game board's weather conditions. The `WeatherCard` class provides
 * a complete implementation for weather cards, including their name and effect.
 *
 * @param name   The name of the weather card.
 * @param effect The effect of the weather card, representing its special ability or functionality.
 */
class WeatherCard(name: String, effect: String) extends AbstractCard(name, effect) with IWeatherCard {

  /**
   * Checks if this weather card can be compared with the given object.
   *
   * @param other The other object to compare with.
   * @return True if the other object is a `WeatherCard` instance, otherwise false.
   */
  override def canEqual(other: Any): Boolean = other.isInstanceOf[WeatherCard]

  /**
   * Converts the weather card to a string representation.
   *
   * @return A string representation of the weather card, including its name and effect.
   */
  override def toString: String = s"WeatherCard(name=$name, effect=$effect)"
}
