package karma.dobble.server;

import karma.dobble.common.model.Card;

import javax.websocket.Session;

public class Player {
    private String name;
    private Card heldCard;
    private int points;
    private Session session;

    public Player(String name){
        this.name = name;
        this.points = 0;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setHeldCard(Card heldCard) {
        this.heldCard = heldCard;
    }

    public Card getHeldCard() {
        return heldCard;
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }
}
