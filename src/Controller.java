import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

/**
 * Main game controller.
 */
public class Controller {

    /**
     * Game pane.
     */
    private Pane main;

    /**
     * Width of border.
     */
    private static final double BORDER_WIDTH = 30.0;

    /**
     * Width of screen.
     */
    private static final double WIDTH = 700.0;

    /**
     * Height of screen.
     */
    private static final double HEIGHT = 600.0;

    /**
     * Paddle class init.
     */
    private Paddle pad = new Paddle();

    /**
     * Paddle object.
     */
    private ImageView paddle = pad.getPaddle();

    /**
     * Ball X starting coordinate.
     */
    private static final double BALL_X = 60.0;

    /**
     * Ball Y starting coordinate.
     */
    private static final double BALL_Y = 300.0;

    /**
     * Radius of the ball.
     */
    private static final int RAD = 5;

    /**
     * Ball X direction.
     */
    private double BALL_DIR_X = X;

    /**
     * X direction of the ball.
     */
    private static final double X = 2.89;

    /**
     * Ball's Y direction.
     */
    private static final double Y = 3.03;

    /**
     * Two hundred.
     */
    private static final int TWO_HUNDRED = 200;

    /**
     * 270.
     */
    private static final int TWO_SEVENTY = 270;

    /**
     * 140.
     */
    private static final int ONE_FORTY = 140;

    /**
     * 60.
     */
    private static final int SIXTY = 60;

    /**
     * Ball Y direction.
     */
    private double BALL_DIR_Y = Y;

    /**
     * Label when life is life is lost.
     */
    private Label dead = new Label();

    /**
     * Game scene.
     */
    private Scene scene;

    /**
     * Zero score.
     */
    private int score = ZERO;

    /**
     * Score label.
     */
    private Label scoreStr = new Label();

    /**
     * Label for when the game is won.
     */
    private Label win = new Label();

    /**
     * List of iceblocks.
     */
    private List<ImageView> bricks;

    /**
     * Create borders.
     */
    private Borders bo = new Borders();

    /**
     * Get the ball.
     */
    private Ball ba = new Ball();

    /**
     * Timeline for hopping the ball.
     */
    private Timeline loop;

    /**
     * Label for showing number of lives.
     */
    private Label life = new Label();

    /**
     * Minus 1.
     */
    private final static int MINUS_ONE = -1;

    /**
     * One.
     */
    private static final int ONE = 1;

    /**
     * Twenty.
     */
    private static final int TWENTY = 20;

    /**
     * Three.
     */
    private static final int THREE = 3;

    /**
     * Zero.
     */
    private static final int ZERO = 0;

    /**
     * Thirty.
     */
    private static final int THIRTY = 30;

    /**
     * Forty.
     */
    private static final int FORTY = 40;

    /**
     * Hundred.
     */
    private static final int HUNDRED = 100;

    /**
     * Eleven.
     */
    private static final int ELEVEN = 11;

    /**
     * Five.
     */
    private static final int FIVE = 5;

    /**
     * Three.
     */
    private int lives = THREE;

    /**
     * Class for calculating lives and scores.
     */
    private GameLogic logic = new GameLogic(score, lives);

    /**
     * Initial labels to give the player some time.
     */
    private Label ready, go;

    /**
     * Number of rows.
     */
    private static final int ROW = 7;

    /**
     * Number of columns.
     */
    private static final int COL = 3;

    /**
     * Four.
     */
    private static final int FOUR = 4;

    /**
     * Three hundred.
     */
    private static final int THREE_HUNDRED = 300;

    /**
     * Two thousand.
     */
    private static final int TWO_THOUSAND = 2000;

    /**
     * Thousand.
     */
    private static final int THOUSAND = 1000;

    /**
     * Eighteen.
     */
    private static final int EIGHTEEN = 18;

    /**
     * @param main  Game pane.
     * @param scene Game scene.
     */
    public void setMain(Pane main, Scene scene) {
        this.main = main;
        this.scene = scene;
    }


    /**
     * Set the elements that do not change after losing a life or the game.
     */
    public void setGame() {

        bo.drawBorders(main);
        main.getChildren().addAll(pad.getPaddle());
        pad.movePaddle(scene);
        dead.getStyleClass().add("label-error");

    }

    public void setLivesScoreStrZero() {
            logic.setScore(ZERO);
            scoreStr.setText("Score: " + logic.getScore());

    }

    public Label getScoreStr() {
        return scoreStr;
    }

    /**
     * Play the ball, make it move.
     */
    public void playBall() {

        ImageView ball = ba.getBall();
        loop = new Timeline(new KeyFrame(Duration.millis(ELEVEN), event -> {

            if (bricks.size() == ZERO) {

                gameOver();
                win();
                main.getChildren().add(win);

                bricks.clear();
                main.getChildren().removeAll(bricks);
                logic.setScore(ZERO);
                scoreStr.setText("Score: " + logic.getScore());

                scene.setOnKeyPressed(event1 -> {
                    if (event1.getCode().equals(KeyCode.ENTER)) {
                        drawBricks(ROW, COL);
                        logic.setLives(THREE);
                        startGame();
                        life.setText("Lives: " + Integer.toString(lives));
                    }
                });
            }

            ball.setLayoutX(ball.getLayoutX() + BALL_DIR_X);
            ball.setLayoutY(ball.getLayoutY() + BALL_DIR_Y);

            if (ball.getLayoutX() >= WIDTH - BORDER_WIDTH - FOUR * RAD || ball.getLayoutX() <= BORDER_WIDTH + RAD) {
                BALL_DIR_X *= MINUS_ONE;
            }
            if (ball.getLayoutY() <= BORDER_WIDTH + RAD) {
                BALL_DIR_Y *= MINUS_ONE;
            }
            if (ball.getBoundsInParent().intersects(paddle.getBoundsInParent())) {

                BALL_DIR_Y *= MINUS_ONE;
            }

            if (ball.getLayoutY() > HEIGHT + BORDER_WIDTH + RAD) {
                BALL_DIR_X = ZERO;
                BALL_DIR_Y = ZERO;
                logic.removeLife();
                life.setText("Lives: " + Integer.toString(logic.getLives()));


                main.getChildren().add(lifeLost());
                gameOver();
                scene.setOnKeyPressed(event1 -> {
                    if (event1.getCode().equals(KeyCode.ENTER)) {
                        main.getChildren().remove(dead);
                        startGame();
                        life.setText("Lives: " + Integer.toString(logic.getLives()));
                    }
                });
                if (logic.getLives() == ZERO) {
                    dead.setText("You lost! Score: " + Integer.toString(logic.getScore()) + "\n" + "Press ENTER to play again!");
                    logic.setScore(ZERO);
                    scoreStr.setText("Score: " + logic.getScore());

                    scene.setOnKeyPressed(event1 -> {
                        if (event1.getCode().equals(KeyCode.ENTER)) {
                            main.getChildren().removeAll(bricks);
                            bricks.clear();
                            drawBricks(ROW, COL);
                            startGame();
                            logic.setLives(THREE);
                            life.setText("Lives: " + Integer.toString(logic.getLives()));
                        }
                    });


                }
            }

        }));

        loop.setDelay(Duration.millis(TWO_THOUSAND));
        loop.setCycleCount(Timeline.INDEFINITE);
        loop.play();

        scene.setOnKeyPressed(event2 -> {
            if (event2.getCode().equals(KeyCode.SPACE)) {
                if (loop.getStatus().equals(Animation.Status.RUNNING)) {
                    loop.pause();
                } else if (loop.getStatus().equals(Animation.Status.PAUSED)) {
                    loop.play();
                }
            }

        });


    }

    /**
     * For showing that a life is lost.
     *
     * @return Label for when a life is lost.
     */
    public Label lifeLost() {
        if (logic.getLives() == 1) {
            dead.setText("You have " + logic.getLives() + " life left!" + "\n" + "Press ENTER to continue.");
        } else {
            dead.setText("You have " + logic.getLives() + " lives left!" + "\n" + "Press ENTER to continue.");
            dead.relocate(TWO_HUNDRED, TWO_SEVENTY);
        }
        return dead;
    }

    /**
     * Stop the loop and remove ball for when the life is lost.
     */
    public void gameOver() {
        loop.stop();
        main.getChildren().remove(ba.getBall());
    }

    public void readyGo() {
        ready = new Label("Ready?");
        go = new Label("Go!");
        ready.getStyleClass().add("label-ready");
        go.getStyleClass().add("label-ready");
        ready.relocate(THREE_HUNDRED, THREE_HUNDRED);
        go.relocate(THREE_HUNDRED, THREE_HUNDRED);


        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(THOUSAND), ready);
        scaleTransition.setToX(FIVE);
        scaleTransition.setToY(FIVE);

        ScaleTransition scaleTransition1 = new ScaleTransition(Duration.millis(THOUSAND), go);
        scaleTransition1.setToY(FIVE);
        scaleTransition1.setToX(FIVE);
        scaleTransition1.setDelay(Duration.millis(THOUSAND + TWO_HUNDRED));


        main.getChildren().add(ready);
        scaleTransition.play();
        scaleTransition.setOnFinished(event -> {
            main.getChildren().remove(ready);
            main.getChildren().add(go);
        });

        scaleTransition1.play();
        scaleTransition1.setOnFinished(event -> {
            main.getChildren().remove(go);
        });
    }

    /**
     * Reset game, give initial values.
     */
    public void startGame() {
        readyGo();

        if (main.getChildren().contains(win) || main.getChildren().contains(dead)) {
            main.getChildren().removeAll(win, dead);
        }
        ba.drawBall();
        main.getChildren().add(ba.getBall());
        ba.getBall().relocate(BALL_X, BALL_Y);
        BALL_DIR_X = X;
        BALL_DIR_Y = Y;

        playBall();
        removeBrick();
    }

    /**
     * Set score to zero, give initial value.
     */
    public void setScoreZero() {
        score = ZERO;
    }

    /**
     * Give lives initial value.
     */
    public void setLivesThree() {
        lives = THREE;
    }

    /**
     * Draw bricks.
     * @param row row.
     * @param col column
     */
    public void drawBricks(int row, int col) {

        bricks = new ArrayList<>();
        int[][] brickMap = new int[row][col];
        for (int rowTimes = ZERO; rowTimes < brickMap.length; rowTimes++) {
            for (int colTimes = ZERO; colTimes < brickMap[ZERO].length; colTimes++) {

                Image bri = new Image("Brick2.png");
                ImageView briView = new ImageView();
                briView.setImage(bri);

                briView.setX(rowTimes * (bri.getWidth() + BORDER_WIDTH) + HUNDRED);
                briView.setY(colTimes * (bri.getHeight() + BORDER_WIDTH) + HUNDRED);
                bricks.add(briView);


            }
        }
        main.getChildren().addAll(bricks);
    }

    /**
     * Remove bricks when collides with ball.
     */
    public void removeBrick() {

        final Timeline hit = new Timeline(new KeyFrame(Duration.millis(EIGHTEEN), new EventHandler<ActionEvent>() {

            @Override
            public void handle(final ActionEvent t) {

                try {
                    for (ImageView re : bricks) {
                        if (ba.getBall().getBoundsInParent().intersects(re.getBoundsInParent())) {

                            BALL_DIR_X = -BALL_DIR_X;
                            BALL_DIR_Y = -BALL_DIR_Y;

                            Melt me = new Melt();
                            me.drops(ba.getBall().getLayoutX(), ba.getBall().getLayoutY(), main);

                            logic.addScore();

                            scoreStr.setText("Score: " + Integer.toString(logic.getScore()));
                            main.getChildren().remove(re);
                            bricks.remove(re);
                        }
                    }
                } catch (ConcurrentModificationException e) {
                    e.getCause();
                }
            }


        }));


        hit.setCycleCount(Timeline.INDEFINITE);
        hit.play();
    }

    /**
     * Label for winning.
     * @return Label for when the game is won.
     */
    public Label win() {
        win.setText("You won! Score: " + logic.getScore() + "\n" + "Press ENTER to play again.");
        win.setTextFill(Color.CRIMSON);
        win.relocate(TWO_HUNDRED, TWO_SEVENTY);
        win.setFont(Font.font("Tahoma", FontWeight.BOLD, THIRTY));

        return win;
    }

    /**
     * Make the label for showing score.
     */
    public void showScore() {

        scoreStr.setText("Score: " + Integer.toString(logic.getScore()));
        scoreStr.setFont(Font.font("Tahoma", FontWeight.BOLD, TWENTY));
        scoreStr.setTextFill(Color.BLACK);
        scoreStr.setLayoutY(HEIGHT - SIXTY);
        scoreStr.setLayoutX(ONE_FORTY);

        life.setText("Lives: " + Integer.toString(lives));
        life.setFont(Font.font("Tahoma", FontWeight.BOLD, TWENTY));
        life.setTextFill(Color.BLACK);
        life.setLayoutY(HEIGHT - SIXTY);
        life.setLayoutX(FORTY);

        main.getChildren().addAll(life, scoreStr);
    }

}
