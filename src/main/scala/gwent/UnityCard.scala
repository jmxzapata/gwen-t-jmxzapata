package cl.uchile.dcc
package gwent

class UnityCard(
                 name: String,
                 effect: String,
                 override val classification: Classification,
                 override val strength: Int
               ) extends AbstractCard(name, effect) with IUnityCard {

  override def toString: String = s"UnityCard(name=$name, effect=$effect, classification=$classification, strength=$strength)"

  override def canEqual(other: Any): Boolean = other.isInstanceOf[UnityCard]

  override def equals(other: Any): Boolean = other match {
    case that: UnityCard =>
      super.equals(that) &&
        (that canEqual this) &&
        classification == that.classification &&
        strength == that.strength
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(super.hashCode(), classification, strength)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}
