/**
 * a superclass that holds different forms of text (based media)
 * Text based medias such as books, magazines, newspapers and wikis.
 * 
 * every text has a author, title, publisher and a release date.
 * 
 * @author Jan Anton og Sander Joachim
 * @version 1.0
 */
public abstract class Text {
    private String author;
    private String title;
    private String publisher;
    private String releaseDate;

    public Text () {

    }
    /**
    * constructor of the text superclass
    *
    * @param author is the author of the text
    * @param title is the title of the text
    * @param publisher is the publisher of the text
    * @param releaseDate is the release date of the text
    */
    public Text (String author, String title, String publisher, String releaseDate) {
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.releaseDate = releaseDate;
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
    * Returns the title of the Text
    *
    * @return the title of the Text
    */
    protected String getTitle() {
        return title;
    }

    protected String getReleaseDate() {
        return releaseDate;
    }

    /**
    *  Returns the publisher for the Text.
    *
    * @return the publisher of the Text.
    */
    protected String getPublisher() {
        return publisher;
    }

    /**
    * gets the author of the Text.
    *
    * @return the name of the author.
    */
    protected String getAuthor() {
        return author;
    }

    /**
     * Prints all the details of the text.
     */
     public String printDetailsAsString() {
         String returnString = "";
         return returnString;
     }
}