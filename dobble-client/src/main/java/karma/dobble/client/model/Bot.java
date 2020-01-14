package karma.dobble.client.model;


import karma.dobble.client.connection.ServerConnection;

import javax.websocket.DeploymentException;
import java.io.IOException;
import java.net.URISyntaxException;

public class Bot extends Player implements Runnable {

    public Bot(ServerConnection connection) throws DeploymentException, IOException, URISyntaxException {
        super("Bot", connection);
    }

    @Override
    public void run() {

    }
}
