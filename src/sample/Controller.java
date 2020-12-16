package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import java.io.IOException;


public class Controller {
    @FXML
    public void add(javafx.event.ActionEvent actionEvent) {
        System.out.println("Hello, World!");

        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("Toevoeging.fxml"));
            /*
             * if "fx:controller" is not set in fxml
             * fxmlLoader.setController(NewWindowController);
             */
            Scene scene = new Scene(fxmlLoader.load(), 630, 400);
            Stage stage = new Stage();
            stage.setTitle("New Window");
            stage.setScene(scene);
            stage.show();


        }

        catch (IOException e) {
            System.out.println("werkt niet");
            ;
        }
    }

    @FXML
    public void noti(javafx.event.ActionEvent actionEvent){
        System.out.println("Notificatie");

        Notifications.create()
                .darkStyle()
                .title("HERINERING")
                .graphic(new Rectangle(300, 100, Color.TRANSPARENT))
                .hideAfter(Duration.seconds(5))
                .text("Uw bent vergeten uw medicatie in te nemen!")
                .show();

    }

}