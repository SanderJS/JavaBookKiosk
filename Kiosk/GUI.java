import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.text.Text;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Font;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ToolBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.GridPane;
import javafx.scene.image.ImageView;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
// TODO(s)?
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;



public class GUI extends Application
{
    // TextArea to display text
    TextArea textArea;
    
    //TO BE ADDED
    // obsevable list to use litReg.
    // dont let book series be a subclass of books
    // remove GUI redundance
    // 

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
        Scene scene = new Scene(root, 600, 800);

        // adds the left region of the borderpane
        root.setLeft(createLeftBar());
        
        // adds the statusBar
        root.setBottom(createStatusBar());

        // adds the center list of texts region
        root.setCenter(createCentreContent());

        // title of the window
        primaryStage.setTitle("Kiosk Manager");
        // choose which scene to display
        primaryStage.setScene(scene);
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
     * this is creates a toolbar that lies under the menu
     * a toolbar contains buttons can add, print and ???
     */
    private ToolBar createToolBar()
    {
        // create an toolBar
        ToolBar toolBar = new ToolBar();
        // Buttons that the toolbar will hold
        Button openFileBtn = new Button();
        Button printBtn = new Button();
        Button saveBtn = new Button();
        Button delBtn = new Button();
        Button helpBtn = new Button();

        // assign icons to buttons here
        // icons we have are add, deletem done, exit, help, home, print and save
        // not all icons need to be used
        openFileBtn.setGraphic(new ImageView("img/add.png"));
        printBtn.setGraphic(new ImageView("img/print.png"));
        saveBtn.setGraphic(new ImageView("img/save.png"));
        delBtn.setGraphic(new ImageView("img/delete.png"));
        helpBtn.setGraphic(new ImageView("img/help.png"));
        
        // the images folder is located at at the same repo level as the .java files.
        
        // lambda expression to handle events for buttons and other actions
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
        
        
        helpBtn.setOnAction(new EventHandler<ActionEvent>()
        {

            @Override
            public void handle(ActionEvent event)
            {
                handleFileHelp();
            }
        });
        
        
        saveBtn.setOnAction(new EventHandler<ActionEvent>()
        {

            @Override
            public void handle(ActionEvent event)
            {
                handleFileSave();
            }
        });
        
        
        delBtn.setOnAction(new EventHandler<ActionEvent>()
        {

            @Override
            public void handle(ActionEvent event)
            {
                handleFileDel();
            }
        });

        // Add the Buttons to the toolBar.
        // this decides the order in which the buttons
        // wil be placed
        toolBar.getItems().addAll(openFileBtn, printBtn, saveBtn, delBtn, helpBtn);
        return toolBar;
    }

    // Creates the menu bar
    // creates menuItems (open, print and exit)
    // 
    private MenuBar createMenus()
    {
        // Creates a menubar
        MenuBar menuBar = new MenuBar();

        // creates a menu for files
        Menu menuFile = new Menu("File");
        // inside of file, these options exist
        MenuItem openFile = new MenuItem("Open");
        MenuItem printFile = new MenuItem("Print");
        MenuItem exitApp = new MenuItem("Exit");
        // add the items to their submenus
        menuFile.getItems().addAll(openFile, printFile);
        menuFile.getItems().add(new SeparatorMenuItem());
        menuFile.getItems().add(exitApp);
        

        // creates a menu for edit
        Menu menuEdit = new Menu("Edit");
        // inside edit nothing exits

        // creates a menu for view
        Menu menuView = new Menu("View");
        // inside view nothing exists (atm)

        // creates a menu for help
        Menu menuHelp = new Menu("Help");
        // inside help nothing exists
        
        // put all thes sub menus into a menubar
        menuBar.getMenus().addAll(menuFile, menuEdit, menuView);
        // return the newly created menubar
        return menuBar;
    }
    
    /**
     * issa new node for center content
     */
    private Node createCentreContent()
    {
        this.textArea = new TextArea();
        return this.textArea;
    }
    
    /**
     * issa new node for the status bar
     */
    private Node createStatusBar()
    {
        // creates a HBox and call it statusBar
        HBox statusBar = new HBox();
        // Styles the bar to make it more visable
        statusBar.setStyle("-fx-background-color: #999999;");
        // add some text to the bar
        statusBar.getChildren().add(new Text("Status: OK"));
        // return the newly created statusBar
        return statusBar;
    }
    
    
    /**
     * issa new node for buttons on the left pane
     */
    private Node createLeftBar()
    {
        // Create e VBox that will contain the buttons
        VBox leftBar = new VBox();
        // Style the bar to make it c00l
        leftBar.setStyle("-fx-background-color: #666666;");
        // make the buttons
        Button button1 = new Button();
        Button button2 = new Button();
        Button button3 = new Button();
        Button button4 = new Button();
        // label the buttons
        button1.setText("Add New Text");
        button2.setText("List All");
        button3.setText("Search");
        button4.setText("Convert To Series");
        // set padding
        button1.setPadding((new Insets(12)));
        button2.setPadding((new Insets(12)));
        button3.setPadding((new Insets(12)));
        button4.setPadding((new Insets(12)));
        // make lamda expressions to assign actions to buttons
        button1.setOnAction(new EventHandler<ActionEvent>()
        {

            @Override
            public void handle(ActionEvent event)
            {
                handleButton();
            }
        });
        
        button2.setOnAction(new EventHandler<ActionEvent>()
        {

            @Override
            public void handle(ActionEvent event)
            {
                handleButton();
            }
        });
        
        button3.setOnAction(new EventHandler<ActionEvent>()
        {

            @Override
            public void handle(ActionEvent event)
            {
                handleButton();
            }
        });
        
        button4.setOnAction(new EventHandler<ActionEvent>()
        {

            @Override
            public void handle(ActionEvent event)
            {
                handleButton();
            }
        });
        
        // place the buttons inside of the VBox
        // note that leftBar is a node
        // and therfore uses getChildren instead of getItems (?) maybe???
        leftBar.getChildren().addAll(button1, button2, button3);
        // return the newly created leftBar
        return leftBar;
    }
    
    // what does the buttons do?
    // this
    private void handleButton()
    {
        textArea.appendText("button was pressed...\n");
    }
    
    // A set of "delegate"-methods. These are methods that actually
    // deals with the stuff related to the function askd for by the
    // user as a button or a menue or a toolbar is clicked.
    private void handleFileOpen()
    {
        textArea.appendText("File Open was selected by the user...\n");
    }
    
    // Exits the application
    private void handleExit()
    {
        Platform.exit();
    }
    
    // read handleFileOpen javadoc
    private void handleFilePrint()
    {
        textArea.appendText("File Print was selected by the user...\n");
    }
    
    // Event handlers that does something
    private void handleFileSave()
    {
        textArea.appendText("File Save was selected by the user...\n");
    }
    
    // Event handlers that does something
    private void handleFileHelp()
    {
        textArea.appendText("Help was selected by the user...\n");
    }
    
    // Event handlers that does something
    private void handleFileDel()
    {
        textArea.appendText("File Delete was selected by the user...\n");
    }
}
