package karma.dobble.client;

import karma.dooble.common.Card;

public class Player {
    private String name;
    private Card heldCard;
    private int points;
    private ServerConnection serverConnection;

    public Player(String name){
        this.name = name;
        this.points = 0;
        this.serverConnection = new WebsocketConnection();

        this.serverConnection.connect(this);
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
