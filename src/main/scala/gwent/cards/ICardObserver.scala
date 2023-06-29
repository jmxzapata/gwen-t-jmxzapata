package cl.uchile.dcc
package gwent.cards

/**
 * The `CardObserver` trait represents the observer in the Observer pattern.
 * It defines the contract for an object that observes changes in `AbstractUnityCard` instances.
 */
trait ICardObserver {

  /**
   * This method is called when a change occurs in the observed `IUnityCard` object.
   *
   * @param card The `IUnityCard` object that has been updated.
   */
  def update(card: IUnityCard): Unit
}
