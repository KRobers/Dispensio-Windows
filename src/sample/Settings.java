package sample;
import javafx.event.ActionEvent;
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

public class Settings {

    @FXML
    private PasswordField NewPassword;

    @FXML
    private PasswordField ConfirmNewPassword;

    @FXML
    private Label NewPasswordLabel;

    @FXML
    private Label NewPasswordNotMatching;

    @FXML
    private Button schemaButton;

    @FXML
    private Button voegtoeButton;

        public void CheckPassword (ActionEvent event){

            if (NewPassword.getText().isBlank() == false && ConfirmNewPassword.getText().isBlank() == false) {
                if (NewPassword.getText().equals(ConfirmNewPassword.getText())) {
                    Resetpassword();
                } else {
                    NewPasswordNotMatching.setText("New password don't match");
                }
            } else {
                NewPasswordLabel.setText("Please typ your information to continue");
            }
        }
        public void Resetpassword () {
            connector connector = new connector();
            Connection connectDbReg = connector.getConnection();

            String Newpassword = NewPassword.getText();

            String Insert = "UPDATE accountgegevens SET Wachtwoord = 1 WHERE Gebruikersnaam = 'Jordy'";

            try {
                Statement statement = connectDbReg.createStatement();
                statement.executeUpdate(Insert);

            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }
        }

        public void SchemaButton(){
            try {
                Parent root = FXMLLoader.load(getClass().getResource("App.fxml"));
                Stage registerStage = new Stage();
                registerStage.setTitle("Dispensio");
                registerStage.setScene(new Scene(root, 800, 600));
                registerStage.show();
                Stage stage = (Stage) schemaButton.getScene().getWindow();
                stage.close();

            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }
        }

        public void VoegtoeButton(){
            try {
                Parent root = FXMLLoader.load(getClass().getResource("Toevoeging.fxml"));
                Stage registerStage = new Stage();
                registerStage.setTitle("Dispensio");
                registerStage.setScene(new Scene(root, 800, 600));
                registerStage.show();
                Stage stage = (Stage) voegtoeButton.getScene().getWindow();
                stage.close();

            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }
        }

}