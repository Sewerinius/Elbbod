package karma.dobble.server;

import karma.dooble.common.Card;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    void drawCard() {
        //given
        Set<Card> testCards = new HashSet<>();
        Set<Card> emptyCardsSet = new HashSet<>();
        testCards.add(new Card());
        Deck emptyDeck = new Deck(emptyCardsSet);
        Deck testDeck = new Deck(testCards);
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