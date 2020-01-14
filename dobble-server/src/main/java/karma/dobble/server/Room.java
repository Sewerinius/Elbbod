package karma.dobble.server;

import karma.dobble.common.model.Card;
import karma.dobble.common.model.Deck;
import karma.dobble.common.model.DeckGenerator;

import java.util.*;

public class Room {
    private final int DEFAULT_SYMBOLS_PER_CARD = 5;

    private int symbolsPerCard;
    private String name;
    private int maxPlayers;
    private List<Player> players;
    private Deck deck;
    private DeckGenerator generator;
    private Card currentCard;

    public Room(DeckGenerator generator){
        this.symbolsPerCard = DEFAULT_SYMBOLS_PER_CARD;
        this.players = new ArrayList<>();
        this.generator = generator;
    }

    public void addPlayer(Player player){
        if(!players.contains(player)) {
            players.add(player);
        }
    }

    public void startGame(){
        deck = new Deck(generator.getCardSetCopy(symbolsPerCard));

        Optional<Card> drawnCard = deck.drawCard();
        if(drawnCard.isPresent())
            this.currentCard = drawnCard.get();
        else
            System.out.println("game over :)");
    }


    public void setSymbolsPerCard(int symbolsPerCard) {
        this.symbolsPerCard = symbolsPerCard;
    }
}
