package karma.dobble.client.scene;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import karma.dobble.client.utils.FXMLUtils;
import karma.dooble.common.model.Deck;

public class Lobby extends AnchorPane {
    private static Lobby instance;


    public static Lobby getInstance() throws Exception {
        if (instance == null) {
            instance = new Lobby();
        }
        return instance;
    }

    private Scene scene;

    private Lobby() {
        FXMLUtils.loadFXML(this);
    }

    @FXML
    public void initialize() {
        this.scene = new Scene(this, 800, 600);
    }
}
