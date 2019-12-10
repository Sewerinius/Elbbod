package karma.dobble.client;

import karma.dooble.common.CardElement;


public class WebsocketConnection implements ServerConnection {
    private DobbleClientEndpoint dobbleClientEndpoint;

    public WebsocketConnection(){
        this.dobbleClientEndpoint = null;
    }

    @Override
    public void connect(Player player) {
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
