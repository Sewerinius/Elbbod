package karma.dobble.client.connection;

import karma.dobble.client.model.Player;
import karma.dobble.common.model.CardElement;

import javax.websocket.DeploymentException;
import java.io.IOException;
import java.net.URISyntaxException;

public interface ServerConnection {
    void connect(Player player) throws DeploymentException, IOException, URISyntaxException;
    void createNewRoom(Player creator);
    void checkMatch(Player player, CardElement element);
}
