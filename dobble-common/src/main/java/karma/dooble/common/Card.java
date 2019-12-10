package karma.dooble.common;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Card {
    private final Set<CardElement> cardElements;

    Card(){cardElements = null;}

    public Card(Set<CardElement> elements){
        this.cardElements = elements;
    }

    public boolean contains(int id) {
        return cardElements.stream().anyMatch(cardElement -> cardElement.getID() == id);
    }

    //Returns card elements as an unmodifiable set
    public Set<CardElement> getCardElements() {
        return Collections.unmodifiableSet(cardElements);
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardElements=" + cardElements +
                '}';
    }
}
