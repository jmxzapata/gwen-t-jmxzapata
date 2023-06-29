package cl.uchile.dcc.gwent.board

import scala.util.Random
import cl.uchile.dcc.gwent.cards.{CloseCombatCard, ICard, RangedCombatCard, SiegeCombatCard}
import scala.collection.mutable.ListBuffer

class Game {
  private var _player1Deck: List[ICard] = createPlayer1Deck()
  private var _player2Deck: List[ICard] = createPlayer2Deck()

  // Getter for player1Deck
  def player1Deck: List[ICard] = _player1Deck

  // Getter for player2Deck
  def player2Deck: List[ICard] = _player2Deck

  // Setter for player1Deck
  def player1Deck_=(deck: List[ICard]): Unit = {
    _player1Deck = deck
  }
  // Setter for player2Deck
  def player2Deck_=(deck: List[ICard]): Unit = {
    _player2Deck = deck
  }

  // Method for creating player 1 deck
  private def createPlayer1Deck(): List[ICard] = {
    // Definition of the cards in player 1's deck
    val card1: ICard = new CloseCombatCard("Close Combat Card 1", "Description 1", 1)
    val card2: ICard = new RangedCombatCard("Ranged Combat Card 1", "Description 2", 2)
    val card3: ICard = new SiegeCombatCard("Siege Combat Card 1", "Description 3", 3)
    // More cards can be added

    List(card1, card2, card3) // Returns the list of cards created
  }

  // Method for creating player 2 deck
  private def createPlayer2Deck(): List[ICard] = {
    // Definition of the cards in player 2's deck
    val card1: ICard = new CloseCombatCard("Close Combat Card 2", "Description 4", 4)
    val card2: ICard = new RangedCombatCard("Ranged Combat Card 2", "Description 5", 5)
    val card3: ICard = new SiegeCombatCard("Siege Combat Card 2", "Description 6", 6)
    // More cards can be added

    List(card1, card2, card3) // Returns the list of cards created
  }

  // Method for player 1 to play a card from the deck
  def player1PlayCard(): Unit = {
    val random = new Random()
    val player1CardIndex = random.nextInt(player1Deck.length)
    val player1Card = player1Deck(player1CardIndex)

    // Here you can write the game logic, possibly in the following implementations
    println("Player 1 plays the card: " + player1Card.name)
  }

  // Method for player 2 to play a card from the deck
  def player2PlayCard(): Unit = {
    val random = new Random()
    val player2CardIndex = random.nextInt(player2Deck.length)
    val player2Card = player2Deck(player2CardIndex)

    // Here you can write the game logic, possibly in the following implementations
    println("Player 2 plays the card: " + player2Card.name)
  }
}
