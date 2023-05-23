package cl.uchile.dcc
package board

import gwent.UnityCard
class WeatherCardZon extends AbstractZone {
  private var affectedRows: Set[IRowZone] = Set.empty

  def affectRow(row: IRowZone): Unit = {
    affectedRows += row
  }

  def unaffectRow(row: IRowZone): Unit = {
    affectedRows -= row
  }

  def getAffectedRows: Set[IRowZone] = affectedRows
}
