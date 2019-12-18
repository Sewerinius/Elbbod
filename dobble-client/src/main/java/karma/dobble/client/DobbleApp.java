package karma.dobble.client;

import javafx.application.Application;
import javafx.stage.Stage;
import karma.dobble.client.scene.GameScene;
import karma.dobble.client.scene.Lobby;

public class DobbleApp extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Dobble");

//        this.appController = new AppController(primaryStage);
//        this.appController.initRootLayout();

        Lobby lobby = Lobby.getInstance();
        primaryStage.setScene(lobby.getScene());
        primaryStage.show();
    }
}
