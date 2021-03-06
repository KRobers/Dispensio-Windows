package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;

//import org.controlsfx.control.Notifications;

public class Controller  implements Initializable {

    @FXML
    private Button cancelButton;

    @FXML
    public TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label loginMessage;

    @FXML
    private Button addButton;

    @FXML
    private Button SettingsButton;

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

        String sqlLogin = "SELECT * FROM accountgegevens WHERE Gebruikersnaam = '" + usernameField.getText() + "' AND wachtwoord =sha1('" + passwordField.getText() + "')";

        try {
            Statement statement = connectDbReg.createStatement();
            ResultSet result = statement.executeQuery(sqlLogin);

            while (result.next()) {
                if (result.getInt(1) == 1) {
                    loginMessage.setText("Login Succesfull");
                    openapp();
                } else {
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
            Parent root = FXMLLoader.load(getClass().getResource("App.fxml"));
            Stage registerStage = new Stage();
            registerStage.setTitle("Dispensio");
            registerStage.setScene(new Scene(root, 800, 600));
            registerStage.show();
            Stage stage = (Stage) cancelButton.getScene().getWindow();
            stage.close();

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
            Stage stage = (Stage) cancelButton.getScene().getWindow();
            stage.close();

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
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            Stage AddStage = new Stage();
            AddStage.setTitle("Add");
            AddStage.setScene(scene);
            AddStage.show();
            Stage stage = (Stage) addButton.getScene().getWindow();
            stage.close();

        } catch (IOException e) {
            System.out.println("werkt niet");
            ;
        }
    }



      /*public void noti(javafx.event.ActionEvent actionEvent) {
        System.out.println("Notificatie");

       Notifications.create()
                .darkStyle()
                .title("HERINERING")
                .graphic(new Rectangle(300, 100, Color.TRANSPARENT))
                .hideAfter(Duration.seconds(5))
                .text("Uw bent vergeten uw medicatie in te nemen!")
                .show();
    }*/

    @FXML
    private Button cancelBox;

    @FXML
    private TextField naamMedicatie, dosering;

    @FXML
    private DatePicker vanafDate, totDate;

    @FXML
    private Spinner spinnerUur, spinnerMinuut, spinnerDosering;

    @FXML
    private CheckBox maandagCheck, dinsdagCheck, woensdagCheck, donderdagCheck, vrijdagCheck, zaterdagCheck, zondagCheck;

    @FXML
    private String resultaatDagen;

    @FXML
    private Button backtoCalender;


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
        String tijd = (uur + ":" + minuut);

        boolean maandag = maandagCheck.isSelected();
        boolean dinsdag = dinsdagCheck.isSelected();
        boolean woensdag = woensdagCheck.isSelected();
        boolean donderdag = donderdagCheck.isSelected();
        boolean vrijdag = vrijdagCheck.isSelected();
        boolean zaterdag = zaterdagCheck.isSelected();
        boolean zondag = zondagCheck.isSelected();

        if (maandag == true) {
            resultaatDagen = resultaatDagen + "Maandag, ";
        } else {
            resultaatDagen = resultaatDagen;
        }
        if (dinsdag == true) {
            resultaatDagen = resultaatDagen + "Dinsdag, ";
        } else {
            resultaatDagen = resultaatDagen;
        }
        if (woensdag == true) {
            resultaatDagen = resultaatDagen + "Woensdag, ";
        } else {
            resultaatDagen = resultaatDagen;
        }
        if (donderdag == true) {
            resultaatDagen = resultaatDagen + "Donderdag, ";
        } else {
            resultaatDagen = resultaatDagen;
        }
        if (vrijdag == true) {
            resultaatDagen = resultaatDagen + "Vrijdag, ";
        } else {
            resultaatDagen = resultaatDagen;
        }
        if (zaterdag == true) {
            resultaatDagen = resultaatDagen + "Zaterdag, ";
        } else {
            resultaatDagen = resultaatDagen;
        }
        if (zondag == true) {
            resultaatDagen = resultaatDagen + "Zondag";
        } else {
            resultaatDagen = resultaatDagen;
        }

        System.out.println(resultaatDagen);
        Stage stage = (Stage) cancelBox.getScene().getWindow();
        stage.close();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("App.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            Stage Toevoeging = new Stage();
            Toevoeging.setTitle("Add");
            Toevoeging.setScene(scene);
            Toevoeging.show();
        } catch (IOException e) {
            System.out.println("werkt niet");
            ;
        }
        connector connector = new connector();
        Connection connectDbReg = connector.getConnection();

        String Insert = "INSERT INTO innameinformatie (Medicijnnaam,Aantalpillen,Gewicht,Startdatum,Eindatum,TijdInname,Innamedagen) VALUES('";
        String Values = naamMedicijn + "','" + aantalDosering + "','" + doseringmg + "','" + vanaf + "','" + tot + "','" + tijd + "','" + resultaatDagen + "')";
        String addquery = Insert + Values;

        try {
            Statement statement = connectDbReg.createStatement();
            statement.executeUpdate(addquery);

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void backtocalender(javafx.event.ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("App.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            Stage CalendarStage = new Stage();
            CalendarStage.setTitle("Add");
            CalendarStage.setScene(scene);
            CalendarStage.show();
            Stage stage = (Stage) backtoCalender.getScene().getWindow();
            stage.close();

        } catch (IOException e) {
            System.out.println("werkt niet");

        }
    }


    //--------------------settings----------------------------------//

    public void Setup (javafx.event.ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("App.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            Stage AddStage = new Stage();
            AddStage.setTitle("Add");
            AddStage.setScene(scene);
            AddStage.show();
            Stage stage = (Stage) addButton.getScene().getWindow();
            stage.close();

        } catch (IOException e) {
            System.out.println("werkt niet");
            ;
        }
    }

    public void SettingsButton(javafx.event.ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("Settings.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            Stage AddStage = new Stage();
            AddStage.setTitle("Add");
            AddStage.setScene(scene);
            AddStage.show();
            Stage stage = (Stage) SettingsButton.getScene().getWindow();
            stage.close();

        } catch (IOException e) {
            System.out.println("werkt niet");
            ;
        }
    }

    //---------------------tableview-----------------------//
    @FXML
    private TableView<table> tbData;

    @FXML
    private TableColumn<table, String> maandagTable;

    @FXML
    private TableColumn<table, String> dinsdagTable;

    @FXML
    private TableColumn<table, String> woensdagTable;

    @FXML
    private TableColumn<table, String> donderdagTable;

    @FXML
    private TableColumn<table, String> vrijdagTable;

    @FXML
    private TableColumn<table, String> zaterdagTable;

    @FXML
    private TableColumn<table, String> zondagTable;

    @Override
    public void initialize(URL location, ResourceBundle resources){

        maandagTable.setCellValueFactory(new PropertyValueFactory<>("maandagTable"));
        dinsdagTable.setCellValueFactory(new PropertyValueFactory<>("dinsdagTable"));
        woensdagTable.setCellValueFactory(new PropertyValueFactory<>("woensdagTable"));
        donderdagTable.setCellValueFactory(new PropertyValueFactory<>("donderdagTable"));
        vrijdagTable.setCellValueFactory(new PropertyValueFactory<>("vrijdagTable"));
        zaterdagTable.setCellValueFactory(new PropertyValueFactory<>("zaterdagTable"));
        zondagTable.setCellValueFactory(new PropertyValueFactory<>("zondagTable"));

        tbData.setItems(tables);
    }

    private final ObservableList<table> tables = FXCollections.observableArrayList(
            new table("Paracetemol", "", "paracetemol", "", "paracetemol","Antibiotica","Paracetemol"),
            new table("Paracetemol", "", "paracetemol", "", "paracetemol","Antibiotica","Paracetemol")
    );

}
