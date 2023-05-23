package cl.uchile.dcc
package gwent

trait IUnityCard extends ICard {
  /** Clasificación de la carta (de los tres posibles) */
  val classification: Classification

  /** Valor que representa la fuerza */
  val strength: Int

}