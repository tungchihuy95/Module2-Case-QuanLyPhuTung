package paneview;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.Exception;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("paneview.fxml"));
        primaryStage.setTitle("The gioi phu tung - NEW CENTURY");
        primaryStage.setScene(new Scene(root, 850, 600));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }


}