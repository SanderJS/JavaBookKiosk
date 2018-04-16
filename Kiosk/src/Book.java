
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
public class Book  extends Text {
    private String edition;
    private String refNumber;
    private String series;
    private String genre;
    private int pages;
    private int price;
    private boolean isSeries;

    /**
     * A new book. No information has been set yet.
     */
    public Book() {
    }

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
                String releaseDate, int pages, int price, boolean series) {
        super(author, title, publisher, releaseDate);
        this.edition = edition;
        this.genre = genre;
        this.pages = pages;
        this.price = price;
        this.isSeries = series;
    }

    /**
     * Sets the author of the book.
     *
     * @param author is the author of the book
     */
    public void setAuthor(String author) {
        super.setAuthor(author);
    }

    /**
     * sets the title of the book
     * 
     * @param title the title of the book
     */
    public void setTitle(String title) {
        super.setTitle(title);
    }

    /**
     * sets the publisher of the book
     * 
     * @param publisher the publisher of the book
     */
    public void setPublisher(String publisher) {
        super.setPublisher(publisher);
    }

    /**
     * sets the edition of the book
     * 
     * @param edition the edition of the book
     */
    public void setEdition(String edition) {
        this.edition = edition;
    }

    /**
     * sets the genre of the book
     * 
     * @param genre the genre of the book
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * sets the release date of the book
     * 
     * @param releaseDate the release date of the book
     */
    public void setReleaseDate(String releaseDate) {
        super.setReleaseDate(releaseDate);
    }

    /**
     * sets the number of pages on the book
     * 
     * @param pages the number of pages in the book
     */
    public void setPages(int pages) {
        this.pages = pages;
    }

    /**
     * sets the price of the book
     * 
     * @param price the price of the book
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * is the book a series?
     * yes --> True
     * no --> False
     * 
     * @param series is the book a part of a series
     */
    public void setSeries(boolean series) {
        this.isSeries = series;
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

    public String getEdition() {
        return edition;
    }

    /**
     * Prints all the details of the book.
     */
    public String printDetailsAsString() {
        String returnString = "";
        returnString += "################################################\n";
        returnString += "Title: " + super.getTitle() + ", Author: " + super.getAuthor() + "\n";
        returnString += "Genre: " + genre + ", Pages: " + pages + "\n";
        returnString += "Price: " + price + " USD" + "\n";
        returnString += "Release date: " + super.getReleaseDate() + "\n";
        returnString += "Publisher: " + super.getPublisher() + "\n";
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
