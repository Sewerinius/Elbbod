package karma.dobble.common.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class DeckGeneratorTest {

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 6, 8, 12})
    void getCardSet(int n) {
        //given
        int cardCount = n * (n-1) + 1;
        //when
        DeckGenerator generator = new DeckGenerator();
        Set<Card> cards = generator.getCardSet(n);

        int[] usageCounts = new int[cardCount];
        for (Card card : cards) {
            for (CardElement element : card.getCardElements()) {
                usageCounts[element.getId()]++;
            }
//            System.out.println(card.toString());
        }

        //then
        assertEquals(cardCount, cards.size());
        for (Card card : cards) {
            assertEquals(n, card.getCardElements().size());
        }
        for (int i = 0; i < cardCount; i++) {
            assertEquals(usageCounts[i], n);
        }
    }
}