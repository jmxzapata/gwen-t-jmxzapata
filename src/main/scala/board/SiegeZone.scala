package cl.uchile.dcc
package board

import gwent.UnityCard
class SiegeZone extends AbstractZone with IRowZone {
  private var isReinforced: Boolean = false

  def reinforceCard(): Unit = {
    isReinforced = true
  }

  def isCardReinforced: Boolean = isReinforced
}

