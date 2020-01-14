package karma.dobble.common.model;

import java.util.Collections;
import java.util.Set;

public class Card {
    private final Set<CardElement> cardElements;

    Card() {
        cardElements = null;
    }

    public Card(Set<CardElement> elements) {
        this.cardElements = Set.copyOf(elements);
    }

    public boolean contains(int id) {
        return cardElements.stream().anyMatch(cardElement -> cardElement.getId() == id);
    }

    public Set<CardElement> getCardElements() {
        return cardElements;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardElements=" + cardElements +
                '}';
    }
}
