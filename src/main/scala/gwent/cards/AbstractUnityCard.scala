package cl.uchile.dcc
package gwent.cards

abstract class AbstractUnityCard(
                                  override val name: String,
                                  override val description: String,
                                  override val power: Int
                                ) extends AbstractCard(name, description) with IUnityCard {

  var currentPower: Int = power

  override def canEqual(other: Any): Boolean = other.isInstanceOf[AbstractUnityCard]


  override def equals(other: Any): Boolean = other match {
    case that: AbstractUnityCard =>
      super.equals(that) &&
        (that canEqual this) &&
        currentPower == that.currentPower &&
        power == that.power
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(super.hashCode(), currentPower, power)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}

