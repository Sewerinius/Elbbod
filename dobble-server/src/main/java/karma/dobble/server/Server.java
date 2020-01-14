package karma.dobble.server;

import karma.dobble.common.*;
import karma.dobble.common.model.DeckGenerator;

import java.util.*;

public class Server {
    private List<Player> players;
    private List<Room> rooms;
    private DeckGenerator generator;

    public Server(){
        this.players = new ArrayList<>();
        this.rooms = new ArrayList<>();
        this.generator = new DeckGenerator();
    }
    public void addNewUser(Player user){
        players.add(user);
    }

    public void createNewRoom(Player creator){
        Room newRoom = new Room(generator);
        newRoom.addPlayer(creator);
        rooms.add(newRoom);
    }
}
