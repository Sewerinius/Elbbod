package karma.dooble.common;

import java.util.HashSet;
import java.util.Set;

public class Card {
    private Set<CardElement> cardElements;

    public Card(){
        this.cardElements = new HashSet<>();
    }
}
