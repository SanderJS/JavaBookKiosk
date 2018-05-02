import javafx.application.Application;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
//import javafx.geometry.Pos;
//import javafx.geometry.Insets;
// TODO
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.Node;
import javafx.scene.text.Text;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Font;
import javafx.application.Platform;

public class GUI extends Application
{
    // TextAre to display text
    // may not be needed
    TextArea textArea;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Creates a root node. 
        BorderPane root = new BorderPane();
        // Creates a container to hold all the Menu objects
        VBox topContainer = new VBox();
        // Creats our main menuto hold our sub menus
        MenuBar mainMenu = createMenus();
        // Creates a toolbar, located below the menubar
        ToolBar toolBar = createToolBar();

        // Places the topContainer in top borderpane
        root.setTop(topContainer);
        // Place th menubar in the topContainer
        topContainer.getChildren().add(mainMenu);
        // Place the Toolbar
        topContainer.getChildren().add(toolBar);

        // Creates the scene, adds the root node and starting size
        Scene scene = new Scene(root, 400, 275);

        // adds the left region of the borderpane
        // left pane
        // a hbox filled with buttons
        // coderz

        // add the created ^^ left hbox
        //root.setLeft(someVBox);

        // adds the bottom status bar
        //root.setBottom(someHBOx);

        // adds the center list of texts region
        //root.setCenter();

        // title of the window
        primaryStage.setTitle("Kiosk Manager");
        primaryStage.show();
    }

    /**
     * The stop() method is being called by the JavaFX-platform when the
     * platform stops, are being terminated. This would typically happen as a
     * result of the last open window being closed. Override this method to make
     * sure that the application is terminated.
     */
    @Override
    public void stop()
    {
        System.exit(0);
    }

    /**
     * this is how a toolbar is created
     */
    private ToolBar createToolBar()
    {
        // Buttons that the toolbar will hold
        Button openFileBtn = new Button();
        Button printBtn = new Button();

        // place icons here
        // icons we have are add, deletem done, exit, help, home, print and save
        // not all icons need to be used
        openFileBtn.setGraphic(new ImageView("img/add.png"));
        printBtn.setGraphic(new ImageView("img/print.png"));
        
        // the images folder is located at at the same repo level as the .java files.
        
        // remember eventhandlers
        openFileBtn.setOnAction(new EventHandler<ActionEvent>()
        {

            @Override
            public void handle(ActionEvent event)
            {
                handleFileOpen();
            }
        });

        printBtn.setOnAction(new EventHandler<ActionEvent>()
        {

            @Override
            public void handle(ActionEvent event)
            {
                handleFilePrint();
            }
        });        
        

        //Add the Buttons to the ToolBar.
        toolBar.getItems().addAll(openFileBtn, printBtn);
        return toolBar;
    }

    private MenuBar createMenus()
    {
        // Creates a menubar
        MenuBar menuBar = new MenuBar();

        // creates a toolbar option called "file"
        Menu menuFile = new Menu("File");
        // inside of file, these options exist
        MenuItem openFile = new MenuItem("Open");
        MenuItem printFile = new MenuItem("Print");
        MenuItem exitApp = new MenuItem("Exit");

        // creates a toolbar option called "edit"
        Menu menuEdit = new Menu("Edit");
        // inside edit nothing exits

        // creates a new toolbar option called "view"
        Menu menuView = new Menu("View");
        // inside view nothing exists (atm)

        // creates a new toolbar option called "help"
        Menu menuHelp = new Menu("Help");
        // inside help nothing exists
    }
}
