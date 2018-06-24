import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * ball class.
 */
public class Ball {

    /**
     * Ball for melting.
     */
    private ImageView ball;

    /**
     * Draw a new ball.
     */
    public void drawBall() {

        Image ballIs = new Image("Fireball.png");
        ball = new ImageView();
        ball.setImage(ballIs);

    }

    /**
     * Get the ball.
     * @return Ball object.
     */
    public ImageView getBall() {
        return ball;
    }


}
