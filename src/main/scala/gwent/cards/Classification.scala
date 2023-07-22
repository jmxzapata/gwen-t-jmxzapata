package scala.gwent.cards

/**
 * A sealed trait representing the classification of a unity card in a card game.
 *
 * This enumeration defines three possible classifications of unity cards: HandToHand, Distance, and Asedio.
 * These classifications are used to categorize unity cards based on their combat characteristics.
 */
enum Classification {

/**
 * A case representing the HandToHand classification of a unity card.
 *
 * HandToHand classification indicates that the unity card is suitable for close combat.
 * These cards are generally strong in close-range battles and have special abilities related to close combat.
 */
case HandToHand

/**
 * A case representing the Distance classification of a unity card.
 *
 * Distance classification indicates that the unity card is suitable for ranged combat.
 * These cards are effective in battles from a distance and may have abilities related to ranged combat tactics.
 */
case Distance

/**
 * A case representing the Asedio classification of a unity card.
 *
 * Asedio classification indicates that the unity card is suitable for siege combat.
 * These cards are designed for siege warfare and may have abilities that target siege-related strategies.
 */
case Asedio

}
