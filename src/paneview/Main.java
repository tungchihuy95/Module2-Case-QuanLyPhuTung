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

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("paneview.fxml"));
            primaryStage.setTitle("The gioi phu tung - NEW CENTURY");
            primaryStage.setScene(new Scene(root, 500, 350));
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
//public class Main extends Application  {
////    Button button;
//    @Override
//    public void start(Stage primaryStage) throws Exception{
//        try {
//            Parent root = FXMLLoader.load(getClass().getResource("paneview.fxml"));
//            primaryStage.setScene(new Scene(root, 889, 516));
//            primaryStage.show();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}
