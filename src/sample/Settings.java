package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Settings extends Application {

    @Override
    public void start(Stage Stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Settings.fxml"));
        Stage.initStyle(StageStyle.TRANSPARENT);

        Scene scene = new Scene(root);
        Stage.setTitle("Dispensio");
        scene.setFill(Color.TRANSPARENT);
        Stage.setScene(scene);
        Stage.show();

    }
}
