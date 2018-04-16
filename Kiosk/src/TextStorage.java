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
        this.
    }

    /**
     * Creates and fills a text as a book.
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
                           String edition, String genre, String releaseDate,
                           int pages, int price, boolean isSeries) {
    this.text = new Book(title, author, publisher, edition,
            genre, releaseDate, pages, price, isSeries);
    addText(text);
    }

    public void addNewWiki(String title, String author, String publisher,
                           String )

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
     * adds a premade book
     * use this to skip filling out author, title...
     * 
     * @
     */
    public void addPremadeBooks() {
        //The first of three pre made books.
        boolean series = true;
        Book book = new Book();
        book.setTitle("titleMan");
        book.setAuthor("AuthorMan");
        book.setPublisher("Gyldendal");
        book.setEdition("5.th");
        book.setRefNumber("1337");
        book.setGenre("sci-fi");
        book.setReleaseDate("1999");
        book.setPages(54);
        book.setPrice(45);
        book.setSeries(series);
        if (series) {
            book.setSeriesName("a book series");
        }
        addText(text);
        //The second of three pre made books.
        Book book2 = new Book();
        book2.setTitle("ManTitle");
        book2.setAuthor("ManAuthor");
        book2.setPublisher("Gyldendal");
        book2.setEdition("9.th");
        book2.setRefNumber("1227");
        book2.setGenre("Low-Fi");
        book2.setReleaseDate("1956");
        book2.setPages(90);
        book2.setPrice(100);
        book2.setSeries(series = false);
        if (series) {
            book2.setSeriesName("");
        }
        addText(text);
        //The final pre made book.
        Book book3 = new Book();
        book3.setTitle("Sander");
        book3.setAuthor("Joachim");
        book3.setPublisher("Skarmyr");
        book3.setEdition("1st");
        book3.setRefNumber("1997");
        book3.setGenre("Blind");
        book3.setReleaseDate("2001");
        book3.setPages(100);
        book3.setPrice(001);
        book3.setSeries(series = true);
        if (series) {
            book3.setSeriesName("a book series");
        }
        addText(text);
    }
}