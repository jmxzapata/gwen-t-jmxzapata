package scala.gwent.cards

/**
 * A trait representing a unity card in a card game.
 *
 * This trait extends the `ICard` trait and adds additional properties specific to unity cards.
 * Unity cards are cards in a card game that have a classification and a strength value.
 */
trait IUnityCard extends ICard {
  /** Classification of the unity card.
   *
   * This property represents the classification of the unity card, which can be one of the three possible classifications.
   * It is a read-only property that must be defined in concrete implementations of this trait.
   */
  val classification: Classification

  /** Strength value of the unity card.
   *
   * This property represents the strength value of the unity card in the card game.
   * It is a read-only property that must be defined in concrete implementations of this trait.
   */
  val strength: Int
}

