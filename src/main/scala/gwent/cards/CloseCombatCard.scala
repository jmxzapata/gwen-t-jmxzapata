package cl.uchile.dcc
package gwent.cards

class CloseCombatCard(
                       override val name: String,
                       override val description: String,
                       override val power: Int
                     ) extends AbstractUnityCard(name, description, power) {
  override def canEqual(other: Any): Boolean = other.isInstanceOf[CloseCombatCard]
}
