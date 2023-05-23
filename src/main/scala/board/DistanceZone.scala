package cl.uchile.dcc
package board

import gwent.UnityCard
class DistanceZone extends AbstractZone with IRowZone {
  private var isRevealed: Boolean = false

  def revealCard(): Unit = {
    isRevealed = true
  }

  def isCardRevealed: Boolean = isRevealed
}

