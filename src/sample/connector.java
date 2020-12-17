package sample;

import java.sql.Connection;
import java.sql.DriverManager;

public class connector {
    public Connection connectionDB;

    public Connection getConnection() {
        String user = "root";
        String password = "Papamaurice11";
        String URL = "jdbc:mysql://localhost:3306/database_dispenser?autoReconnect=true&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connectionDB = DriverManager.getConnection(URL, user, password);

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        return connectionDB;
    }
}
