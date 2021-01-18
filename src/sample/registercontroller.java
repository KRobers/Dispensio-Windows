package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.Statement;

public class registercontroller {

    @FXML
    private Button Cancelbox;

    @FXML
    private Label RegistrationLabel;

    @FXML
    private PasswordField Passwordbox;

    @FXML
    private PasswordField Cpasswordbox;

    @FXML
    private Label passwordNotMatching;

    @FXML
    private TextField Usernamebox;

    public void closeButtononAction(ActionEvent event) {
        Stage stage = (Stage) Cancelbox.getScene().getWindow();
        stage.close();
        Platform.exit();
    }

    public void registerbuttonaction(ActionEvent event) {

        if (Passwordbox.getText().equals(Cpasswordbox.getText())) {
            passwordNotMatching.setText("Passwords match");
            registerUser();
        } else {
            passwordNotMatching.setText("Passwords do not match");
        }
    }

    public void registerUser(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
            Stage registerStage = new Stage();
            registerStage.setTitle("Dispensio");
            registerStage.setScene(new Scene(root, 800, 600));
            registerStage.show();
            Stage stage = (Stage) Cancelbox.getScene().getWindow();
            stage.close();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
         connector connectnow = new connector();
         Connection connectDbReg = connectnow.getConnection();

         String Username = Usernamebox.getText();
         String Password = Passwordbox.getText();

         String insertFieldsQuery = "INSERT INTO accountgegevens(Gebruikersnaam,Wachtwoord) VALUES ('";
         String insertValues = Username + "','" + Password + "')";
         String insertRegister = insertFieldsQuery + insertValues;

        try {
            Statement statement = connectDbReg.createStatement();
            statement.executeUpdate(insertRegister);
            RegistrationLabel.setText("User registered succesfully!");

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
}
