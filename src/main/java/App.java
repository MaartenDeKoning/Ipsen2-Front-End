import javafx.application.Application;
import javafx.stage.Stage;
import manager.CurrentScene;
import manager.SceneManager;
import utilities.Configuration;

public class App extends Application {
    private Configuration config = new Configuration();
    private static SceneManager sceneManager = new SceneManager();

    @Override
    public void start(Stage primaryStage) throws Exception {
        sceneManager
                .setMainStage(primaryStage)
                .setCurrentScene(new CurrentScene(
                        config.APPLICATION_NAME,
                        "app",
                        config.SCREEN_WIDTH,
                        config.SCREEN_HEIGHT
                ))
                .show();
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();

        sceneManager.setCurrentScene(new CurrentScene(config.APPLICATION_NAME,"homeview"));
    }

    public static void main(String[] args) {
        System.out.println("Starting Matchmaking");
        launch(args);
    }
}
