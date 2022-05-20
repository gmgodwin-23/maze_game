import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import java.awt.Label;

public class obstacleGame extends Application {
    public void obstacleGame() {}

    Group root = new Group();
    Stage stage = new Stage();
    Scene mainScene = new Scene(root,400,400);

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(mainScene);
        stage.show();
    }

}
