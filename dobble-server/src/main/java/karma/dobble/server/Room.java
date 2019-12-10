package karma.dobble.server;

import karma.dooble.common.*;

import java.util.*;

public class Room {
    private String name;
    private int maxPlayers;
    private List<Player> players;
    private Deck deck;
    private Card currentCard;

    public Room(){
        this.players = new ArrayList<>();
    }

    public void addPlayer(Player player){
        if(!players.contains(player))
            players.add(player);
    }

    public void startGame(){
        deckInit();
        deck.shuffle();
        this.currentCard = deck.drawCard();
        if(currentCard == null){
            System.out.println("Game over :)");
        }
    }

    private void deckInit(){

    }
}
