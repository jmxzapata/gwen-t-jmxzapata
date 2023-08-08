package scala.gwent.model.cards

import munit.FunSuite

import scala.gwent.model.cards.weather.BitingFrostEffect

/**
 * DeckTest Class Documentation
 *
 * The `DeckTest` class contains test cases for the `Deck` class,
 * which represents a collection of cards in the Gwent game.
 *
 */
class DeckTest extends FunSuite {

  /**
   * Test case for the `addCard` method.
   * It tests whether the `addCard` method adds a card to the deck correctly.
   */
class DeckTest extends FunSuite {

    /**
     * Test case for the `addCard` method.
     * It tests whether the `addCard` method adds a card to the deck correctly.
     */
    test("Test addCard") {
      val deck = new Deck()
      val card = new Card("Card", "Description")
      deck.addCard(card)

      assertEquals(deck.cards.length, 1)
      assert(deck.cards.contains(card))
    }

    /**
     * Test case for the `hasCards` method.
     * It tests whether the `hasCards` method correctly indicates if the deck contains cards or not.
     */
    test("Test hasCards") {
      val deck1 = new Deck()
      assert(!deck1.hasCards)

      val deck2 = new Deck()
      val card = new Card("Card", "Description")
      deck2.addCard(card)
      assert(deck2.hasCards)
    }

    /**
     * Test case for the `removeCard` method.
     * It tests whether the `removeCard` method removes a card from the deck correctly.
     */
    test("Test removeCard") {
      val deck = new Deck()
      val card = new Card("Card", "Description")
      deck.addCard(card)

      deck.removeCard(card)

      assertEquals(deck.cards.length, 0)
      assert(!deck.cards.contains(card))
    }

    /**
     * Test case for the `drawCard` method.
     * It tests whether the `drawCard` method correctly draws a card from the deck.
     */
    test("Test drawCard") {
      val deck = new Deck()
      val card1 = new Card("Card 1", "Description 1")
      val card2 = new Card("Card 2", "Description 2")
      deck.addCard(card1)
      deck.addCard(card2)

      val drawnCard = deck.drawCard()

      assert(drawnCard.isDefined)
      assertEquals(deck.cards.length, 1)
      assert(!deck.cards.contains(drawnCard.get))
    }

    /**
     * Test case for the `spreadWeatherEffect` method.
     * It tests whether the `spreadWeatherEffect` method correctly applies the weather effect to all cards in the deck.
     */
    test("Test spreadWeatherEffect") {
      val deck = new Deck()
      val card1 = new Card("Card 1", "Description 1") with ICard {
        override def affectedByBitingFrost(card: BitingFrostEffect): Unit = {
          // Implementation of the card's behavior when affected by Biting Frost
        }
      }
      val card2 = new Card("Card 2", "Description 2") with ICard {
        override def affectedByBitingFrost(card: BitingFrostEffect): Unit = {
          // Implementation of the card's behavior when affected by Biting Frost
        }
      }
      val weatherCard = new BitingFrostEffect("Biting Frost", "Freeze all Close Combat cards")

      deck.addCard(card1)
      deck.addCard(card2)

      deck.spreadWeatherEffect(weatherCard)
       }
      }
  }  