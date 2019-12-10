package karma.dobble.client;

import karma.dooble.common.CardElement;

import javax.websocket.DeploymentException;
import java.io.IOException;
import java.net.URISyntaxException;


public class WebsocketConnection implements ServerConnection {
    private DobbleClientEndpoint dobbleClientEndpoint;

    public WebsocketConnection(){
        this.dobbleClientEndpoint = null;
    }

    @Override
    public void connect(Player player) throws DeploymentException, IOException, URISyntaxException {
        if(dobbleClientEndpoint != null)
            dobbleClientEndpoint = new DobbleClientEndpoint(player.getName());

    }

    @Override
    public void createNewRoom(Player creator) {

    }

    @Override
    public void checkMatch(Player player, CardElement element) {

    }
}
