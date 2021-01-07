package sample;

import com.fazecast.jSerialComm.SerialPort;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("settings.fxml"));
        primaryStage.setTitle("Dispensio");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();

        SerialPort sp = SerialPort.getCommPort("COM7");
        sp.setComPortParameters(9600, 8, 1, 0);
        sp.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0);

        if (sp.openPort()) {
            System.out.println(("Port is Open"));
        } else {
            System.out.println("Port is not Open");
            return;
        }
        for (Integer i = 0; i < 5; ++i) {
            sp.getOutputStream().write(i.byteValue());
            sp.getOutputStream().flush();
            System.out.println("Sent number: " + i);
            Thread.sleep(1000);
        }
        if (sp.closePort()) {
            System.out.println("Port is Closed");
        } else {
            System.out.println("Port is not closed");
        }
    }
}
