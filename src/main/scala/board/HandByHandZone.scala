package cl.uchile.dcc
package board

import gwent.UnityCard

class HandByHandZone extends AbstractZone with IRowZone {
  
  private var isDeployed: Boolean = false

  def deployCard(): Unit = {
    isDeployed = true
  }

  def isCardDeployed: Boolean = isDeployed
}