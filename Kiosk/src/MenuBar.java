import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

public class MenuBar {
    private javafx.scene.control.MenuBar menuBar;

    public MenuBar() {
    }

    public void createMenus() {
        //MenuBar menuBar = new menuBar();

        Menu menuFile = new Menu("File");
        MenuItem openFile = new MenuItem("Open");
        MenuItem printFile = new MenuItem("Print");
        MenuItem exitApp = new MenuItem("Exit");

        Menu menuEdit = new Menu("Edit");

        Menu menuView = new Menu("View");
    }
}
