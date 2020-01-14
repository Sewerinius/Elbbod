package karma.dobble.common.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    void drawCardEmpty() throws NoSuchFieldException, IllegalAccessException {
        //given
        Set<Card> testCards = new HashSet<>();
        Set<Card> emptyCardsSet = new HashSet<>();
        testCards.add(new Card(new HashSet<>()));

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
    void drawCardAll() throws IllegalAccessException, NoSuchFieldException {
        //given
        Set<Card> someCards = new HashSet<>();
        Set<Card> beginCards = new HashSet<>();
        Card c1 = new Card(new HashSet<>());
        Card c2 = new Card(new HashSet<>());
        Card c3 = new Card(new HashSet<>());
        Card c4 = new Card(new HashSet<>());
        Card c5 = new Card(new HashSet<>());
        someCards.add(c1);
        someCards.add(c2);
        someCards.add(c3);
        someCards.add(c4);
        someCards.add(c5);
        beginCards.add(c1);
        beginCards.add(c2);
        beginCards.add(c3);
        beginCards.add(c4);
        beginCards.add(c5);

        Deck testDeck = new Deck(someCards);

        //then
        while(true){
            Optional<Card> cardOptional = testDeck.drawCard();
            if(!cardOptional.isPresent())break;
            Card card = cardOptional.get();
            if(!beginCards.contains(card))fail();
            beginCards.remove(card);
        }
        if(beginCards.isEmpty())return;
        fail();
    }

    @Test
    void shuffle() {
    }
}