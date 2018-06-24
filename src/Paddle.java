import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

/**
 * Paddle class.
 */
public class Paddle {

    /**
     * Paddle width.
     */
    private double paddleWidth = 100.0;

    /**
     * Paddle.
     */
    private ImageView paddle = new ImageView();

    /**
     * Border width.
     */
    private static final double BORDER_WIDTH = 30.0;

    /**
     * Width of the screen.
     */
    private static final double WIDTH = 700.0;

    /**
     * Fifty.
     */
    private static final int FIFTY = 50;

    /**
     * Rotation degree.
     */
    private static final int ROTATE = 15;

    /**
     * Hundred.
     */
    private static final int HUNDRED = 100;


    /**
     * Move the paddle along with the mouse.
     * @param scene Game scene.
     */
    public void movePaddle(Scene scene) {

        Image pa = new Image("Paddle3.png");

        paddle.setImage(pa);
        paddle.relocate(200, 500);

        EventHandler<MouseEvent> mouseHandler = new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent mouseEvent) {


                double newX = mouseEvent.getSceneX() - FIFTY;

                if (newX > paddle.getLayoutX()) {
                    RotateTransition rotateTransition =
                            new RotateTransition(Duration.millis(HUNDRED), paddle);
                    rotateTransition.setToAngle(ROTATE);


                    ParallelTransition parallelTransition = new ParallelTransition();
                    parallelTransition.getChildren().addAll(rotateTransition);
                    parallelTransition.play();

                } else if (newX < paddle.getLayoutX()) {
                    RotateTransition rotateTransition =
                            new RotateTransition(Duration.millis(HUNDRED), paddle);
                    rotateTransition.setToAngle(-ROTATE);

                    ParallelTransition parallelTransition = new ParallelTransition();
                    parallelTransition.getChildren().addAll(rotateTransition);
                    parallelTransition.play();

                }

                paddle.setLayoutX(newX);
                if (paddle.getLayoutX() <= BORDER_WIDTH) {
                    paddle.setLayoutX(BORDER_WIDTH);
                }
                if (paddle.getLayoutX() >= WIDTH - paddleWidth - BORDER_WIDTH) {

                    paddle.setLayoutX(WIDTH - paddleWidth - BORDER_WIDTH);
                }
            }
        };
        scene.setOnMouseMoved(mouseHandler);
    }

    /**
     * Return paddle object.
     * @return paddle object.
     */
    public ImageView getPaddle() {
        return paddle;
    }

}
