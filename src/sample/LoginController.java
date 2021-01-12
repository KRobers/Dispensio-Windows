package sample;

/*import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
//import org.controlsfx.control.Notifications;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginController {

    @FXML
    private Button cancelButton;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label loginMessage;

    public LoginController() {
    }

    public void LoginButtonOnAction(ActionEvent event) {
        if (usernameField.getText().isBlank() == false && passwordField.getText().isBlank() == false) {
             validateLogin();
      } else {
          loginMessage.setText("Please typ your information to continue");
      }
    }

    public void cancelButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void validateLogin() {
        connector connector = new connector();
        Connection connectDbReg = connector.getConnection();

        String sqlLogin = "SELECT * FROM accountgegevens WHERE Gebruikersnaam = '" + usernameField.getText() + "' AND wachtwoord ='" + passwordField.getText() +"'" ;

        try {
            Statement statement = connectDbReg.createStatement();
            ResultSet result = statement.executeQuery(sqlLogin);

            while (result.next()) {
                if (result.getInt(1) == 1) {
                    loginMessage.setText("Login Succesfull");
                    openapp();
                }
                else {
                    loginMessage.setText("Login Unsuccesfull");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void openapp() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("   setting.fxml"));
            Stage registerStage =new Stage();
            registerStage.setTitle("Dispensio");
            registerStage.setScene(new Scene(root, 800, 600));
            registerStage.show();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void createAccount() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("register.fxml"));
            Stage registerStage =new Stage();
            registerStage.setTitle("Dispensio");
            registerStage.setScene(new Scene(root, 800, 600));
            registerStage.show();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
}*/
