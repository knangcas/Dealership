package dealer.dealerproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("splash.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        UserManagement.loadUsers();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        //test
    }

    public static void main(String[] args) {
        launch();
    }
}