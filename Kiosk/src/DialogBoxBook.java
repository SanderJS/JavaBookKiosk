
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
 * Dialog boxes for making books via GUI
 *
 * @athor (your name)
 * @version (a version number or a date
 */
public class DialogBoxBook extends Dialog<Book>
{
    // Enums to decide states
    public enum Mode
    {
        NEW, EDIT, INFO
    }

    private Mode mode;

    /**
     * Holds a instance of Book
     */
    private Book existingBook = null;

    /**
     * Creates an instance of dialogBox to get information from
     * the user. The infomration fill the parameters for a newspaper
     */
    public DialogBoxBook()
    {
        super();
        this.mode = Mode.NEW;
        createDialogBox();
    }

    /**
     * Cretes an instance of the DoalogBoxBook dialog
     *
     * @param book the instance of Book to edit
     * @param editable if set to <code>true</code>, the dialog
     * will enable editing of the fields in the dialog, if <code>false</code>
     * the information wil be displated in non-editable fields.
     */
    public DialogBoxBook (Book book, boolean editable)
    {
        super();
        if (editable)
        {
            this.mode = Mode.EDIT;
        } else {
            this.mode = Mode.INFO;
        }
        this.existingBook = book;
        createDialogBox();
    }

    /**
     * Create the dialog box
     */
    private void createDialogBox()
    {
        // Set the title of the window
        setTitle("Book details");

        // Set the button types
        getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        //Build the from that the user will fill
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20,150,10,10));

        // Text fields and prompt text pairs
        TextField author = new TextField();
        author.setPromptText("author");

        TextField title = new TextField();
        title.setPromptText("Title");

        TextField publisher = new TextField();
        publisher.setPromptText("Publisher");

        TextField edition = new TextField();
        edition.setPromptText("Edition");

        TextField genre = new TextField();
        genre.setPromptText("Genre");

        TextField refNumber = new TextField();
        refNumber.setPromptText("Ref Number");

        TextField releaseDate = new TextField();
        releaseDate.setPromptText("Release Date");

        TextField pages = new TextField();
        pages.setPromptText("Pages");

        TextField price = new TextField();
        price.setPromptText("Price");

        // Create listeners for every field

        pages.textProperty().addListener(new ChangeListener<String>() {
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
                    pages.setText(oldValue);
                }
            }
        });

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
                    price.setText(oldValue);
                }
            }
        });

        // Fill in the data from the provided Book, if not null.
        if ((mode == Mode.EDIT) || (mode ==Mode.INFO))
        {
            author.setText(existingBook.getAuthor());
            title.setText(existingBook.getTitle());
            publisher.setText(existingBook.getPublisher());
            edition.setText(existingBook.getEdition());
            genre.setText(existingBook.getEdition());
            refNumber.setText(existingBook.getRefNumber());
            releaseDate.setText(existingBook.getReleaseDate());
            pages.setText(Integer.toString(existingBook.getPages()));
            price.setText(Integer.toString(existingBook.getPrice()));
            // set to non-editable if Mode.INFO
            if (mode == Mode.INFO)
            {
                author.setEditable(false);
                title.setEditable(false);
                publisher.setEditable(false);
                edition.setEditable(false);
                genre.setEditable(false);
                refNumber.setEditable(false);
                releaseDate.setEditable(false);
                pages.setEditable(false);
                price.setEditable(false);
            }
        }

        // Setup for the grid
        grid.add(new Label("Author:"), 0, 0);
        grid.add(title, 1, 0);
        grid.add(new Label("Title:"), 0 , 1);
        grid.add(title, 2,1 );
        grid.add(new Label("Publisher:"), 0,2);
        grid.add(publisher, 3,2);
        grid.add(new Label("Edition:"), 0 ,3);
        grid.add(edition,4, 3);
        grid.add(new Label("Genre:"), 0 ,4);
        grid.add(genre,5, 4 );
        grid.add(new Label("Ref Number:"), 0, 5);
        grid.add(refNumber,6, 5);
        grid.add(new Label("Release Date:"),0 , 6);
        grid.add(releaseDate,7, 6);
        grid.add(new Label("Pages:"), 0, 7);
        grid.add(pages, 8, 7);
        grid.add(new Label("Price:"),0, 8);

        // uhh
        getDialogPane().setContent(grid);

        // Convert the result to Newspaper-instance when the OK button is clicked.
        setResultConverter(new Callback<ButtonType, Book>() {

            @Override
            public Book call(ButtonType button) {
                if (button == ButtonType.OK) {
                    int pagesNo = Integer.parseInt(pages.getText());
                    int priceInt = Integer.parseInt(price.getText());

                    Book result = null;

                    if (mode == Mode.NEW) {
                        result = new Book(author.getText(), title.getText(), publisher.getText(),
                                edition.getText(), genre.getText(), refNumber.getText(), releaseDate.getText(),
                                pagesNo, priceInt);
                        } else if (mode == Mode.EDIT) {
                        existingBook.setAuthor(author.getText());existingBook.setTitle(title.getText());
                        existingBook.setPublisher(publisher.getText());
                        existingBook.setEdition(edition.getText());existingBook.setGenre(genre.getText());existingBook.setRefNumber(refNumber.getText());
                        existingBook.setReleaseDate(releaseDate.getText());existingBook.setPages(pagesNo);existingBook.setPrice(priceInt);
                                           result = existingBook; }return result;
                                   }
                                   return null;
                }
        }
        );
    }
}