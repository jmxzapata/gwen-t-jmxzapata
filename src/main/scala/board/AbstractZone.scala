package cl.uchile.dcc
package board

import gwent.UnityCard
abstract class AbstractZone extends IRowZone {
  def addCard(card: UnityCard): Unit
  def removeCard(card: UnityCard): Unit
  def getCards: List[UnityCard]
  def isCardInZone(card: UnityCard): Boolean
  def clearZone(): Unit
}
