import sun.swing.StringUIClientPropertyKey;

import java.util.ArrayList;

/**
 * The list that holds the different books, papers and newspapers
 * that is in the kiosks stock.
 *
 * @author Jan Anton, Sander Joachim, Karl Kristian
 * @version 0.2
 */
public class TextStorage {
    private ArrayList<Text> listOfText;
    private Text text;

    /**
     * Initiates the list of all the texts.
     */
    public TextStorage() {
        this.listOfText = new ArrayList<>();
    }

    /**
     * Creates a text as a book and adds it to the collection
     *
     * @param title
     * @param author
     * @param publisher
     * @param edition
     * @param genre
     * @param releaseDate
     * @param pages
     * @param price
     * @param isSeries
     */
    public void addNewBook(String title, String author, String publisher,
                                  String edition, String genre, String refNumber, String releaseDate,
                                  int pages, int price, boolean isSeries, String seriesName) {
        Text text = new Book(author, title, publisher, edition,
            genre, refNumber, releaseDate, pages, price, isSeries, seriesName);
        addText(text);
    }

    /**
     * Creates a new wiki and adds it to the collection
     * @param project
     * @param title
     * @param author
     * @param publisher
     * @param releaseDate
     */
    public void addNewWiki(String project, String title, String author,
                           String publisher, String releaseDate){
        Text text = new Wiki(project, author, title, publisher, releaseDate);
        addText(text);
    }

    /**
     * Adds a new magazine to the collection
     * @param author
     * @param title
     * @param publisher
     * @param releaseDate
     * @param pages
     * @param price
     */
    public void addNewMagazine(String author, String title, String publisher,
                               String releaseDate, int pages, int price){
        this.text = new Magazine(author, title, publisher, releaseDate, pages, price);
        addText(text);
    }

    /**
     * Adds a new newspaper to the collection
     *
     * @param author the author of the newspaper
     * @param title of the newspaper
     * @param publisher of the newspaper
     * @param releaseDate of the newspaper
     * @param pages of the newspaper
     * @param price of the newspaper
     */
    public void addNewNewspaper(String author, String title, String publisher,
                                String releaseDate, int pages, int price){
        this.text = new Newspaper(author, title, publisher, releaseDate, pages, price);
        addText(text);
    }

    /**
     * The currently selected book to the list.
     * @param text
     */
    public void addText(Text text){
        this.listOfText.add(text);
    }

    /**
     * Removes a book from the list based on its position in the list.
     *
     * @param index is the position in the list.
     */
    public void removeTextFromList(int index) {
        listOfText.remove(index);
    }

    /**
     * Prints a book with the same author name as the input.
     *
     * @param author is the name of the author.
     */
    public String getTextByAuthor(String author) {
        String returnString = "";
        for (Text b : this.listOfText) {
            if (b.getAuthor().equals(author)) {
                returnString +=                 b.printDetailsAsString();
            }
        }
        return returnString;
    }

    /**
     * Prints a book with the same publisher as the input.
     *
     * @param publisher is the name of the publisher.
     */
    public String getTextByPublisher(String publisher) {
        Text foundText = null;
        String returnString = "";
        for (Text b : this.listOfText) {
            if (b.getPublisher().equals(publisher)) {
                returnString += b.printDetailsAsString();
            }
        }
        return returnString;

    }

    /**
     * Prints a book with the same title and publisher as the input.
     *
     * @param title     is the name of the title.
     * @param publisher is the name of the publisher.
     */
    public String getTextByTitleAndPublisher(String title, String publisher) {
        Text foundText = null;
        String returnString = "";
        for (Text b : this.listOfText) {
            if ((b.getTitle().equals(title)) && (b.getPublisher().equals(publisher))) {
                returnString += b.printDetailsAsString();
            }
        }
        return returnString;
    }

    /**
     * Prints all the books stored.
     */
    public String listAllTexts() {
        String returnString = "";
        for (Text b : this.listOfText) {
            returnString += b.printDetailsAsString();
        }
        return returnString;
    }

    public int listSize() {
        int size;
        size = listOfText.size();
        return size;
    }

    /**
     *
     */
    public void addPremadeBooks() {
        //The first of three pre made books.
        Text book = new Book("AuthorMan", "TitleMan", "Gyldendal", "5th"
        , "sci-fi", "1234", "19-12-1999", 20, 200, true, "periodical");
        addText(book);
        //The second of three pre made books.
        Text book2 = new Book("ManTitle", "ManAuthor", "Gyldendal", "9.th",
                "Low-Fi", "5678", "20-04-1920", 200, 20, false, "nan");
        addText(book2);
        //The final pre made book.
        Book book3 = new Book("Sander", "Joachim", "Skarmyr", "1st",
                "Dead-High", "1368", "20-01-1285", 2001, 20123, true, "nan");
        addText(book3);
    }
}