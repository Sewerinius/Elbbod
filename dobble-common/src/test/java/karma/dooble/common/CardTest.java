package karma.dooble.common;

import karma.dooble.common.model.Card;
import karma.dooble.common.model.CardElement;
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

        when(cardElement1.getID()).thenReturn(1);
        when(cardElement2.getID()).thenReturn(2);
        when(cardElement3.getID()).thenReturn(3);
        when(cardElement4.getID()).thenReturn(4);
        //when
        int cardID1 = cardElement1.getID();
        int cardID2 = cardElement2.getID();
        int cardID3 = cardElement3.getID();
        int cardID4 = cardElement4.getID();

        CardElement cardElement5 = Mockito.mock(CardElement.class);
        when(cardElement5.getID()).thenReturn(5);
        int notID = cardElement5.getID();
        //then
        assertEquals(true, card.contains(cardID1));
        assertEquals(true, card.contains(cardID2));
        assertEquals(true, card.contains(cardID3));
        assertEquals(true, card.contains(cardID4));
        assertEquals(false, card.contains(notID));
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
        Iterator<CardElement> itrReturnedElements = returnedElements.iterator();
        while(itrReturnedElements.hasNext()){
            CardElement element = itrReturnedElements.next();
            if(!beginElements.contains(element))fail();
            beginElements.remove(element);
        }
        if(beginElements.isEmpty())return;
        fail();
    }
}