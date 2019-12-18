package karma.dobble.server;

import karma.dobble.common.model.Card;
import karma.dobble.common.model.Deck;
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
    void drawCardEmpty() throws NoSuchFieldException, IllegalAccessException {
        //given
        Set<Card> testCards = new HashSet<>();
        Set<Card> emptyCardsSet = new HashSet<>();
        testCards.add(new Card(new HashSet<>()));

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

        Deck testDeck = new Deck();

        Field cardsField = Deck.class.getDeclaredField("cards");
        cardsField.setAccessible(true);
        cardsField.set(testDeck, someCards);
        cardsField.setAccessible(false);

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