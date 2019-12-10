package karma.dobble.server;

import karma.dooble.common.Card;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void generateCards() {
        //given
        int n = 3;
        int cardCount = n * (n-1) + 1;
        //when
        Deck deck = new Deck(n);
        Set<Card> cards = deck.getCards();

        for (Card card : cards) {
            System.out.println(card.toString());
        }

        //then
        assertEquals(cardCount, cards.size());
        for (Card card : cards) {
            assertEquals(n, card.getCardElements().size());
        }
    }

    @Test
    void drawCard() throws NoSuchFieldException, IllegalAccessException {
        //given
        Set<Card> testCards = new HashSet<>();
        Set<Card> emptyCardsSet = new HashSet<>();
        testCards.add(new Card());

        Field deckCards = Deck.class.getDeclaredField("cards");
        deckCards.setAccessible(true);

        Deck emptyDeck = new Deck();
        deckCards.set(emptyDeck, emptyCardsSet);

        Deck testDeck = new Deck();
        deckCards.set(testDeck, testCards);

        deckCards.setAccessible(false);
        //when
        Optional<Card> emptyOptional = emptyDeck.drawCard();
        Optional<Card> cardOptional = testDeck.drawCard();
        //then
        assertEquals(false, emptyOptional.isPresent());
        assertEquals(true, cardOptional.isPresent());
    }

    @Test
    void shuffle() {
    }
}