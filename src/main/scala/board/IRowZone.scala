package cl.uchile.dcc
package board

import gwent.UnityCard

trait IRowZone {
  def clearZone(): Unit
  def removeCard(card: UnityCard, row: IRowZone): Unit
  def isCardInZone(card: UnityCard, row: IRowZone): Boolean
  def getCards(card: UnityCard): Unit
  def addCard(card: UnityCard, row: IRowZone): Unit
}
