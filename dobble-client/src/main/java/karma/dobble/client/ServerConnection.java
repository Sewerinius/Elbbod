package karma.dobble.client;

import karma.dooble.common.model.CardElement;

import javax.websocket.DeploymentException;
import java.io.IOException;
import java.net.URISyntaxException;

public interface ServerConnection {
    void connect(Player player) throws DeploymentException, IOException, URISyntaxException;
    void createNewRoom(Player creator);
    void checkMatch(Player player, CardElement element);
}
