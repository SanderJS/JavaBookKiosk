import java.util.ArrayList;

/**
 * The list that holds the different books, papers and newspapers
 * that is in the kiosks stock.
 *
 * @author Jan Anton, Sander Joachim, Karl Kristian
 * @version 0.2
 */
public class BookStorage {
    private ArrayList<Book> listOfBooks;
    private Book book;

    /**
     * Initiates the list of all the books.
     */
    public BookStorage() {
        this.listOfBooks = new ArrayList<>();
    }

    /**
     * Creates a new, empty book and fills it.
     */
    public void addNewBook(String title, String author, String publisher, String edition, String refNumber,
                           String genre, String releaseDate, int pages, int price, boolean series, String seriesName) {
        this.book = new Book();
        this.book.setTitle(title);
        this.book.setAuthor(author);
        this.book.setPublisher(publisher);
        this.book.setEdition(edition);
        this.book.setRefNumber(refNumber);
        this.book.setGenre(genre);
        this.book.setReleaseDate(releaseDate);
        this.book.setPages(pages);
        this.book.setPrice(price);
        this.book.setSeries(series);
        if (series) {
            this.book.setSeriesName(seriesName);
        }
        addBook();
    }

    /**
     * The currently selected book to the list.
     */
    public void addBook() {
        this.listOfBooks.add(this.book);
    }

    /**
     * Removes a book from the list based on its position in the list.
     *
     * @param index is the position in the list.
     */
    public void removeBookFromList(int index) {
        listOfBooks.remove(index);
    }

    /**
     * Prints a book with the same author name as the input.
     *
     * @param author is the name of the author.
     */
    public String getBookByAuthor(String author) {
        Book foundBook = null;
        String returnString = "";
        for (Book b : this.listOfBooks) {
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
    public String getBookByPublisher(String publisher) {
        Book foundBook = null;
        String returnString = "";
        for (Book b : this.listOfBooks) {
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
    public String getBookByTitleAndPublisher(String title, String publisher) {
        Book foundBook = null;
        String returnString = "";
        for (Book b : this.listOfBooks) {
            if ((b.getTitle().equals(title)) && (b.getPublisher().equals(publisher))) {
                returnString += b.printDetailsAsString();
            }
        }
        return returnString;
    }

    /**
     * Prints all the books stored.
     */
    public String listAllBooks() {
        String returnString = "";
        for (Book b : this.listOfBooks) {
            returnString += b.printDetailsAsString();
        }
        return returnString;
    }

    public int listSize() {
        int size;
        size = listOfBooks.size();
        return size;
    }

    public void addPremadeBooks() {
        //The first of three pre made books.
        boolean series = true;
        this.book = new Book();
        this.book.setTitle("titleMan");
        this.book.setAuthor("AuthorMan");
        this.book.setPublisher("Gyldendal");
        this.book.setEdition("5.th");
        this.book.setRefNumber("1337");
        this.book.setGenre("sci-fi");
        this.book.setReleaseDate("1999");
        this.book.setPages(54);
        this.book.setPrice(45);
        this.book.setSeries(series);
        if (series) {
            this.book.setSeriesName("a book series");
        }
        addBook();
        //The second of three pre made books.
        this.book = new Book();
        this.book.setTitle("ManTitle");
        this.book.setAuthor("ManAuthor");
        this.book.setPublisher("Gyldendal");
        this.book.setEdition("9.th");
        this.book.setRefNumber("1227");
        this.book.setGenre("Low-Fi");
        this.book.setReleaseDate("1956");
        this.book.setPages(90);
        this.book.setPrice(100);
        this.book.setSeries(series = false);
        if (series) {
            this.book.setSeriesName("");
        }
        addBook();
        //The final pre made book.
        this.book = new Book();
        this.book.setTitle("Sander");
        this.book.setAuthor("Joachim");
        this.book.setPublisher("Skarmyr");
        this.book.setEdition("1st");
        this.book.setRefNumber("1997");
        this.book.setGenre("Blind");
        this.book.setReleaseDate("2001");
        this.book.setPages(100);
        this.book.setPrice(001);
        this.book.setSeries(series = true);
        if (series) {
            this.book.setSeriesName("a book series");
        }
        addBook();
    }
}