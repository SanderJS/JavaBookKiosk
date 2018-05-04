//Application layer
import javafx.application.Application;
import javafx.application.Platform;
// connecting GUI and Literature
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
//Visual layer
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.text.Text;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
//Control layer
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
// TODO(s)?
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

import java.util.Optional;


public class GUI extends Application
{
    // TextArea to display text
    TextArea textArea;
    
    // WIP section
    // asdasd
    private LiteratureStorage litStorage;
    // a list of lit
    // needs to be a observable list in order to 
    // work with the tableView and Literature class
    private ObservableList<Literature> lit;
    // this is how we chose to list the literature
    private TableView<Literature> tableView;
    
    /**
     * An ObservableList used to "wrap" the real register to enable the link
     * between the TableView and the LiteratureRegister.
     */
    private ObservableList<Literature> literatures;
    
    // TO BE ADDED
    // obsevable list to use litStorage.
    // GUI functions

    // ????
    public static void main(String[] args) {
        launch(args);
    }
    
    // decides what happens when the program starts
    // right now it start by adding some premade data
    @Override
    public void init()
    {
        litStorage = new LiteratureStorage();
        this.fillRegisterWithDummyData();
    }

    // WutFace
    @Override
    public void start(Stage primaryStage) {
        // Creates a root node. 
        BorderPane root = new BorderPane();
        // Creates a container to hold all the Menu objects
        VBox topContainer = new VBox();
        // Creats our main menuto hold our sub menus
        MenuBar mainMenu = createMenus();


        // Places the topContainer in top borderpane
        root.setTop(topContainer);
        // Place th menubar in the topContainer
        topContainer.getChildren().add(mainMenu);

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



    // Creates the menu bar
    // creates menuItems (open, print and exit)
    private MenuBar createMenus()
    {
        // Creates a menubar
        MenuBar menuBar = new MenuBar();

        // creates a menu for files
        Menu menuFile = new Menu("File");
        // inside of file, these options exist
        // Open
        MenuItem openFile = new MenuItem("Open");
        // Print
        MenuItem printFile = new MenuItem("Print");
        printFile.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                
            }
        });
        // Exit
        MenuItem exitApp = new MenuItem("Exit");
        exitApp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                handleExit();
            }
        });
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
     * The centre content shows a table of literature
     * 
     * @return the node to be placed in the cneter of the BorderPane
     */
    private Node createCentreContent()
    {
        // vbox to control the sizing
        VBox vbox = new VBox();
        
        // creation of a column(s)
        // the title of each column
        TableColumn<Literature, String> titleColumn = new TableColumn<>("Title");
        // restrcts the limits of much a column can be compressed
        titleColumn.setMinWidth(200);
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        // The Publisher-column
        TableColumn<Literature, String> publisherColumn = new TableColumn<>("Publisher");
        publisherColumn.setMinWidth(200);
        publisherColumn.setCellValueFactory(new PropertyValueFactory<>("publisher"));
        
        // The release date-column
        TableColumn<Literature, String> releaseDateColumn = new TableColumn<>("Release date");
        releaseDateColumn.setMinWidth(200);
        releaseDateColumn.setCellValueFactory(new PropertyValueFactory<>("release date"));

        tableView = new TableView<>();
        tableView.setItems(this.getLiteratureList());
        tableView.getColumns().addAll(titleColumn , publisherColumn);

        vbox.getChildren().add(tableView);

        // Create the row of buttons for Add, Delete and Edit
        // remove/edit if need be
        HBox buttonRow = new HBox();
        buttonRow.setAlignment(Pos.CENTER);
        buttonRow.setPadding(new Insets(15, 15, 15, 15));
        buttonRow.setSpacing(10);

        // Add literature button
        Button addButton = new Button("New literature");
        addButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                doAddNewspaper();
            }
        }
        );

        // Delete literature button
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                doDeleteLiterature();
            }
        }
        );
        return vbox;
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
     * Returns an ObservableList holding the literatures to display.
     *
     * @return an ObservableList holding the literatures to display.
     */
    private ObservableList<Literature> getLiteratureList()
    {
        // Create an ObservableArrayList wrapping the LiteratureRegister
        literatures
                = FXCollections.observableArrayList(this.litStorage.getLiteratureList());
        return literatures;
    }
    
    /**
     * Updates the ObservableArray wrapper with the current content in the
     * Literature register. Call this method whenever changes are made to the
     * underlying LiteratureRegister.
     */
    private void updateObservableList()
    {
        this.literatures.setAll(this.litStorage.getLiteratureList());
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
        Button button5 = new Button();
        // label the buttons
        button1.setText("Add New Literature");
        button2.setText("List All");
        button3.setText("Search");
        button4.setText("Convert To Series");
        button5.setText("More Info");
        // set padding
        button1.setPadding((new Insets(12)));
        button2.setPadding((new Insets(12)));
        button3.setPadding((new Insets(12)));
        button4.setPadding((new Insets(12)));
        button5.setPadding((new Insets(12)));
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
        
        button5.setOnAction(new EventHandler<ActionEvent>()
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
    
    // dummy data
    private void fillRegisterWithDummyData()
    {
        this.litStorage.addLiterature(new Book("Henrik Ibsen", "Et dukkehejm", "Gyldendal", "4. utgave", "drama",
        "48245909", "1879", 90, 8));
        this.litStorage.addLiterature(new Magazine("some magazine", "made by a company", "released at one poin",
        25, 60));
        this.litStorage.addLiterature(new BookSeries("ya boii", "a song of boiis and boyos", "Marvel", "42.th edition",
        "real shit", "6942069", "4. may 1980", 562, 23, "cool series"));
        this.litStorage.addLiterature(new Newspaper("Ze Times", "German publishingz", "12. Jan 1995", 44, 60));
        this.litStorage.addLiterature(new Book("Oscar Wilde", "The Picture of Dorian Gray", "Pearson", "7.th edition",
        "novel", "1957991", "1890", 125, 10));
    }
    
    /**
     * Display the input dialog to get create a new Newspaper.
     */
    private void doAddNewspaper()
    {
        DialogBoxNewspaper npDialog = new DialogBoxNewspaper();

        Optional<Newspaper> result = npDialog.showAndWait();

        if (result.isPresent())
        {
            Newspaper newspaper = result.get();
            LiteratureStorage.addLiterature(new newspaper);
            updateObservableList();
            System.out.println("Number of items in litStorage: " + LiteratureStorage.getSize());
        }
    }
    
    /**
     * Deletes the literature selected in the table. If no literature is
     * selected, nothing is deleted, and the user is informed that he/she must
     * select which literature to delete.
     */
    private void doDeleteLiterature()
    {
        if (this.tableView.getSelectionModel().isEmpty())
        {
            showPleaseSelectItemDialog();
        } else
        {
            Object selectedObject = this.tableView.getSelectionModel().getSelectedItem();
            if (selectedObject instanceof Literature)
            {
                if (showDeleteConfirmationDialog())
                {
                    Literature lit = (Literature) selectedObject;
                    this.litStorage.removeByObject(lit);
                    this.updateObservableList();
                }
            }
        }
    }

    /**
     * Edit the selected item.
     */
    private void doEditLiterature()
    {
        if (this.tableView.getSelectionModel().isEmpty())
        {
            showPleaseSelectItemDialog();
        } else
        {
            Object selectedObject = this.tableView.getSelectionModel().getSelectedItem();
            if (selectedObject instanceof Literature)
            {
                Newspaper selectedNewspaper = (Newspaper) selectedObject;

                DialogBoxNewspaper npDialog = new DialogBoxNewspaper(selectedNewspaper, true);

                Optional<Newspaper> result = npDialog.showAndWait();

                updateObservableList();
            }
        }
    }

    /**
     * Show details of the selected item.
     */
    private void doShowDetails()
    {
        if (this.tableView.getSelectionModel().isEmpty())
        {
            showPleaseSelectItemDialog();
        } else
        {
            Object selectedObject = this.tableView.getSelectionModel().getSelectedItem();
            if (selectedObject instanceof Literature)
            {
                Newspaper selectedNewspaper = (Newspaper) selectedObject;

                DialogBoxNewspaper npDialog = new DialogBoxNewspaper(selectedNewspaper, false);

                Optional<Newspaper> result = npDialog.showAndWait();
            }
        }
    }

    private void showPleaseSelectItemDialog() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Information");
        alert.setHeaderText("No items selected");
        alert.setContentText("Please select an item\n to continue");

        alert.showAndWait();
    }

    private boolean showDeleteConfirmationDialog() {
        boolean deleteConfirmed = false;

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm");



        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {
            deleteConfirmed = true;
        } else {
            deleteConfirmed = false;
        }
        return deleteConfirmed;
    }
    
    // what does the buttons do?
    // this
    private void handleButton()
    {
        textArea.appendText("button was pressed...\n");
    }
    
    // A set of "delegate"-methods. These are methods that actually
    // deals with the stuff related to the function asked for by the
    // user as a button or a menu  is clicked.
    private void handleFileOpen()
    {
        textArea.appendText("File Open was selected by the user...\n");
    }
    
    // Exits the application
    private void handleExit()
    {
        Platform.exit();
    }
    
    // pls change
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
