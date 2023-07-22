package scala.gwent

import scala.gwent.cards.ICard

class Player (
               val name: String,
               var gemsCounter: Int,
               var deck: List[ICard],
             ) {
  var cardsInHand: List[ICard] = List()


  def drawCard(): Unit = {
    if (deck.nonEmpty) {
      val card = deck.head
      deck = deck.tail
      cardsInHand = cardsInHand :+ card
    }
  }

  def playCard(): Unit = {
    // Escribir método!...
  }

  override def toString = s"Player(cardsInHand=$cardsInHand, name=$name, gemsCounter=$gemsCounter, deck=$deck)"

  def canEqual(other: Any): Boolean = other.isInstanceOf[Player]

  override def equals(other: Any): Boolean = other match {
    case that: Player =>
      (that canEqual this) &&
        cardsInHand == that.cardsInHand &&
        name == that.name &&
        gemsCounter == that.gemsCounter &&
        deck == that.deck
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(cardsInHand, name, gemsCounter, deck)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}