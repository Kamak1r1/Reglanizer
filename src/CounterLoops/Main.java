package CounterLoops;

import CounterLoops.controllers.Controller;
import CounterLoops.model.Measure;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javax.swing.text.html.ListView;
import java.io.IOException;

public class Main extends Application {
    private static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view/mainWindow.fxml"));
        primaryStage.getIcons().add(new Image("CounterLoops/assets/photo_icon_1.png"));
        primaryStage.setTitle("Reglanizer ver. 0.13");
        primaryStage.setScene(new Scene(root, 900, 535));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }


}
