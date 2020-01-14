package karma.dobble.client.scene;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import karma.dobble.client.utils.FXMLUtils;

public class LobbyScene extends AnchorPane {
    private Scene scene;
    private Stage stage;

    private LobbyScene() {
        FXMLUtils.loadFXML(this);
    }

    private static class LazyHolder {
        static final LobbyScene INSTANCE = new LobbyScene();
    }

    public static LobbyScene getInstance() throws Exception {
        return LazyHolder.INSTANCE;
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
