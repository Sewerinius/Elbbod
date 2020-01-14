package karma.dobble.client.scene;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import karma.dobble.client.components.CardComponent;
import karma.dobble.client.utils.FXMLUtils;
import karma.dobble.common.model.Deck;
import karma.dobble.common.model.DeckGenerator;

public class GameScene extends VBox {
    private Stage stage;
    private Scene scene;

    @FXML
    private CardComponent playerCard;

    @FXML
    private CardComponent globalCard;

    private GameScene() {
        FXMLUtils.loadFXML(this);
    }

    private static class LazyHolder {
        static final GameScene INSTANCE = new GameScene();
    }

    public static GameScene getInstance() {
        return LazyHolder.INSTANCE;
    }

    @FXML
    public void initialize() {
        this.scene = new Scene(this, 800, 600);

        Deck deck = new Deck(new DeckGenerator().getCardSetCopy(5));

        playerCard.setCard(deck.drawCard().get());
        globalCard.setCard(deck.drawCard().get());
    }

    public void displayOn(Stage stage) {
        this.stage = stage;
        this.stage.setScene(scene);
    }
}
