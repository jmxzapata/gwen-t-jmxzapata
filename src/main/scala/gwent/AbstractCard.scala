package cl.uchile.dcc
package gwent

abstract class AbstractCard(
                             override val name: String,
                             override val effect: String
                           ) extends ICard with Equals {

  override def equals(other: Any): Boolean = other match {
    case that: AbstractCard =>
      (that canEqual this) &&
        name == that.name &&
        effect == that.effect
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(name, effect)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}
