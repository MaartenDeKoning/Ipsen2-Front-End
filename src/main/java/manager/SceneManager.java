package manager;

import javafx.stage.Stage;

/**
 * This class handles all scene changes
 *
 * @author Mazeyar Razaei, Jona Meijer, Jesse Minneboo
 * @version 1.1
 * @since june2019
 */

public class SceneManager {
    private String mainStageTitle;
    private Stage mainStage;
    private CurrentScene currentScene;

    public void show() {
        this.getMainStage().show();
    }

    public void hide() {
        this.getMainStage().hide();
    }

    public String getMainStageTitle() {
        return mainStageTitle;
    }

    public SceneManager setMainStageTitle(String mainStageTitle) {
        this.mainStageTitle = mainStageTitle;

        return this;
    }

    public Stage getMainStage() {
        return mainStage;
    }

    public SceneManager setMainStage(Stage mainStage) {
        this.mainStage = mainStage;

        return this;
    }

    public CurrentScene getCurrentScene() {
        return currentScene;
    }

    public SceneManager setCurrentScene(CurrentScene currentScene) {
        this.currentScene = currentScene;
        this.mainStage.setScene(
                this.getCurrentScene()
                        .getScene()
        );
        return this;
    }
}
