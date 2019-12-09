package karma.dobble.server;

import karma.dobble.common.message.Message;
import karma.dobble.common.message.MessageDecoder;
import karma.dobble.common.message.MessageEncoder;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint(value = "/chat/{username}", decoders = MessageDecoder.class, encoders = MessageEncoder.class)
public class DobbleServerEndpoint {
    private Session session;
    private static Set<DobbleServerEndpoint> chatEndpoints
            = new CopyOnWriteArraySet<>();
    private static HashMap<String, String> users = new HashMap<>();

    static {
        System.out.println("MSE Static");
    }

    @OnOpen
    public void onOpen(
            Session session,
            @PathParam("username") String username) throws IOException {

        this.session = session;
        chatEndpoints.add(this);
        users.put(session.getId(), username);

        Message message = new Message(username, null, "Connected!\n" + System.getProperty("user.dir"));
        try {
            broadcast(message);
        } catch (EncodeException e) {
            e.printStackTrace();
        }
    }

    @OnMessage
    public void onMessage(Session session, Message message)
            throws IOException {

        Message newMessage = new Message(users.get(session.getId()), message.getTo(), message.getContent());
        try {
            broadcast(newMessage);
        } catch (EncodeException e) {
            e.printStackTrace();
        }
    }

    @OnClose
    public void onClose(Session session) throws IOException {

        chatEndpoints.remove(this);
        Message message = new Message(users.get(session.getId()), null, "Disconnected!");
        try {
            broadcast(message);
        } catch (EncodeException e) {
            e.printStackTrace();
        }
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        // Do error handling here
    }

    private static void broadcast(Message message)
            throws IOException, EncodeException {

        chatEndpoints.forEach(endpoint -> {
            synchronized (endpoint) {
                try {
                    endpoint.session.getBasicRemote().
                            sendObject(message);
                } catch (IOException | EncodeException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
