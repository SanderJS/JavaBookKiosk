
/**
 * A class that maintains information on a book.
 * It contains the name of the author, the title of the book,
 * the total pages in the book,the price,
 * the genre and the release date.
 * It also contains the ISBN reference number of the book.
 *
 * @author Jan Anton, Sander Joachim
 * @version 0.1
 */
public class Book extends AbnormalPublication {
    private String edition;
    private String refNumber;
    private String genre;
    private String book;

    /**
     * A new book filled with information
     * @param author is the author.
     * @param title is the title.
     * @param publisher is the publisher.
     * @param edition is the publishing edition.
     * @param genre is the genre.
     * @param releaseDate is the initial release date.
     */
    public Book(String author, String title, String publisher, String edition, String genre,
               String refNumber, String releaseDate, int pages, int price) {
        super(author, title, publisher, releaseDate, pages, price);
        this.edition = edition;
        this.genre = genre;
        this.refNumber = refNumber;
        this.book = "Book";
        }

    /**
     * Returns the reference number for the book.
     *
     * @return the reference number of the book.
     */
    protected String getRefNumber() {
        return refNumber;
    }

    /**
     * Returns the edition of the book.
     *
     * @return the edition.
     */
    protected String getEdition() {
        return edition;
    }

    /**
     * returns the genre
     *
     * @return the genre
     */
    protected String getGenre() {
        return genre;
    }

    /**
     * Prints all the details of the book.
     */
    public String printDetailsAsString() {
        String returnString = "";
        returnString += "################################################\n";
        returnString += "Title: " + super.getTitle() + ", Author: " + super.getAuthor() + "\n";
        returnString += "Genre: " + genre + ", Pages: " + super.getPages() + "\n";
        returnString += "Price: " + super.getPrice() + " USD" + "\n";
        returnString += "Release date: " + super.getReleaseDate() + "\n";
        returnString += "Publisher: " + super.getPublisher() + "\n";
       if (refNumber.equals("")) {
            returnString += "Reference number not set" + "\n";
        } else {
            returnString += "ISBN: " + refNumber + "\n";
        }
        return returnString;
    }
}
