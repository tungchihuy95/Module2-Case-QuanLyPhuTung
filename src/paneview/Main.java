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
    public void start(Stage primaryStage) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("logincontrol.fxml"));
//        primaryStage.setTitle("Hello !");
//        primaryStage.setScene(new Scene(root,540, 400));
//        primaryStage.show();
//        try {
            Parent root = FXMLLoader.load(getClass().getResource("paneview.fxml"));
            primaryStage.setTitle("The gioi phu tung - NEW CENTURY");
            primaryStage.setScene(new Scene(root, 850, 600));
            primaryStage.show();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public static void main(String[] args) {
        launch(args);
    }


}