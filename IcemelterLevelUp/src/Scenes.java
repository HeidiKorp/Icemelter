import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.*;

/**
 * Change scenes and add their components.
 */
public class Scenes extends Application {

    /**
     * All panes used.
     */
    private Pane menuPane, instrPane;

    /**
     * Scenes used.
     */
    private Scene scene, sceneMenu, sceneInstr;

    /**
     * Stage on which the scenes are changed.
     */
    private Stage thestage;

    /**
     * Instruction text initialized to be able to read from file.
     */
    private Label instrText = new Label();

    /**
     * NotUsed.Labels as buttons and title of the game.
     */
    private Label menuInstr, menuGame, newGame, instrBut, title;

    /**
     * Width of the game screen.
     */
    private static final double WIDTH = 700;

    /**
     * Height of the screen.
     */
    private static final double HEIGHT = 600;

    /**
     * Game pane.
     */
    private Pane main = new Pane();

    /**
     * Main class where everything is playing.
     */
    private Controller elem = new Controller();

    private GameLogic logic = new GameLogic(0, 0);

    /**
     * Get the menu pane.
     */
    public void getGameMenu() {

        menuPane = new Pane();

        addGenBackground(menuPane);
        title = new Label("Icemelter");
        title.relocate(140, 100);
        title.getStyleClass().add("label-title");

        newGame = new Label("New Game");
        newGame.getStyleClass().add("label-subtitle");
        newGame.relocate(250, 290);
        newGame.setOnMouseEntered(event -> {
            newGame.setTextFill(Color.CRIMSON);
        });
        newGame.setOnMouseExited(event -> {
            newGame.setTextFill(Color.BLACK);
        });

        newGame.setOnMouseClicked(event -> {
            thestage.setScene(scene);
            setMainElements();
            //GameLogic logic = new GameLogic(0, 0);
            elem.setScoreZero();
            elem.setLivesThree();
            elem.setLivesScoreStrZero();

            //System.out.println(logic.getScore());

            main.getChildren().addAll(menuGame);

        });

        instrBut = new Label("Instruction");
        instrBut.getStyleClass().add("label-subtitle");
        instrBut.relocate(250, 400);
        instrBut.setOnMouseEntered(event -> {
            instrBut.setTextFill(Color.CRIMSON);
        });
        instrBut.setOnMouseExited(event -> {
            instrBut.setTextFill(Color.BLACK);
        });
        instrBut.setOnMouseClicked(event -> {
            thestage.setScene(sceneInstr);
        });


        menuPane.getChildren().addAll(newGame, instrBut, title);
    }

    /**
     * Get to the menu scene.
     */
    public void getBackToMenu() {

        menuGame = new Label("Menu");
        menuGame.relocate(570, 540);
        menuGame.setOnMouseEntered(event -> {
            menuGame.setTextFill(Color.CRIMSON);
        });
        menuGame.setOnMouseExited(event -> {
            menuGame.setTextFill(Color.BLACK);
        });
        System.out.println(logic.getScore());
        menuGame.setOnMouseClicked(event -> {

            main.getChildren().clear();
            thestage.setScene(sceneMenu);
            elem.gameOver();
            elem.setScoreZero();
            elem.setLivesThree();
            //elem.setLivesScoreStrZero();
        });

        sceneMenu = new Scene(menuPane, WIDTH, HEIGHT );
        sceneMenu.getStylesheets().add("Textsss.css");

    }

    /**
     * Go to the instruction view.
     */
    public void getInstructionPane() {
//        ReadInstruction read = new ReadInstruction("Instructions.txt");
//
//        String fullText = "";
//        List lines = read.getLines();
//        for (int i = 0; i < lines.size(); i++) {
//
//            fullText += lines.get(i) + "\n";
//        }
//        //instrText.setText(fullText);
        instrText.getStyleClass().add("label-instruction");

        menuInstr = new Label("Menu");
        menuInstr.relocate(560, 530);
        menuInstr.setOnMouseEntered(event -> {
            menuInstr.setTextFill(Color.CRIMSON);
        });
        menuInstr.setOnMouseExited(event -> {
            menuInstr.setTextFill(Color.BLACK);
        });
        menuInstr.setOnMouseClicked(event -> {
            thestage.setScene(sceneMenu);

        });
        instrPane = new Pane();

        addStoryBackground(instrPane);
        instrPane.getChildren().addAll(menuInstr, instrText);
        sceneInstr = new Scene(instrPane, WIDTH, HEIGHT);
        sceneInstr.getStylesheets().add("Textsss.css");
    }

    /**
     * Initialize main methods.
     */
    public void setMainElements() {
        addBackground(main);
        elem.setMain(main, scene);
        elem.drawBricks();
        elem.setGame();
        elem.showScore();
        elem.startGame();
    }

    /**
     * Get the background for menu and instruction views.
     * @param main Menu and instruction pane.
     */
    public void addGenBackground(Pane main) {
        Image back = new Image("GenBackground.png");
        ImageView backView = new ImageView();
        backView.setImage(back);
        backView.relocate(0, 0);
        main.getChildren().add(backView);
    }

    /**
     * Get the game background.
     * @param main Game pane.
     */
    public void addBackground(Pane main) {
        Image back = new Image("Background.png");
        ImageView backView = new ImageView();
        backView.setImage(back);
        backView.setFitHeight(HEIGHT);
        backView.setFitWidth(WIDTH);
        main.getChildren().add(backView);
    }

    public void addStoryBackground(Pane main) {
        Image back = new Image("StoryBackground.png");
        ImageView backView = new ImageView();
        backView.setImage(back);
        backView.setFitHeight(HEIGHT);
        backView.setFitWidth(WIDTH);
        main.getChildren().add(backView);
    }

    /**
     * For changing views.
     * @param primaryStage Main stage.
     */
    @Override
    public void start(Stage primaryStage) {

        thestage = primaryStage;
        thestage.setMaxHeight(HEIGHT + 35);
        thestage.setMaxWidth(WIDTH + 5);

        addBackground(main);
        scene = new Scene(main, WIDTH, HEIGHT);
        scene.getStylesheets().add("Textsss.css");

        getGameMenu();
        getInstructionPane();
        getBackToMenu();

        primaryStage.setTitle("Icemelter");
        primaryStage.setResizable(false);
        primaryStage.setScene(sceneMenu);
        primaryStage.show();
    }

}
