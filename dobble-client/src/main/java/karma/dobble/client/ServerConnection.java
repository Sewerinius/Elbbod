package karma.dobble.client;

import karma.dooble.common.CardElement;

public interface ServerConnection {
    void connect(Player player);
    void createNewRoom(Player creator);
    void checkMatch(Player player, CardElement element);
}
