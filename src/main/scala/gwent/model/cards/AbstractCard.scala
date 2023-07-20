package scala.gwent.model.cards

import scala.collection.mutable.ListBuffer
import scala.gwent.model.cards.weather.{BitingFrostEffect,
  ClearWeatherEffect, ImpenetrableFogEffect, TorrentialRainEffect}

/**
 * An abstract class representing a card in a card game.
 *
 * @param name        The name of the card.
 * @param description The description of the card.
 */
abstract class AbstractCard(
                             override val name: String,
                             override val description: String,
                           ) extends ICard with Equals {

  /**
   * A list of observers monitoring this card for changes.
   */
  val observers: ListBuffer[IObserverCard] = ListBuffer.empty[IObserverCard]

  /**
   * Applies the effect of the Biting Frost card to this card.
   *
   * This method is used to apply the effect of the Biting Frost card to this card during gameplay.
   *
   * @param card The Biting Frost card whose effect is being applied to this card.
   */
  override def affectedByBitingFrost(card: BitingFrostEffect): Unit = {
    // Implementation of the Biting Frost effect on this card goes here
  }

  /**
   * Applies the effect of the Impenetrable Fog card to this card.
   *
   * This method is used to apply the effect of the Impenetrable Fog card to this card during gameplay.
   *
   * @param card The Impenetrable Fog card whose effect is being applied to this card.
   */
  override def affectedByImpenetrableFog(card: ImpenetrableFogEffect): Unit = {
    // Implementation of the Impenetrable Fog effect on this card goes here
  }

  /**
   * Applies the effect of the Clear Weather card to this card.
   *
   * This method is used to apply the effect of the Clear Weather card to this card during gameplay.
   *
   * @param card The Clear Weather card whose effect is being applied to this card.
   */
  override def affectedByClearWeather(card: ClearWeatherEffect): Unit = {
    // Implementation of the Clear Weather effect on this card goes here
  }

  /**
   * Applies the effect of the Torrential Rain card to this card.
   *
   * This method is used to apply the effect of the Torrential Rain card to this card during gameplay.
   *
   * @param card The Torrential Rain card whose effect is being applied to this card.
   */
  override def affectedByTorrentialRain(card: TorrentialRainEffect): Unit = {
    // Implementation of the Torrential Rain effect on this card goes here
  }

  /**
   * Adds an observer to this card.
   *
   * This method is used to add an observer to this card to monitor for changes.
   *
   */
  override def addObserver(observer: IObserverCard): Unit = {
    observers += observer
  }

  /**
   * Removes an observer from this card.
   *
   * This method is used to remove an observer from this card.
   *
   */
  override def removeObserver(observer: IObserverCard): Unit = {
    observers -= observer
  }

  /**
   * Notifies all observers of this card about a change.
   *
   * This method is used to notify all observers of this card about a change in its state.
   *
   * @param card The card that triggered the update.
   */
  override def notifyObservers(card: ICard): Unit = {
    observers.foreach(_.update(card))
  }

  /**
   * Indicates whether some other object can be compared to this card.
   *
   * @param that The other object to compare.
   * @return `true` if the other object is an instance of `AbstractCard`, `false` otherwise.
   */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[AbstractCard]

  /**
   * Compares this card to another object for equality.
   *
   * @param other The other object to compare.
   * @return `true` if the other object is an instance of `AbstractCard` and has the same `name` and `description`,
   *         `false` otherwise.
   */
  override def equals(other: Any): Boolean = other match {
    case that: AbstractCard =>
      (that canEqual this) &&
        name == that.name &&
        description == that.description
    case _ => false
  }

  /**
   * Returns a hash code value for the card.
   *
   * @return The hash code value.
   */
  override def hashCode(): Int = {
    val state = Seq(name, description)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }

  /**
   * Returns a string representation of the card.
   *
   * @return The string representation.
   */
  override def toString: String = s"AbstractCard(name=$name, description=$description)"

  /**
   * Updates the card's state based on changes in another card.
   *
   * This method is used to update the state of this card based on changes in another card during gameplay.
   *
   * @param card The card that triggered the update.
   */
  override def update(card: ICard): Unit = {
    // Implementation of the card's update logic goes here
  }

  /**
   * Retrieves the list of observers monitoring this card.
   *
   * @return The list of observers.
   */
  def getObservers: ListBuffer[IObserverCard] = observers
}
