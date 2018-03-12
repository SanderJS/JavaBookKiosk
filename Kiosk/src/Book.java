
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
public class Book {
    private String author;
    private String title;
    private String publisher;
    private String edition;
    private String refNumber;
    private String series;
    private String genre;
    private String releaseDate;
    private int pages;
    private int price;
    private boolean isSeries;
    /**
     * Set the author and title fields when ths object is constructed.
     * Author and title are strings while pages is a number.
     *
     * @param bookAuthor      author of the book.
     * @param bookTitle       title of the book.
     * @param bookPublisher   the publisher of the book.
     * @param bookEdition     the edition of the book.
     * @param bookPages       total pages in the book.
     * @param bookPrice       the price of the book in NOK.
     * @param bookGenre       the genre of the book.
     * @param bookReleaseDate the release date of the book.
     * @param isBookASeries   denotes if the book is part of a series or not.
     */
    public Book(String bookAuthor, String bookTitle, String bookPublisher,
                String bookEdition, String bookGenre, String bookReleaseDate,
                int bookPages, int bookPrice, boolean isBookASeries) {
        author = bookAuthor;
        title = bookTitle;
        publisher = bookPublisher;
        edition = bookEdition;
        pages = bookPages;
        genre = bookGenre;
        releaseDate = bookReleaseDate;
        price = bookPrice;
        isSeries = isBookASeries;
        series = "";
        refNumber = "";
    }

    /**
     *
     * @param author is the author.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * converts the book to a series, when it previously wasnt
     *
     * @param isBookASeries denotes if the book is part of a series or not.
     */
    public void setBookAsSeries(boolean isBookASeries) {
        if (isSeries == false)
            isSeries = isBookASeries;
    }

    /**
     * Sets the reference number for the book.
     *
     * @param ref the books reference number.
     */
    public void setRefNumber(String ref) {
        if (ref.length() <= 3)
            System.out.println("Reference too short");
        else
            refNumber = ref;
    }

    /**
     * If the book is part of a series, it adds the series name to the book.
     *
     * @param seriesName the name of the series the book is part of.
     */
    public void setSeriesName(String seriesName) {
        if (isSeries)
            series = seriesName;
        else
            System.out.println("This book is not part of a series");
    }

    /**
     * Returns the reference number for the book.
     *
     * @return the reference number of the book.
     */
    public String getRefNumber() {
        return refNumber;
    }

    /**
     * Returns the title of the book.
     *
     * @return the title of the book.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the publisher for the book.
     *
     * @return the publisher of the book.
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * gets the author of the book.
     *
     * @return the name of the author.
     */
    public String getAuthor() {
        return author;
    }


    /**
     * Prints all the details of the book.
     */
    public String printDetailsAsString() {
        String returnString = "";
        returnString += "################################################\n";
        returnString += "Title: " + title + ", Author: " + author + "\n";
        returnString += "Genre: " + genre + ", Pages: " + pages + "\n";
        returnString += "Price: " + price + " NOK" + "\n";
        returnString += "Release date: " + releaseDate + "\n";
        returnString += "Publisher: " + publisher + "\n";
        if (isSeries) {
            if (series.equals("")) {
                returnString += "Series not yet set" + "\n";
            } else {
                returnString += "Part of: " + series + "\n";
            }
        }
        if (refNumber.equals("")) {
            returnString += "Reference number not set" + "\n";
        } else {
            returnString += "ISBN: " + refNumber + "\n";
        }
        return returnString;
    }
}