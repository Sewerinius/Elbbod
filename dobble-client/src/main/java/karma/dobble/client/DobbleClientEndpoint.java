package karma.dobble.client;

import karma.dobble.common.message.Message;
import karma.dobble.common.message.MessageDecoder;
import karma.dobble.common.message.MessageEncoder;

import javax.websocket.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@ClientEndpoint(decoders = MessageDecoder.class, encoders = MessageEncoder.class)
public class DobbleClientEndpoint {
    private final static String WS_URI = "ws://localhost:8080/dobble-server/chat/";
    private Session session;

    private String name;

    public DobbleClientEndpoint(String name) {
        this.name = name;

        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        try {
            container.connectToServer(this, new URI(WS_URI + name));
        } catch (DeploymentException | IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Client opened!");
        this.session = session;
    }

    @OnMessage
    public void onMessage(Message message) {
        System.out.println(message.getContent());
    }

    public void sendMessage(String content) {
        Message message = new Message();
        message.setFrom(name);
        message.setContent(content);
        message.setTo("undefined");
        try {
            session.getBasicRemote().sendObject(message);
        } catch (EncodeException | IOException e) {
            e.printStackTrace();
        }
    }
}
