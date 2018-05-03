import java.util.ArrayList;

/**
 * this is a newspaper, a extension of text (based media)
 * a newspaper contains a lot of pictures
 * a larger pool of authors than ordinary books
 * articles about different subjects.
 *
 * @author Jan Anton, Sander Joachim
 * @version 1.0
 */
public class Newspaper extends SerialPublication {
    private String newspaper;
    private ArrayList<String> pictures;
    private ArrayList<String> articles;
    private ArrayList<String> authors;
    /**
     * Constructor for objects of subclass Newspaper
     *
     * creates and instance of a text with super
     * creates a new list for pictures
     * creates a new list of articles
     * creates a new list for authors
     */
    public Newspaper(String title, String publisher, String releaseDate, int pages, int price)
    {
        // error author has private access in text!
        super(title, publisher, releaseDate, pages, price);
        this.pictures = new ArrayList<>();
        this.articles = new ArrayList<>();
        this.authors = new ArrayList<>();
        this.newspaper = "Newspaper";
    }

    /**
     * adds a picture to the magazine
     *
     * @param filename the name of the picture file
     */
    public void addPicture(String filename)
    {
        pictures.add(filename);
    }

    /**
     * adds a article to the magazine
     *
     * @param title the title of the article
     */
    public void addArticle(String title)
    {
        articles.add(title);
    }

    /**
     * Builds a string with detailed newspaper information.
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