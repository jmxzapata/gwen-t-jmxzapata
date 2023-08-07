package scala.gwent.model.board

import scala.gwent.model.board.zone.WeatherZone
import scala.gwent.model.cards.weather.IWeatherCard
import scala.gwent.model.player.Player

/**
 * A class representing the game board in a card game.
 *
 * The Board class is a part of the card game system and represents the game board where players can place
 * their cards and apply weather effects. It implements the IGameComposite trait, which means it can act
 * as a composite in the composite pattern and can spread weather effects to its children (players and weather zone).
 *
 * @constructor Creates a new Board with two players and a weather zone.
 *
 */
class Board(player1: Player, player2: Player) extends IGameComposite {

  private val _weatherZone: WeatherZone = new WeatherZone()
  private val _player1Section: BoardSection = new BoardSection(_weatherZone)
  private val _player2Section: BoardSection = new BoardSection(_weatherZone)

  /**
   * Post-initialization method to set the board sections for both players.
   *
   * This method is called after creating the Board instance to set the board sections for player1 and player2.
   * It assigns the appropriate board sections to the players, so they can place their cards and apply weather effects.
   */
  def postInit(): Unit = {
    player1.boardSection = player1Section
    player2.boardSection = player2Section
  }

  /**
   * Get the board section for player 1.
   *
   * @return The board section for player 1.
   */
  def player1Section: BoardSection = _player1Section

  /**
   * Get the board section for player 2.
   *
   * @return The board section for player 2.
   */
  def player2Section: BoardSection = _player2Section

  /**
   * Spread the effect of a weather card to all components of the board.
   *
   * This method spreads the effect of a weather card to both players and the weather zone in the board.
   *
   */
  override def spreadWeatherEffect(card: IWeatherCard): Unit = {
    player1.spreadWeatherEffect(card)
    player2.spreadWeatherEffect(card)
    _weatherZone.spreadWeatherEffect(card)
  }
}
