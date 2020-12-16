package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("App.fxml"));
        primaryStage.setTitle("Dispensio");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();

    }


   /* public static void main(String[] args) {
        launch(args);


        String url = "jdbc:mysql://localhost:3306/database_dispenser?autoReconnect=true&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String user = "root";
        String password = "Papamaurce11";

        try {
            Connection connection = DriverManager.getConnection(url,user,password);
            Statement statement = connection.createStatement();
            String sql = "select * from database_dispenser.klant";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                System.out.println(resultSet.getString("Achternaam"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    } */
}
