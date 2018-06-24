import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Level two brick layout.
 */
public class LevelTwo {

    private static final int ZERO = 0;

    private static final int BORDER_WIDTH = 30;

    private static final int HUNDRED = 100;

    public List<ImageView> ices = new ArrayList<>();

    public List<ImageView> addBlue() {

        int row = 4;
        int col = 4;

        //List<ImageView> ices = new ArrayList<>();
        for (int rowTimes = 0; rowTimes < row; rowTimes++) {
            for (int colTimes = 0; colTimes < col; colTimes++) {

                Image bri = new Image("Brick2.png");
                ImageView briView = new ImageView();
                briView.setImage(bri);

                briView.setX(rowTimes * (bri.getWidth() + 10) + 50);
                briView.setY((colTimes - rowTimes) * (bri.getHeight() + 10) + 50);
//
//                if (colTimes % 2 == 0) {
//                    if (rowTimes % 2 == 0) ices.add(briView);
//                   // rowTimes++;
//                } else {
//                    if (rowTimes % 2 == 1) {
//                        ices.add(briView);
//                    }
//                }
                if (briView.getY() > 20) {
                    ices.add(briView);
                }
            }
        }

//        for (int i = 0; i < 4; i++) {
//            for (int k = 0; k < 4; k++) {
//                Image bri = new Image("Brick2.png");
//                ImageView briView = new ImageView();
//                briView.setImage(bri);
//
//                briView.setX(i * (bri.getWidth() + 10) + 200);
//                briView.setY(k * (bri.getHeight() + 10) + 200);
//
//                ices.add(briView);
//            }
//        }

        for (int rowTimes = row; rowTimes > - 1; rowTimes--) {
            for (int colTimes = col; colTimes > - 1; colTimes--) {

                Image bri = new Image("Brick2.png");
                ImageView briView = new ImageView();
                briView.setImage(bri);

                briView.setX(rowTimes * (bri.getWidth() + 10)  + (700 - 400));
                briView.setY((rowTimes - colTimes) * (bri.getHeight() + 10) + 50);
//
//                if (colTimes % 2 == 0) {
//                    if (rowTimes % 2 == 0) ices.add(briView);
//                   // rowTimes++;
//                } else {
//                    if (rowTimes % 2 == 1) {
//                        ices.add(briView);
//                    }
//                }
                if (briView.getY() > 20) {
                    ices.add(briView);
                }
            }
        }
        return ices;
    }

    public List<ImageView> addStone() {

        List<ImageView> stones = new ArrayList<>();
        for (int s = 0; s < 1; s++) {
            for (int y = 0; y < 4; y++) {
                Image bri = new Image("Stone.png");
                ImageView briView = new ImageView();
                briView.setImage(bri);

                briView.setX(s * (bri.getWidth() + 10) + 100);
                briView.setY(y * (bri.getHeight() + 10) + 200);

                stones.add(briView);
            }
        }
        return stones;

    }

    public List<ImageView> addGreen() {

        List<ImageView> greens = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int k = 0; k < 4; k++) {
                Image bri = new Image("BrickGreen.png");
                ImageView briView = new ImageView();
                briView.setImage(bri);

                briView.setX(i * (bri.getWidth() + 10) + 200);
                briView.setY(k * (bri.getHeight() + 10) + 200);

                greens.add(briView);
            }
        }
        return greens;
    }

    public List<ImageView> addGreenSubstitute() {
        List<ImageView> subs = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int k = 0; k < 4; k++) {
                Image bri = new Image("Brick2.png");
                ImageView briView = new ImageView();
                briView.setImage(bri);

                briView.setX(i * (bri.getWidth() + 10) + 200);
                briView.setY(k * (bri.getHeight() + 10) + 200);

                subs.add(briView);
            }
        }
        return subs;
    }

}
