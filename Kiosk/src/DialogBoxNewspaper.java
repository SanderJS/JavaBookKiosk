
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

/**
 * Write a description of class DialogBoxes here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DialogBoxNewspaper extends Dialog<Newspaper>
{
    // instance variables - replace the example below with your own
    public enum Mode
    {
        NEW, EDIT, INFOR
    }
    
    private Mode mode;
    
    /**
     * Holds a instance of Newspaper, might be editable
     */
    private Newspaper exisitingNewspaper = null;
    
    /**
     * creates an instance of dialogBox to get information from the
     * user. The information fills the parameters for a newspaper
     */
    public DialogBoxNewspaper()
    {
        super();
        this.mode = Mode.NEW;
        creatDialogBox();
    }

    /**
     * Creates an instance of the DialogBoxNewspaper dialog.
     *
     * @param newsPaper the newspaper instance to edit
     * @param editable if set to <code>true</code>, the dialog will enable
     * editing of the fields in the dialog. if <code>false</code> the
     * information will be displayed in non-editable fields.
     */
    public NewspaperDetailsDialog(Newspaper newsPaper, boolean editable)
    {
        super();
        if (editable)
        {
            this.mode = Mode.EDIT;
        } else
        {
            this.mode = Mode.INFO;
        }
        this.existingNewspaper = newsPaper;
        createDialogBox();
    }
    
    /**
     * Create the dialog box.
     */
    private void createDialogBox()
    {
        // set the title of the window
        setTitle("Newspaper details");
        
        // set the button types
        // bruker pre-built knapper?
        getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        
        // build the form that the user will fill
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        // text field and prompt text pairs
        TextField title = new TextField();
        title.setPromptText("Title");

        TextField publisher = new TextField();
        publisher.setPromptText("Publisher");

        TextField releaseDate = new TextField();
        releaseDate.setPromptText("release date");
        
        TextField pages = new TextField();
        pages.setPromtText("pages");
        
        TextField price = new TextField();
        price.setPromtText("price");
        
        // Prevent characters (non-integers) to be added
        // bruker price og ikke numbofIssues
        
        price.textProperty().addListener(new ChangeListener<String>()
        {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                    String oldValue, String newValue)
            {
                try
                {
                    if (newValue.length() > 0)
                    {
                        Integer.parseInt(newValue);
                    }
                } catch (NumberFormatException e)
                {
                    issueNoTxt.setText(oldValue);
                }
            }
        });
        
        pages.textProperty().addListener(new ChangeListener<String>()
        {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                    String oldValue, String newValue)
            {
                try
                {
                    if (newValue.length() > 0)
                    {
                        Integer.parseInt(newValue);
                    }
                } catch (NumberFormatException e)
                {
                    issueNoTxt.setText(oldValue);
                }
            }
        });
        
        /*
        TextField totalNoOfIssues = new TextField();
        totalNoOfIssues.setPromptText("Total number of issues");
        
        // Prevent characters (non-integers) to be added
        totalNoOfIssues.textProperty().addListener(new ChangeListener<String>()
        {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                    String oldValue, String newValue)
            {
                try
                {
                    if (newValue.length() > 0)
                    {
                        Integer.parseInt(newValue);
                    }
                } catch (NumberFormatException e)
                {
                    totalNoOfIssues.setText(oldValue);
                }
            }
        });
        */
        
        
        // Fill inn data from the provided Newspaper, if not null.
        if ((mode == Mode.EDIT) || (mode == Mode.INFO))
        {
            title.setText(existingNewspaper.getTitle());
            publisher.setText(existingNewspaper.getPublisher());
            // Get issuenumb er en func i newspaper
            releaseDate.setText(existingNewspaper.getReleaseDate());
            // samme med numofyearlyissues
            price.setText(Integer.toString(existingNewspaper.getPrice()));
            // vår pages param
            pages.setText(Integer.toString(existingNewspaper.getPages()));
            // Set to non-editable if Mode.INFO
            if (mode == Mode.INFO)
            {
                title.setEditable(false);
                publisher.setEditable(false);
                releaseDate.setEditable(false);
                price.setEditable(false);
                pages.setEditable(false);
            }

        }

        // what goes where in the grid
        grid.add(new Label("Title:"), 0, 0);
        grid.add(title, 1, 0);
        grid.add(new Label("Publisher:"), 0, 1);
        grid.add(publisher, 1, 1);
        grid.add(new Label("Release date"), 0, 2);
        grid.add(releaseDate, 1, 2);
        grid.add(new Label("Pages"), 0, 3);
        grid.add(page, 1, 3);
        grid.add(newLabel("Price"), 0, 4);
        grid.add(price, 1, 4);

        getDialogPane().setContent(grid);

        // Convert the result to Newspaper-instance when the OK button is clicked.
        setResultConverter( new Callback<ButtonType, Newspaper>()
        {
            @Override
            public Newspaper call(ButtonType button
            )
            {
                if (button == ButtonType.OK)
                {
                    int issueNo = Integer.parseInt(issueNoTxt.getText());
                    int totalIssues = Integer.parseInt(totalNoOfIssues.getText());
                    Newspaper result = null;
                    if (mode == Mode.NEW)
                    {
                        result = new Newspaper(title.getText(), publisher.getText(), releaseDate.getText(), price.getInt(), pages.getInt());
                    } else if (mode == Mode.EDIT)
                    {
                        existingNewspaper.setTitle(title.getText());
                        existingNewspaper.setPublisher(publisher.getText());
                        existingNewspaper.setReleaseDate.getText();
                        existingNewspaper.setInt();
                        existingNewspaper.setInt();
                        result = existingNewspaper;
                    }
                    return result;
                }
                return null;
            }
        }
        );
    }
}
