import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Melt ice blocks.
 */
public class Melt {

    /**
     * Melting into drops animation.
     * @param x X coordinate.
     * @param y Y coordinate.
     * @param main Game pane.
     */
    public void drops(double x, double y, Pane main) {


        Image drop = new Image("Drop.png");
        ImageView dropView = new ImageView();
        dropView.relocate(x, y + 30);
        dropView.setImage(drop);

        Image drop2 = new Image("Drop.png");
        ImageView drop2View = new ImageView();
        drop2View.relocate(x + 15, y + 44);
        drop2View.setImage(drop2);

        Image drop3 = new Image("Drop.png");
        ImageView drop3View = new ImageView();
        drop3View.relocate(x + 4, y + 60);
        drop3View.setImage(drop3);
        main.getChildren().addAll(drop2View, drop3View, dropView);

        List<ImageView> drops = new ArrayList<>();
        drops.addAll(Arrays.asList(dropView, drop2View, drop3View));

        for (ImageView ci : drops) {

            TranslateTransition tr = new TranslateTransition(Duration.millis(900), ci);
            tr.setToY(100);
            tr.play();

            FadeTransition ft = new FadeTransition(Duration.millis(900), ci);
            ft.setToValue(0.0f);
            ft.play();
        }
    }

}
