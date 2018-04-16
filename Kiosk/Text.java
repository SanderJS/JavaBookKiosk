import java.util.ArrayList;

/**
 * a superclass that holds different forms of text (based media)
 * Text based medias such as books, magazines, newspapers and wikis.
 * 
 * every text has a author, title, publisher, release date, pages anda price
 * 
 * @author Jan Anton og Joachim
 * @version 1.0
 */
public class Text {
    private String author;
    private String title;
    private String publisher;
    private String releaseDate;
    private int pages;
    private int price;

/**
 * constructor of the text superclass
 * 
 * @param author is the author of the text
 * @param title is the title of the text
 * @param publisher is the publisher of the text
 * @param releasdeDate is the release date of the text
 * @param pages is the number of pages of text
 * @param price is the price of the text
 */
public Text (String author, String title, String publisher, String releaseDate,
 int pages, int price) {
    this.author = author;
    this.title = title;
    this.publisher = publisher;
    this.releaseDate = releaseDate;
    this.pages = pages;
    this.price = price;
}

/**
* Sets the author of the Text
*
* @param author is the author.
*/
public void setAuthor(String author) {
    this.author = author;
}
    
/**
* Sets the title of the Text
* 
* @param title is the Text title
*/
public void setTitle(String title) {
    this.title = title;
}

/**
* sets the publisher of the Text
* 
* @param publisher sets the Text's publisher
*/
public void setPublisher(String publisher) {
    this.publisher = publisher;
}

public void setReleaseDate(String releaseDate) {
    this.releaseDate = releaseDate;
}

/**
* sets the number of pages in the Text
*
* @param pages is the number of pages in the Text
*/
public void setPages(int pages) {
    this.pages = pages;
}

/**
* sets the proce of the Text
*
* @param price is the price of the Text
*/
public void setPrice(int price) {
    this.price = price;
}

/**
* Returns the title of the Text
*
* @return the title of the Text
*/
public String getTitle() {
    return title;
}

/**
* Returns the publisher for the Text.
*
* @return the publisher of the Text.
*/
public String getPublisher() {
    return publisher;
}

/**
* gets the author of the Text.
*
* @return the name of the author.
*/
public String getAuthor() {
    return author;
}

/**
 * gets the number of pages of the text
 * 
 * @return the number of pages
 */
public void getPages() {
    return pages
}

/**
 * gets the price of the text
 * 
 * @return the price of the text
 */
public void getPrice() {
    return price;
}

/**
     * Prints all the details of the text.
     */
    public String printDetailsAsString() {
        String returnString = "";
        returnString += "################################################\n";
        returnString += "Title: " + title + ", Author: " + author + "\n";
        returnString += Pages: " + pages + "\n";
        returnString += "Price: " + price + " USD" + "\n";
        returnString += "Release date: " + releaseDate + "\n";
        returnString += "Publisher: " + publisher + "\n";
        return returnString;
    }
}