package karma.dobble.server;

import karma.dooble.common.model.Card;
import karma.dooble.common.model.CardElement;

import java.util.*;

public class Deck {
    private static Map<Integer, Set<Card>> cardSets = new HashMap<>();

    private static Set<Card> generateCardSet(int k) {
        int symbolsCount = k * (k-1) + 1;
        List<CardElement> elements = new ArrayList<>(symbolsCount);
        for (int i = 0; i < symbolsCount; i++) {
            elements.add(new CardElement(i));
        }

        Set<Card> cards = new HashSet<>();
        {
            Set<CardElement> cardElements = new HashSet<>();
            for (int i = 0; i < k; i++) {
                cardElements.add(elements.get(i));
            }
            cards.add(new Card(cardElements));
        }

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k-1; j++) {
                Set<CardElement> elementsUsed = new HashSet<>();
                Set<CardElement> cardElements = new HashSet<>();
                for (int l = i; l < symbolsCount; l++) {
                    if (elementsUsed.contains(elements.get(l)))
                        continue;
                    cardElements.add(elements.get(l));
                    for (Card card : cards) {
                        if (card.contains(l)) {
                            elementsUsed.addAll(card.getCardElements());
                        }
                    }
                    if (cardElements.size() == k)
                        break;
                }
                cards.add(new Card(cardElements));
            }
        }

        return cards;
    }

    private static Set<Card> getCardSet(int n) {
        if (!cardSets.containsKey(n)) {
            cardSets.put(n, generateCardSet(n));
        }
        return cardSets.get(n); //maybe copy
    }

    private final Set<Card> cards;

    public Deck(int n) {
        cards = getCardSet(n);
    }

    Deck(){cards = null;}



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

    public Set<Card> getCards() {
        return Collections.unmodifiableSet(cards);
    }


}
