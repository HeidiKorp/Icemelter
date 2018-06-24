import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import java.util.ArrayList;
import java.util.List;


/**
 * Border class.
 */
public class Borders {

    /**
     * Make the borders.
     */
    public void drawBorders(Pane main) {

        Image frame = new Image("Frame.png");
        ImageView frameView = new ImageView();
        frameView.setImage(frame);
        main.getChildren().add(frameView);

    }

}
