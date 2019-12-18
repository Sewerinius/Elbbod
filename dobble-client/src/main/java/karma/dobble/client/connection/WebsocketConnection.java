package karma.dobble.client.connection;

import karma.dobble.client.model.Player;
import karma.dooble.common.model.CardElement;

import javax.websocket.DeploymentException;
import java.io.IOException;
import java.net.URISyntaxException;


public class WebsocketConnection implements ServerConnection {
    private DobbleClientEndpoint dobbleClientEndpoint;


    @Override
    public void connect(Player player) throws DeploymentException, IOException, URISyntaxException {
        dobbleClientEndpoint = new DobbleClientEndpoint(player.getName());
    }

    @Override
    public void createNewRoom(Player creator) {

    }

    @Override
    public void checkMatch(Player player, CardElement element) {

    }
}
