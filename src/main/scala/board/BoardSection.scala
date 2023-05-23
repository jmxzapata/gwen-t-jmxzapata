package cl.uchile.dcc
package board

import gwent.UnityCard
class BoardSection {
  // Agregar campos para cada una de las zonas instanciandolas segun corresponda
  // Agregar un metodo para añadir una zona de clima
  private val sections: Map[String, IRowZone] = Map(
    "HandByHandZone" -> new HandByHandZone(),
    "DistanceZone" -> new DistanceZone(),
    "SiegeZone" -> new SiegeZone()
  )

  override def initialize(): Unit = {
    sections.values.foreach(_.clearZone())
  }

  override def placeCard(card: UnityCard, row: String): Unit = {
    sections(row).addCard(card)
  }

  override def removeCard(card: UnityCard): Unit = {
    sections.values.foreach(_.removeCard(card))
  }

  override def getCardsInRow(row: IRowZone): List[UnityCard] = {
    sections(row).getCards
  }

  override def getCardPosition(card: UnityCard): Option[Position] = {
    sections.keys.flatMap(row => {
      val zone = sections(row)
      if (zone.isCardInZone(card)) Some(Position(row, zone.getCards.indexOf(card)))
      else None
    }).headOption
  }

  override def isRowFull(row: IRowZone): Boolean = {
    sections(row).getCards.size >= 10
  }

  override def isBoardFull: Boolean = {
    sections.values.forall(_.getCards.size >= 10)
  }
}
