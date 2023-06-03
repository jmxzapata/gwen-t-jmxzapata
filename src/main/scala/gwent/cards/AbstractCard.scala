package cl.uchile.dcc
package gwent.cards

import gwent.cards.ICard

abstract class AbstractCard(
                             override val name: String,
                             override val description: String,
                           ) extends ICard with Equals {

  override def canEqual(that: Any): Boolean = that.isInstanceOf[AbstractCard]

  override def equals(other: Any): Boolean = other match {
    case that: AbstractCard =>
      (that canEqual this) &&
        name == that.name &&
        description == that.description
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(name, description)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}
