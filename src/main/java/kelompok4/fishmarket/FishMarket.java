package kelompok4.fishmarket;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FishMarket extends Application {

    public static void main(String[] args) {
        // Launch the JavaFX application
        launch(args);
    }

    /**
     *
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.FXML"));
        AnchorPane root = loader.load();

        // Set up the scene with the loaded FXML
        Scene scene = new Scene(root);

        // Set the title of the main window
        primaryStage.setTitle("FishMarket Application");

        // Set the scene for the primary stage (main window)
        primaryStage.setScene(scene);

        // Show the stage (window)
        primaryStage.show();
    }
}
