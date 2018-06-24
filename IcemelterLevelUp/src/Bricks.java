import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

/**
 * Bricks.
 */
public class Bricks {

    private static final double BORDER_WIDTH = 30.0;

    /**
     * Draw bricks.
     * @param row row.
     * @param col column
     */
    public void drawBricks(int row, int col, List bricks, Pane main) {


        bricks = new ArrayList<>();
        int[][] brickMap = new int[row][col];
        for (int rowTimes = 0; rowTimes < brickMap.length; rowTimes++) {
            for (int colTimes = 0; colTimes < brickMap[0].length; colTimes++) {

                Image bri = new Image("Brick2.png");
                ImageView briView = new ImageView();
                briView.setImage(bri);

                briView.setX(rowTimes * (bri.getWidth() + BORDER_WIDTH) + 100);
                briView.setY(colTimes * (bri.getHeight() + BORDER_WIDTH) + 100);
                bricks.add(briView);


            }
        }
        main.getChildren().addAll(bricks);
    }
}
