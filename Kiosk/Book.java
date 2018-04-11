
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
public class Book extends BookStorage {
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
     * @param pages is the number of pages
     * @param price is the price in USD.
     * @param series if the book is part of a series or not.
     */
    public Book(String author, String title, String publisher, String edition, String genre,
                String releaseDate, int pages, int price, boolean series) {
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.edition = edition;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.pages = pages;
        this.price = price;
        this.isSeries = series;
    }

    /**
     * Sets the author of the book.
     *
     * @param author is the author.
     */
    public void setAuthor(String author) {
        this.author = author;
    }
    
    /**
     * Sets the title of the book
     * 
     * @param title is the book title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * sets the publisher of the book
     * 
     * @param publisher sets the book's publisher
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * sets the edition of the book
     * 
     * @param edition is the book's edition
     */
    public void setEdition(String edition) {
        this.edition = edition;
    }

    /**
     * 
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setPrice(int price) {
        this.price = price;
    }

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
        returnString += "Price: " + price + " USD" + "\n";
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
