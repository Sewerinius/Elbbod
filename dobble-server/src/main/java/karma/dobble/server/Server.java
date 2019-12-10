package karma.dobble.server;

import karma.dooble.common.*;

import java.util.*;

public class Server {
    private List<Player> players;
    private List<Room> rooms;


    public Server(){
        this.players = new ArrayList<>();
        this.rooms = new ArrayList<>();
    }
    public void addNewUser(Player user){
        players.add(user);
    }

    public void createNewRoom(Player creator){
        Room newRoom = new Room();
        newRoom.addPlayer(creator);
        rooms.add(newRoom);
    }
}
