import javafx.application.Application;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // har denne et navn????
        BorderPane root = new BorderPane();

        // makes the toolbar, a type of vbox
        VBox topContainer = new VBox();
        //MenuBar mainMenu = createMenus();

        // adds the top toolbar to the borderpane
        root.setTop(mainMenu);

        // adds the left region of the borderpane
        // left pane
        // a hbox filled with buttons
        // coderz

        // add the created ^^ left hbox
        root.setLeft(newHBox);

        // adds the bottom status bar
        root.setBottom(newVBox);

        // adds the center options region
        root.setCenter(options);

        // title of the window
        primaryStage.setTitle("Kiosk Manager");
        primaryStage.show();
    }


}
