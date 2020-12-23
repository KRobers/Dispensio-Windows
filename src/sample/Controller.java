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
import java.time.LocalDate;

public class Controller {

    @FXML
    private Button cancelButton;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label loginMessage;

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

        String sqlLogin = "SELECT * FROM accountgegevens WHERE Gebruikersnaam = '" + usernameField.getText() + "' AND wachtwoord ='" + passwordField.getText() + "'";

        try {
            Statement statement = connectDbReg.createStatement();
            ResultSet result = statement.executeQuery(sqlLogin);

            while (result.next()) {
                if (result.getInt(1) == 1) {
                    loginMessage.setText("Login Succesfull");
                    openapp();
                } else {
                    loginMessage.setText("Login Succesfull");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void openapp() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("App.fxml"));
            /*
             * if "fx:controller" is not set in fxml
             * fxmlLoader.setController(NewWindowController);
             */
            Scene scene = new Scene(fxmlLoader.load(), 630, 400);
            Stage stage = new Stage();
            stage.setTitle("Dispensio");
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void createAccount() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("register.fxml"));
            Stage registerStage = new Stage();
            registerStage.setTitle("Dispensio");
            registerStage.setScene(new Scene(root, 800, 600));
            registerStage.show();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
    // ----------------------------------------------------------------------------------

    @FXML
    public void add(javafx.event.ActionEvent actionEvent) {
        System.out.println("Add Medicijn");

        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("Toevoeging.fxml"));
            /*
             * if "fx:controller" is not set in fxml
             * fxmlLoader.setController(NewWindowController);
             */
            Scene scene = new Scene(fxmlLoader.load(), 630, 400);
            Stage stage = new Stage();
            stage.setTitle("Add");
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            System.out.println("werkt niet");
            ;
        }
    }


   /* public void noti(javafx.event.ActionEvent actionEvent) {
        System.out.println("Notificatie");

        Notifications.create()
                .darkStyle()
                .title("HERINERING")
                .graphic(new Rectangle(300, 100, Color.TRANSPARENT))
                .hideAfter(Duration.seconds(5))
                .text("Uw bent vergeten uw medicatie in te nemen!")
                .show();
    }
*/
    @FXML
    private Button cancelBox;

    @FXML
    private TextField naamMedicatie;

    @FXML
    private TextField dosering;

    @FXML
    private Spinner spinnerDosering;

    @FXML
    private DatePicker vanafDate;

    @FXML
    private DatePicker totDate;

    @FXML
    private Spinner spinnerUur;

    @FXML
    private Spinner spinnerMinuut;

    @FXML
    private CheckBox maandagCheck;

    @FXML
    private CheckBox dinsdagCheck;

    @FXML
    private CheckBox woensdagCheck;

    @FXML
    private CheckBox donderdagCheck;

    @FXML
    private CheckBox vrijdagCheck;

    @FXML
    private CheckBox zaterdagCheck;

    @FXML
    private CheckBox zondagCheck;

    @FXML
    public void closeButtononAction(ActionEvent actionEvent) {
        String naamMedicijn = naamMedicatie.getText();
        System.out.println(naamMedicijn);

        int aantalDosering = (int) spinnerDosering.getValue();
        System.out.println(aantalDosering);

        String doseringmg = dosering.getText();
        System.out.printf(doseringmg);

        System.out.println();

        LocalDate vanaf = vanafDate.getValue();
        System.out.println(vanaf);

        LocalDate tot = totDate.getValue();
        System.out.println(tot);

        int uur = (int) spinnerUur.getValue();
        int minuut = (int) spinnerMinuut.getValue();
        System.out.println(uur + ":" + minuut);


        boolean maandag = maandagCheck.isSelected();
        boolean dinsdag = dinsdagCheck.isSelected();
        boolean woensdag = woensdagCheck.isSelected();
        boolean donderdag = donderdagCheck.isSelected();
        boolean vrijdag = vrijdagCheck.isSelected();
        boolean zaterdag = zaterdagCheck.isSelected();
        boolean zondag = zondagCheck.isSelected();
        System.out.println("Maandag: " + maandag + " Dinsdag: " + dinsdag + " Woensdag: " + woensdag + " Donderdag: " + donderdag + " Vrijdag: " + vrijdag + " Zaterdag: " + zaterdag + " Zondag: " + zondag);

        Stage stage = (Stage) cancelBox.getScene().getWindow();
        stage.close();


    }

    //--------------------settings----------------------------------//
    public void Setup() throws Exception {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("Settings.fxml"));
            /*
             * if "fx:controller" is not set in fxml
             * fxmlLoader.setController(NewWindowController);
             */
            Scene scene = new Scene(fxmlLoader.load(), 630, 400);
            Stage stage = new Stage();
            stage.setTitle("Dispensio");
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

    }



    }

