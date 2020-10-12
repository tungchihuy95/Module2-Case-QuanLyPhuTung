package paneview;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class LoginController implements Initializable {

    @FXML
    private Button cancelButton;
    @FXML
    private Button loginButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private ImageView logoxeImageView;
    @FXML
    private ImageView lockImageView;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordTextField;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        File logoxeFile = new File("image/logoxe.png");
//        Image logoxeImage = new Image(logoxeFile.toURI().toString());
//        logoxeImageView.setImage(logoxeImage);
//
//        File lockFile = new File("image/newlock.png");
//        Image lockImage = new Image(lockFile.toURI().toString());
//        lockImageView.setImage(lockImage);


    }

    public void loginButtonOnAction(ActionEvent event) throws Exception{
//        usernameTextField.setText("tung");
//        Scanner scanner = new Scanner(System.in);
//        String usernameInput = scanner.nextLine();
//        if (usernameInput.equals(usernameTextField.getText())) {
//            Alert.AlertType alertAlertType;
//            Alert alert;
//            alert.show();

        if (usernameTextField.getText().isBlank() || passwordTextField.getText().isBlank()) {
        }
        }





    public void cancelButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }


    public void validateLogin() {
    }

}
