package cl.uchile.dcc
package gwent

trait ICard {
  /** Nombre de la carta */
  val name: String

  /** Efecto de la carta. Su habilidad especial */
  val effect: String
}

