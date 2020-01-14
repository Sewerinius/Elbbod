package karma.dobble.client.model;


import javax.websocket.DeploymentException;
import java.io.IOException;
import java.net.URISyntaxException;

public class Bot extends Player implements Runnable {

    public Bot() throws DeploymentException, IOException, URISyntaxException {
        super("Bot");
    }

    @Override
    public void run() {

    }
}
