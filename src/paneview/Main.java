package paneview;//package paneview;
//
//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.lang.Exception;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("logincontrol.fxml"));
//        primaryStage.setTitle("Hello !");
//        primaryStage.setScene(new Scene(root,540, 400));
//        primaryStage.show();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("paneview.fxml"));
            primaryStage.setTitle("The gioi phu tung - NEW CENTURY");
            primaryStage.setScene(new Scene(root, 500, 350));
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }


}

