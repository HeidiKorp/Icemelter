import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import javax.naming.TimeLimitExceededException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

/**
 * Created by korph on 07/06/2017.
 */
public class Pattern {

    public static void main(String[] args) {

//        //System.out.println("Yume no hito");
//        try {
//            System.out.println("Yume no hito");
//            Thread.sleep(5000);
//            System.out.println("Nanana");
////        int row = 7
//        } catch (InterruptedException e){
//            e.getCause();
//        };

        Timer he = new Timer();
        try {
            System.out.println("Lalalala");
            he.wait(3000);
            System.out.println("Mememe");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        int col = 3;
//
//
//        List<String> ices = new ArrayList<>();
//        int[][] brickMap = new int[row][col];
//        for (int i = 0; i < brickMap.length; i++) {
//            for (int k = 0; k < brickMap[0].length; k++) {
//
//                if (k % 2 == 0) {
//                    if (i % 2 == 0) ices.add("1\n");
//                    // rowTimes++;
//                } else {
//                    if (i % 2 == 1) {
//                        ices.add("0");
//                    }
//                }
//
//            }
//        }
//        System.out.println(ices);
//

//        int[][] pat = new int[row][col];
//
//        List<String> pattern = new ArrayList<>();
//
//
//        System.out.println(pat.length);
//        System.out.println(pat[0].length);
//
//        String result = "";
//
//        for (int i = 0; i < pat.length; i++) {
//            for (int k = 0; k < pat[0].length; k++) {
//
//                if (i % 2 == 0) {
//                    if (k % 2 == 0) {
//                        pattern.add("1");
//                    }
//                } else {
//
//                    pattern.add("0");
//                }
//            }
//        }
//
//        System.out.println(pattern);
    }
}
