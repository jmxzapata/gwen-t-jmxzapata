package cl.uchile.dcc
package board

import gwent.UnityCard

class Board {
  def placeCard(card: UnityCard, row: IRowZone): Unit
  def removeCard(card: UnityCard, row: IRowZone): Unit
  def getCardsInRow(row: IRowZone): List[UnityCard]
  def getCardPosition(card: UnityCard): (IRowZone, Int) //Option[Position]
  def isRowFull(row: IRowZone): Boolean
  def isBoardFull: Boolean
}

//case class UnityCard(name: String, strength: Int)

//case class Position(row: Row, index: Int)

// sealed trait Row
// case object HandByHandZone extends IRowZone
// case object DistanceZone extends IRowZone
// case object SiegeZone extends IRowZone
