import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by korph on 07/06/2017.
 */
public class LevelOne {

    private static final int ZERO = 0;

    private static final int BORDER_WIDTH = 30;

    private static final int HUNDRED = 100;

    public List<ImageView> addBrick(int row, int col) {
        List<ImageView> ices = new ArrayList<>();
        int[][] brickMap = new int[row][col];
        for (int rowTimes = ZERO; rowTimes < brickMap.length; rowTimes++) {
            for (int colTimes = ZERO; colTimes < brickMap[ZERO].length; colTimes++) {

                Image bri = new Image("Brick2.png");
                ImageView briView = new ImageView();
                briView.setImage(bri);

                briView.setX(rowTimes * (bri.getWidth() + BORDER_WIDTH) + HUNDRED);
                briView.setY(colTimes * (bri.getHeight() + BORDER_WIDTH) + HUNDRED);
                ices.add(briView);

            }
        }
        return ices;
    }
}
