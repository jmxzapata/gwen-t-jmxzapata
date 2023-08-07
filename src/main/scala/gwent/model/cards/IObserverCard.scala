package scala.gwent.model.cards

/**

The IObserverCard trait represents an observer for cards in the Gwent game.
An observer is notified when there are updates to a card it is observing.
@note All methods in this trait are abstract and must be implemented by concrete classes that extend it.
 */
trait IObserverCard {
  /**

  Update the observer with the latest data from a card.
  @param card The card that the observer is being updated with.
   */
  def update(card: ICard): Unit
}