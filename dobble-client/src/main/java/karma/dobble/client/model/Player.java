package karma.dobble.client.model;

import karma.dobble.client.connection.ServerConnection;
import karma.dobble.client.connection.WebsocketConnection;
import karma.dobble.common.model.Card;

import javax.websocket.DeploymentException;
import java.io.IOException;
import java.net.URISyntaxException;

public class Player {
    private String name;
    private Card heldCard;
    private int points;
    private ServerConnection serverConnection;

    public Player(String name, ServerConnection connection) throws DeploymentException, IOException, URISyntaxException {
        this.name = name;
        this.points = 0;
        this.serverConnection = connection;

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
