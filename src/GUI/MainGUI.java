package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainGUI extends Application{
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
        Scene scene = new Scene(loader.load(), 770, 570);
        stage.setTitle("Polygon Drawer");
        stage.setScene(scene);
        stage.show();
    }
}