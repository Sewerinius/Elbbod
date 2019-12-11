package karma.dobble.server;

import karma.dooble.common.model.Card;

import java.util.*;

public class Room {
    private int symbolsPerCard = 5;
    private String name;
    private int maxPlayers;
    private List<Player> players;
    private Deck deck = null;
    private Card currentCard;

    public Room(){
        this.players = new ArrayList<>();
    }

    public void addPlayer(Player player){
        if(!players.contains(player))
            players.add(player);
    }

    public void startGame(){
        deck = new Deck(symbolsPerCard);

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
