package karma.dobble.client;

import javafx.application.Application;
import javafx.stage.Stage;
import karma.dobble.client.controller.AppController;

public class HelloFXML extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    private Stage primaryStage;
    private AppController appController;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("FXML Test");

        this.appController = new AppController(primaryStage);
        this.appController.initRootLayout();
    }
}
