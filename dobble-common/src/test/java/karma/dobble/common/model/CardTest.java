package karma.dobble.common.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CardTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void contains() throws NoSuchFieldException, IllegalAccessException {
        //given
        CardElement cardElement1 = Mockito.mock(CardElement.class);
        CardElement cardElement2 = Mockito.mock(CardElement.class);
        CardElement cardElement3 = Mockito.mock(CardElement.class);
        CardElement cardElement4 = Mockito.mock(CardElement.class);
        Set<CardElement> cardElements = new HashSet<>();
        cardElements.add(cardElement1);
        cardElements.add(cardElement2);
        cardElements.add(cardElement3);
        cardElements.add(cardElement4);

        Card card = new Card();
        Field cardElementsField = Card.class.getDeclaredField("cardElements");
        cardElementsField.setAccessible(true);
        cardElementsField.set(card, cardElements);
        cardElementsField.setAccessible(false);

        when(cardElement1.getId()).thenReturn(1);
        when(cardElement2.getId()).thenReturn(2);
        when(cardElement3.getId()).thenReturn(3);
        when(cardElement4.getId()).thenReturn(4);
        //when
        int cardID1 = cardElement1.getId();
        int cardID2 = cardElement2.getId();
        int cardID3 = cardElement3.getId();
        int cardID4 = cardElement4.getId();

        CardElement cardElement5 = Mockito.mock(CardElement.class);
        when(cardElement5.getId()).thenReturn(5);
        int notID = cardElement5.getId();
        //then
        assertTrue(card.contains(cardID1));
        assertTrue(card.contains(cardID2));
        assertTrue(card.contains(cardID3));
        assertTrue(card.contains(cardID4));
        assertFalse(card.contains(notID));
    }

    @Test
    void getCardElements() throws NoSuchFieldException, IllegalAccessException {
        //given
        CardElement cardElement1 = Mockito.mock(CardElement.class);
        CardElement cardElement2 = Mockito.mock(CardElement.class);
        CardElement cardElement3 = Mockito.mock(CardElement.class);
        CardElement cardElement4 = Mockito.mock(CardElement.class);
        Set<CardElement> cardElements = new HashSet<>();
        Set<CardElement> beginElements = new HashSet<>();
        cardElements.add(cardElement1);
        cardElements.add(cardElement2);
        cardElements.add(cardElement3);
        cardElements.add(cardElement4);
        beginElements.add(cardElement1);
        beginElements.add(cardElement2);
        beginElements.add(cardElement3);
        beginElements.add(cardElement4);

        Card card = new Card();
        Field cardElementsField = Card.class.getDeclaredField("cardElements");
        cardElementsField.setAccessible(true);
        cardElementsField.set(card, cardElements);
        cardElementsField.setAccessible(false);

        //when
        Set<CardElement> returnedElements = card.getCardElements();
        //then
        for (CardElement element : returnedElements) {
            assertTrue(beginElements.contains(element));
            beginElements.remove(element);
        }
        assertTrue(beginElements.isEmpty());
    }
}