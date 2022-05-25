import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.*;
import java.awt.Label;
import java.awt.event.KeyEvent;

public class obstacleGame extends Application {

    public void obstacleGame(int n) {
        this.n = n;
    }

    private int n;
    Group root = new Group();
    Stage stage = new Stage();
    Scene mainScene = new Scene(root,400,400);
    Image croissant = new Image("file:img/croissant.jpeg");
    ImageView croissantView = new ImageView(croissant);

    @Override
    public void start(Stage stage) throws Exception {
        root.getChildren().add(croissantView);
        stage.setScene(mainScene);

        stage.show();
    }

    public void keyTyped(KeyEvent evt) {
        int types = 0;
        while (types < n) {
            if (evt.getKeyChar() == 'n') {
                ++types;
            }
        }
        stage.hide();
    }

}
