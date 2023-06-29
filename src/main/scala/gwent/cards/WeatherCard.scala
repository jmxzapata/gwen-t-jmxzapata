package cl.uchile.dcc
package gwent.cards

import gwent.board.IZone

/**
 * A class representing a weather card in the Gwent game.
 *
 * This class extends the `AbstractCard` class and implements the `IWeatherCard` trait.
 *
 * @param name        The name of the card.
 * @param description The description of the card.
 */
class WeatherCard(
                   override val name: String,
                   override val description: String
                 ) extends AbstractCard(name, description) with IWeatherCard {

  /**
   * Applies the biting frost effect to the specified combat zone.
   *
   * @param combatZone The combat zone to apply the effect to.
   */
  def applyBitingFrost(combatZone: IZone[ICard]): Unit = {
    combatZone.cardsInZone.foreach {
      case card: CloseCombatCard => card.currentPower = 1
      case _ =>
    }
  }

  /**
   * Applies the impenetrable fog effect to the specified combat zone.
   *
   * @param combatZone The combat zone to apply the effect to.
   */
  def applyImpenetrableFog(combatZone: IZone[ICard]): Unit = {
    combatZone.cardsInZone.foreach {
      case card: RangedCombatCard => card.currentPower = 1
      case _ =>
    }
  }

  /**
   * Applies the torrential rain effect to the specified combat zone.
   *
   * @param combatZone The combat zone to apply the effect to.
   */
  def applyTorrentialRain(combatZone: IZone[ICard]): Unit = {
    combatZone.cardsInZone.foreach {
      case card: SiegeCombatCard => card.currentPower = 1
      case _ =>
    }
  }

  /**
   * Clears all weather effects from the specified combat zone.
   *
   * @param combatZone The combat zone to clear the weather effects from.
   */
  def clearWeatherEffects(combatZone: IZone[ICard]): Unit = {
    combatZone.cardsInZone.foreach {
      case card: AbstractUnityCard => card.currentPower = card.power
      case _ =>
    }
  }

  /**
   * Applies the morale boost effect to a deck of cards.
   *
   * @param deck The deck of cards to apply the effect to.
   */
  override def applyMoraleBoost(deck: List[ICard]): Unit = {
  }

  /**
   * Applies the tight bond effect to a deck of cards.
   *
   * @param deck The deck of cards to apply the effect to.
   */
  override def applyTightBond(deck: List[ICard]): Unit = {
  }

  /**
   * Checks if this card can be compared to the given object for equality.
   *
   * @param other The object to compare.
   * @return True if the other object is an instance of `WeatherCard`, false otherwise.
   */
  override def canEqual(other: Any): Boolean = other.isInstanceOf[WeatherCard]

  /**
   * Returns a string representation of the weather card.
   *
   * @return The string representation of the weather card.
   */
  override def toString: String = "WeatherCard(name=" + name + ", description=" + description + ")"
}
