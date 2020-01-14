package karma.dobble.common.model;

import java.util.*;

public class DeckGenerator {
    private Map<Integer, Set<Card>> cardSets = new HashMap<Integer, Set<Card>>();

    private Set<Card> generateCardSet(int k) {
        int symbolsCount = k * (k - 1) + 1;
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
            for (int j = 0; j < k - 1; j++) {
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

    private Set<Card> generateCardSet2(int k) {
        int n = k - 1;

        int symbolsCount = k * (k - 1) + 1;
        List<CardElement> elements = new ArrayList<>(symbolsCount);
        for (int i = 0; i < symbolsCount; i++) {
            elements.add(new CardElement(i));
        }

        Set<Card> cards = new HashSet<>();

        for (int slope = 0; slope < n; slope++) {
            for (int intercept = 0; intercept < n; intercept++) {
                Set<CardElement> cardElements = new HashSet<>();
                for (int x = 0; x < n; x++) {
                    int y = (slope * x + intercept) % n;
                    cardElements.add(elements.get(y * n + x));
                }
                cardElements.add(elements.get(n * n + slope));
                cards.add(new Card(cardElements));
            }
        }

        for (int x = 0; x < n; x++) {
            Set<CardElement> cardElements = new HashSet<>();
            for (int y = 0; y < n; y++) {
                cardElements.add(elements.get(y * n + x));
            }
            cardElements.add(elements.get(n * n + n));
            cards.add(new Card(cardElements));
        }

        Set<CardElement> cardElements = new HashSet<>();
        for (int i = 0; i < n + 1; i++) {
            cardElements.add(elements.get(n * n + i));
        }
        cards.add(new Card(cardElements));

        return Collections.unmodifiableSet(cards);
    }

    public Set<Card> getCardSet(int n) {
        if (!cardSets.containsKey(n)) {
            cardSets.put(n, generateCardSet2(n));
        }
        return cardSets.get(n);
    }

    public Set<Card> getCardSetCopy(int n) {
        return new HashSet<>(getCardSet(n));
    }
}