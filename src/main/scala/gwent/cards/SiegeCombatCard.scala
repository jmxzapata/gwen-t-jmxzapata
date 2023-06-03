package cl.uchile.dcc
package gwent.cards

class SiegeCombatCard(
                              override val name: String,
                              override val description: String,
                              override val power: Int
                            ) extends AbstractUnityCard(name, description, power){
  override def canEqual(other: Any): Boolean = other.isInstanceOf[SiegeCombatCard]
}

