import java.util.ArrayList;

public class Magazine extends Text {
    prviate ArrayList<String> pictures;
    private int ArrayList<String> articles;
    private ArrayList<String> authors;

    /**
     * Constructor for objects of subclass Magazine
     * 
     * 
     */
    public Magazine()
    {
        super(author, title, publisher, releasDate, pages, price)
        this.pictures = new ArrayList<>();
        this.articles = new ArrayList<>();
        this.authors = new ArrayList<>();
    }

    public void addPicture(String filename)
    {
        pictures.add(filename);
    }

    public void addArticle(String title)
    {
        articles.add(title);
    }

    public void addAuthor(String author)
    {
        authors.add(author);
    }
}