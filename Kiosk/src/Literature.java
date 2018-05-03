/**
 * a superclass that holds different forms of literature
 * Literature based medias such as books, magazines, newspapers and wikis.
 * 
 * every literature has a title, publisher and a release date.
 * 
 * @author Jan Anton og Sander Joachim
 * @version 1.0
 */
public abstract class Literature {
    private String author;
    private String title;
    private String publisher;
    private String releaseDate;
    private String literatureType;

    public Literature() {

    }
    /**
    * constructor of the text superclass
    *
    * @param title is the title of the text
    * @param publisher is the publisher of the text
    * @param releaseDate is the release date of the text
    */
    public Literature(String title, String publisher, String releaseDate) {
        this.title = title;
        this.publisher = publisher;
        this.releaseDate = releaseDate;
    }

    /**
    * Sets the title of the Literature
    *
    * @param title is the Literature title
    */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
    * sets the publisher of the Literature
    *
    * @param publisher sets the Literature's publisher
    */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * Sets the release date of the literature.
     *
     * @param releaseDate sets the release date of the literature
     */
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
    * Returns the title of the Literature
    *
    * @return the title of the Literature
    */
    protected String getTitle() {
        return title;
    }

    /**
     *
     * @return
     */
    protected String getReleaseDate() {
        return releaseDate;
    }

    /**
    *  Returns the publisher for the Literature.
    *
    * @return the publisher of the Literature.
    */
    protected String getPublisher() {
        return publisher;
    }

    public String getAuthor() {
        return author;
    }

    /**
     * Prints all the details of the text.
     *
     * @return detailed infromation.
     */
     public String printDetailsAsString() {
         String returnString = "";
         return returnString;
     }
}