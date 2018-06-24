import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 * Rotate object.
 */
public class Rotation extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

        Pane main = new Pane();
        Scene scene = new Scene(main, 700, 700);
        primaryStage.setScene(scene);


        Rectangle re = new Rectangle(50, 50);
        re.relocate(100, 100);
        re.setFill(Color.BLACK);

        RotateTransition rotateTransition =
                new RotateTransition(Duration.millis(1000), re);
        rotateTransition.setToAngle(45);
        rotateTransition.setAutoReverse(true);
        rotateTransition.setCycleCount(2);

        rotateTransition.play();

        main.getChildren().add(re);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
