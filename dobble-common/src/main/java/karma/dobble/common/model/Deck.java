package karma.dobble.common.model;

import java.util.*;

public class Deck {
    private final Set<Card> cards;

    public Deck(Set<Card> cards) {
        this.cards = cards;
    }

    public Optional<Card> drawCard() {
        if (this.cards != null && !cards.isEmpty()) {
            Card resultCard = (Card) cards.toArray()[0];
            cards.remove(resultCard);
            return Optional.of(resultCard);
        }
        return Optional.empty();
    }

    public void shuffle() {
        //TODO
    }

    public Set<Card> getCards() {
        return Collections.unmodifiableSet(cards);
    }


}
