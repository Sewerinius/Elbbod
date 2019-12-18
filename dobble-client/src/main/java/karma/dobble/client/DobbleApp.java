package karma.dobble.client;

import javafx.application.Application;
import javafx.stage.Stage;
import karma.dobble.client.controller.AppController;
import karma.dobble.client.scene.GameScene;

public class DobbleApp extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    private Stage primaryStage;
    private AppController appController;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("FXML Test123");

//        this.appController = new AppController(primaryStage);
//        this.appController.initRootLayout();
        GameScene gameScene = GameScene.getInstance();
        primaryStage.setScene(gameScene.getScene());
        primaryStage.show();
    }
}
