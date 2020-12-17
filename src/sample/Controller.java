package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;


public class Controller {

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

   /* @FXML
    public void noti(javafx.event.ActionEvent actionEvent) {
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
        public void closebutton (ActionEvent actionEvent) {
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
    }
