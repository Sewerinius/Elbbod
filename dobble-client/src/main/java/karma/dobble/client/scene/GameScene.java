package karma.dobble.client.scene;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import karma.dobble.client.components.CardComponent;
import karma.dobble.client.utils.FXMLUtils;
import karma.dooble.common.model.Deck;

public class GameScene extends VBox {
    private static GameScene instance;


    public static GameScene getInstance() {
        if (instance == null) {
            instance = new GameScene();
        }
        return instance;
    }

    private Scene scene;

    @FXML
    private CardComponent playerCard;

    @FXML
    private CardComponent globalCard;

    private GameScene() {
        FXMLUtils.loadFXML(this);
    }

    @FXML
    public void initialize() {
        this.scene = new Scene(this, 800, 600);

        Deck deck = new Deck(5);

        playerCard.setCard(deck.drawCard().get());
        globalCard.setCard(deck.drawCard().get());
    }
}
