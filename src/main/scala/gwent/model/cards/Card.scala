package scala.gwent.model.cards
import scala.gwent.model.cards.unity.effects.{MoralBoostEffect, TightBondEffect}

/**
 * A class representing a card in a card game.
 *
 * @param name        The name of the card.
 * @param description The description of the card.
 */
class Card(name: String, description: String) extends AbstractCard(name, description) {

  /**
   * Applies the card's effect to another card.
   *
   * This method is used to apply the effect of this card to another card during gameplay.
   *
   * @param card The target card to apply the effect to.
   */
  override def applyCardEffect(card: ICard): Unit = {
    // Implementation of the card's effect goes here
  }

  /**
   * Updates the card's state based on another card.
   *
   * This method is used to update the state of this card based on changes in another card during gameplay.
   *
   * @param card The card that triggered the update.
   */
  override def update(card: ICard): Unit = {
    // Implementation of the card's update logic goes here
  }

  /**
   * Retrieves the strength of the card.
   *
   * @return The strength value of the card.
   */
  override def strength: Int = {
    this.strength
  }

  override def affectedByMoralBoostEffect(card: MoralBoostEffect): Unit = {}

  override def affectedByTightBondEffect(card: TightBondEffect): Unit = {}
  
}
