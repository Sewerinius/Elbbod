package karma.dobble.client;

import karma.dooble.common.model.Card;

import javax.websocket.DeploymentException;
import java.io.IOException;
import java.net.URISyntaxException;

public class Player {
    String name;
    Card heldCard;
    int points;
    ServerConnection serverConnection;

    public Player(String name) throws DeploymentException, IOException, URISyntaxException {
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
