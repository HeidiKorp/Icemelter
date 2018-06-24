import javafx.application.Application;
import javafx.stage.Stage;


/**
 * Main class.
 */
public class Main extends Application {


    /**
     * Launch arguments.
     * @param args Arguments.
     */
    public static void main(String[] args) {

        launch(args);
    }

    /**
     * Start the program.
     * @param primaryStage The main stage.
     */
    @Override
    public void start(Stage primaryStage) {
        Scenes sc = new Scenes();
        sc.start(primaryStage);

    }

}
