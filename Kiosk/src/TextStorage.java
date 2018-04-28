import java.util.ArrayList;

/**
 * The list that holds the different books, papers and newspapers
 * that is in the kiosks stock.
 *
 * @author Jan Anton, Sander Joachim, Karl Kristian
 * @version 0.2
 */
public class TextStorage {
    private ArrayList<Literature> listOfLiterature;
    private Literature literature;

    /**
     * Initiates the list of all the texts.
     */
    public TextStorage() {
        this.listOfLiterature = new ArrayList<>();
    }

    /**
     * The currently selected book to the list.
     * @param literature the literature
     */
    public void addText(Literature literature){
        this.listOfLiterature.add(literature);
    }

    /**
     * Removes a book from the list based on its position in the list.
     *
     * @param index is the position in the list.
     */
    public void removeTextFromList(int index) {
        listOfLiterature.remove(index);
    }

    /**
     * Prints a book with the same author name as the input.
     *
     * @param author is the name of the author.
     */
    public String getTextByAuthor(String author) {
        String returnString = "";
        for (Literature b : this.listOfLiterature) {
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
        Literature foundLiterature = null;
        String returnString = "";
        for (Literature b : this.listOfLiterature) {
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
        Literature foundLiterature = null;
        String returnString = "";
        for (Literature b : this.listOfLiterature) {
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
        for (Literature b : this.listOfLiterature) {
            returnString += b.printDetailsAsString();
        }
        return returnString;
    }

    public int listSize() {
        int size;
        size = listOfLiterature.size();
        return size;
    }

    /**
     *
     */
    public void addPremadeBooks() {
        //The first of three pre made books.
        Literature book = new BookSeries("AuthorMan", "TitleMan", "Gyldendal", "5th"
        , "sci-fi", "1234", "19-12-1999", 20, 200, "periodical");
        addText(book);
        //The second of three pre made books.
        Literature book2 = new Book("ManTitle", "ManAuthor", "Gyldendal", "9.th",
                "Low-Fi", "5678", "20-04-1920", 200, 20);
        addText(book2);
        //The final pre made book.
        Book book3 = new Book("Sander", "Joachim", "Skarmyr", "1st",
                "Dead-High", "1368", "20-01-1285", 2001, 20123);
        addText(book3);
    }
}