package karma.dobble.client.scene;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import karma.dobble.client.utils.FXMLUtils;

public class LobbyScene extends AnchorPane {
    private static LobbyScene instance;


    public static LobbyScene getInstance() throws Exception {
        if (instance == null) {
            instance = new LobbyScene();
        }
        return instance;
    }

    private Scene scene;
    private Stage stage;

    private LobbyScene() {
        FXMLUtils.loadFXML(this);
    }

    @FXML
    public void initialize() {
        this.scene = new Scene(this, 800, 600);
    }

    public void displayOn(Stage stage) {
        this.stage = stage;
        this.stage.setScene(scene);
    }

    @FXML
    public void startGame() {
        GameScene gameScene = GameScene.getInstance();
        gameScene.displayOn(stage);
    }
}
