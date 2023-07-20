package scala.gwent.model.cards

import munit.FunSuite

import scala.gwent.model.cards.weather.BitingFrostEffect

class DeckTest extends FunSuite {

  test("Test addCard") {
    val deck = new Deck()
    val card = new Card("Card", "Description")
    deck.addCard(card)

    assertEquals(deck.cards.length, 1)
    assert(deck.cards.contains(card))
  }

  test("Test hasCards") {
    val deck1 = new Deck()
    assert(!deck1.hasCards)

    val deck2 = new Deck()
    val card = new Card("Card", "Description")
    deck2.addCard(card)
    assert(deck2.hasCards)
  }

  test("Test removeCard") {
    val deck = new Deck()
    val card = new Card("Card", "Description")
    deck.addCard(card)

    deck.removeCard(card)

    assertEquals(deck.cards.length, 0)
    assert(!deck.cards.contains(card))
  }

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


  test("Test spreadWeatherEffect") {
    val deck = new Deck()
    val card1 = new Card("Card 1", "Description 1") with ICard {
      override def affectedByBitingFrost(card: BitingFrostEffect): Unit = {
        // Implementation of the card's behavior when affected by Biting Frost
      }
      // Other method implementations
    }
    val card2 = new Card("Card 2", "Description 2") with ICard {
      override def affectedByBitingFrost(card: BitingFrostEffect): Unit = {
        // Implementation of the card's behavior when affected by Biting Frost
      }
      // Other method implementations
    }
    val weatherCard = new BitingFrostEffect("Biting Frost", "Freeze all Close Combat cards")

    deck.addCard(card1)
    deck.addCard(card2)

    deck.spreadWeatherEffect(weatherCard)

    // Ensure that the weather effect is applied to all cards in the deck
    // Add assertions for the expected behavior
  }
}