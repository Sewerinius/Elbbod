package karma.dobble.server;

import karma.dooble.common.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Deck {
    private Set<Card> cards;
    private int CARD_NUMBER = -1;

    public Deck(Set<Card> cards){
        this.cards = cards;
    }

    public Deck(){
        if(CARD_NUMBER == -1){
            setCardNumber();
        }
        this.cards = new HashSet<>();
    }

    public Optional<Card> drawCard(){
        if(this.cards != null && !cards.isEmpty()){
            Card resultCard = (Card)cards.toArray()[0];
            cards.remove(resultCard);
            return Optional.of(resultCard);
        }
        return Optional.empty();
    }

    public void shuffle(){
        //TODO
    }

    private static void setCardNumber(){
        //TODO
    }
}
