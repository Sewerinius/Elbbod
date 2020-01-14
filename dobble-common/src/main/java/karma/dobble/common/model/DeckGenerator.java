package karma.dobble.common.model;public class DeckGenerator{private static java.util.Map<java.lang.Integer,java.util.Set<karma.dobble.common.model.Card>> cardSets = new java.util.HashMap<java.lang.Integer,java.util.Set<karma.dobble.common.model.Card>>();private static java.util.Set<karma.dobble.common.model.Card> generateCardSet(int k) {
        int symbolsCount = k * (k - 1) + 1;
        java.util.List<karma.dobble.common.model.CardElement> elements = new java.util.ArrayList<karma.dobble.common.model.CardElement>(symbolsCount);
        for (int i = 0; i < symbolsCount; i++) {
            elements.add(new karma.dobble.common.model.CardElement(i));
        }

        java.util.Set<karma.dobble.common.model.Card> cards = new java.util.HashSet<karma.dobble.common.model.Card>();
        {
            java.util.Set<karma.dobble.common.model.CardElement> cardElements = new java.util.HashSet<karma.dobble.common.model.CardElement>();
            for (int i = 0; i < k; i++) {
                cardElements.add(elements.get(i));
            }
            cards.add(new karma.dobble.common.model.Card(cardElements));
        }

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k - 1; j++) {
                java.util.Set<karma.dobble.common.model.CardElement> elementsUsed = new java.util.HashSet<karma.dobble.common.model.CardElement>();
                java.util.Set<karma.dobble.common.model.CardElement> cardElements = new java.util.HashSet<karma.dobble.common.model.CardElement>();
                for (int l = i; l < symbolsCount; l++) {
                    if (elementsUsed.contains(elements.get(l)))
                        continue;
                    cardElements.add(elements.get(l));
                    for (karma.dobble.common.model.Card card : cards) {
                        if (card.contains(l)) {
                            elementsUsed.addAll(card.getCardElements());
                        }
                    }
                    if (cardElements.size() == k)
                        break;
                }
                cards.add(new karma.dobble.common.model.Card(cardElements));
            }
        }

        return cards;
    }private static java.util.Set<karma.dobble.common.model.Card> getCardSet(int n) {
        if (!cardSets.containsKey(n)) {
            cardSets.put(n, generateCardSet(n));
        }
        return cardSets.get(n); //maybe copy
    }}