package karma.dobble.server;

import karma.dooble.common.*;

import java.util.HashSet;
import java.util.Set;

public class Deck {
    private Set<Card> cards;
    private static int CARD_NUMBER = -1;

    public Deck(Set<Card> cards){

    }

    public Deck(){
        if(CARD_NUMBER == -1){
            setCardNumber();
        }
        this.cards = new HashSet<>();
    }

    public Card drawCard(){
        if(this.cards != null && !cards.isEmpty()){
            Card resultCard = (Card)cards.toArray()[0];
            cards.remove(resultCard);
            return resultCard;
        }
        return null;
    }

    public void shuffle(){
        //TODO
    }

    private static void setCardNumber(){
        //TODO
    }
}
