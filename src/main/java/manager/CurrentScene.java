package manager;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;
import java.util.Objects;

/**
 * Current scene class defines a scene for the scene handler
 * <p>
 * Also gets the scene in resources files
 *
 * @author Mazeyar Rezaei, Jona Meijer, Jesse Minneboo
 * @version 1.1
 * @since june2019
 */

public class CurrentScene {
    private String title;
    private Scene scene;
    private boolean isValid;

    public CurrentScene(String title, String resourceFile, int scrWidth, int scrHeight) {
        this.title = title;
        Parent root;
        try {
            root = FXMLLoader.load((Objects.requireNonNull(getClass().getClassLoader().getResource(resourceFile + ".fxml"))));
            root.requestFocus();
            this.setScene(new Scene(root, scrWidth, scrHeight));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public CurrentScene(String title, String resourceFile) {
        this.title = title;
        Parent root;
        try {
            root = FXMLLoader.load((Objects.requireNonNull(getClass().getClassLoader().getResource(resourceFile + ".fxml"))));
            root.requestFocus();
            this.setScene(new Scene(root));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private boolean validateResourceFile(String resourceFile) {
        if (resourceFile.contains(".fxml")) {
            this.setValid(false);
            System.out.println("Given resources parameter contains `.fxml`, please remove!");
            return false;
        }
        this.setValid(true);
        return true;
    }

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}
    public Scene getScene() {return scene;}
    public void setScene(Scene scene) {this.scene = scene;}
    public boolean isValid() {return isValid;}
    public void setValid(boolean valid) {this.isValid = valid;}
}
