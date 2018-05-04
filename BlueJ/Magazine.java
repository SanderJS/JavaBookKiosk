import java.util.ArrayList;

/**
 * this is a magazine, a extension of text (based media)
 * a magazine contains a lot of pictures
 * a larger pool of authors than ordinary books
 * articles about different subjects.
 * 
 * @author Jan Anton, Joachim
 * @version 1.0
 */
public class Magazine extends SerialPublication {
    private String magazine;

    /**
     * Constructor for objects of subclass Magazine
     * 
     * creates and instance of a text with super
     * creates a new list for pictures
     * creates a new list of articles
     * creates a new list for authors
     */
    public Magazine(String title, String publisher, String releaseDate, int pages, int price)
    {
        // error author has private access in text!
        super(title, publisher, releaseDate, pages, price);
        // maybe
        this.magazine = "Magazine";
    }

    /**
     * returns the details of the newspaper
     *
     * @return a string with detailed newspaper information
     */
    public String printDetailsAsString() {
        String returnString = "";
        returnString += "################################################\n";
        returnString += "Title: " + super.getTitle() + "\n";
        returnString += "Release date: " + super.getReleaseDate() + "\n";
        returnString += "Pages: " + super.getPages() + " Price: " + super.getPrice() + "\n";
        returnString += "Publisher: " + super.getPublisher();
        return returnString;
    }
}