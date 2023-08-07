package scala.gwent.model.player

import scala.collection.mutable.ListBuffer
import scala.gwent.controller.state.IObserverGame
import scala.gwent.model.board.{BoardSection, IGameComposite}
import scala.gwent.model.cards.unity.{CloseCombatCard, RangedCombatCard, SiegeCombatCard}
import scala.gwent.model.cards.weather.IWeatherCard
import scala.gwent.model.cards.{Deck, ICard, IObserverCard}

/**
 * A class representing a player in the card game.
 *
 * The Player class represents a player in the card game. Each player has a name, a board section where
 * the player's cards are placed, a strength value representing the total strength of the player's cards,
 * gems representing the player's resources, a deck of cards, a hand of cards, and a list of observers
 * monitoring the player's actions.
 *
 * @constructor Creates a new Player instance with the given name.
 */
class Player(val name: String) extends IGameComposite with IObserverGame {

  /** The board section where the player's cards are placed. */
  private var _boardSection: BoardSection = _

  /** The current board section of the player. */
  def boardSection: BoardSection = _boardSection

  /** Sets the board section of the player. */
  def boardSection_=(section: BoardSection): Unit = {
    _boardSection = section
  }

  /** The total strength of the player's cards. */
  private val _strength: Int = 0

  /** The number of gems representing the player's resources. */
  private var _gems: Int = 2

  /** The player's deck of cards. */
  private val _deck: Deck = new Deck()

  /** The hand of cards currently held by the player. */
  private var _hand: ListBuffer[ICard] = ListBuffer.empty

  /** The list of observers monitoring the player's actions. */
  private var _observers: ListBuffer[IObserverCard] = ListBuffer.empty

  /** The total strength of the player's cards. */
  def strength: Int = _strength

  /** The number of gems representing the player's resources. */
  def gems: Int = _gems

  /** The player's deck of cards. */
  def deck: Deck = _deck

  /** The hand of cards currently held by the player. */
  def hand: ListBuffer[ICard] = _hand

  /** Sets the hand of cards held by the player. */
  def hand_=(cards: ListBuffer[ICard]): Unit = _hand = cards

  /**
   * Adds an observer to the list of observers monitoring the player's actions.
   *
   */
  def addObserver(observer: IObserverCard): Unit = {
    _observers += observer
  }

  /**
   * Removes an observer from the list of observers monitoring the player's actions.
   *
   */
  def removeObserver(observer: IObserverCard): Unit = {
    _observers = _observers.filterNot(_ == observer)
  }

  /**
   * Notifies all the observers about a card played by the player.
   *
   * @param card The card played by the player.
   */
  private def notifyObservers(card: ICard): Unit = {
    _observers.foreach(_.update(card))
  }

  /**
   * Checks if the player has cards in hand that can be played.
   *
   * @return true if the player has cards in hand to play, false otherwise.
   */
  def hasCardsToPlay: Boolean = hand.nonEmpty

  /**
   * Performs the player's turn by playing a card from hand.
   *
   * The player selects a random card from their hand and plays it on the board based on its type:
   * - If the card is a CloseCombatCard, it is placed in the close combat zone of the board.
   * - If the card is a RangedCombatCard, it is placed in the ranged combat zone of the board.
   * - If the card is a SiegeCombatCard, it is placed in the siege combat zone of the board.
   * - If the card is a weather card, it is played in the weather zone of the board.
   * After playing the card, the observers are notified, and the card is removed from the player's hand.
   */
  def takeTurn(): Unit = {
    if (hand.nonEmpty) {
      val randomIndex = scala.util.Random.nextInt(hand.length)
      val card = hand(randomIndex)

      card match {
        case closeCombatCard: CloseCombatCard =>
          playCardInCloseZone(closeCombatCard)
        case rangedCombatCard: RangedCombatCard =>
          playCardInRangedZone(rangedCombatCard)
        case siegeCombatCard: SiegeCombatCard =>
          playCardInSiegeZone(siegeCombatCard)
        case weatherCard: IWeatherCard =>
          playCardInWeatherZone(weatherCard)
        case _ =>
      }

      notifyObservers(card)

      hand = hand.filterNot(_ == card)
    }
  }

  /**
   * Plays a CloseCombatCard in the close combat zone of the board.
   *
   * @param card The CloseCombatCard to be played.
   */
  private def playCardInCloseZone(card: CloseCombatCard): Unit = {
    boardSection.placeCardInCloseZone(card)
  }

  /**
   * Plays a RangedCombatCard in the ranged combat zone of the board.
   *
   * @param card The RangedCombatCard to be played.
   */
  private def playCardInRangedZone(card: RangedCombatCard): Unit = {
    boardSection.placeCardInRangedZone(card)
  }

  /**
   * Plays a SiegeCombatCard in the siege combat zone of the board.
   *
   * @param card The SiegeCombatCard to be played.
   */
  private def playCardInSiegeZone(card: SiegeCombatCard): Unit = {
    boardSection.placeCardInSiegeZone(card)
  }

  /**
   * Plays a weather card in the weather zone of the board.
   *
   * @param card The weather card to be played.
   */
  private def playCardInWeatherZone(card: IWeatherCard): Unit = {
    boardSection.placeWeatherCard(card)
  }

  /**
   * Decreases the number of gems owned by the player by one.
   */
  def loseGem(): Unit = {
    _gems -= 1
  }

  /**
   * Checks if the player has no gems remaining.
   *
   * @return true if the player has no gems, false otherwise.
   */
  def hasNoGems: Boolean = {
    _gems == 0
  }

  /**
   * Spreads the effect of a weather card to the player's board section, deck, and hand.
   *
   * This method applies the effect of a weather card to all the cards in the player's board section, deck,
   * and hand. It also notifies the observers about the updated cards.
   *
   * @param weatherCard The weather card that applies the effect.
   */
  override def spreadWeatherEffect(weatherCard: IWeatherCard): Unit = {
    boardSection.spreadWeatherEffect(weatherCard)
    deck.spreadWeatherEffect(weatherCard)
    for (card <- hand) weatherCard.applyCardEffect(card)
  }


  //AQUI SE IMPLEMENTA OBSERVER//

  // Método para notificar que el jugador ganó la partida
  def notifyPlayerWonGame(): Unit = {
    println(s"¡El jugador $name ganó la partida!")
  }

  // Método para notificar que el jugador perdió la partida
  def notifyPlayerLostGame(): Unit = {
    println(s"El jugador $name perdió la partida.")
  }

  // Implementación de la interfaz IObserverGame
  override def playerWonGame(player: Player): Unit = {
    if (this == player) {
      notifyPlayerWonGame()
    }
  }
  override def playerLostGame(player: Player): Unit = {
    if (this == player) {
      notifyPlayerLostGame()
    }
  }

}
