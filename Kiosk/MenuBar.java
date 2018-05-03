import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

public class MenuBar {
    private javafx.scene.control.MenuBar menuBar;

    public MenuBar() {
    }

    public void createMenus() {
        //MenuBar menuBar = new menuBar();

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
