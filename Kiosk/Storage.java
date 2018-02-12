import java.util.ArrayList;
/**
 * The list that holds the different books, papers and newspapers 
 * that is in the kiosks stock.
 *
 * @author Jan Anton, Sander Joachim
 * @version 0.1
 */
public class Storage
{
    // instance variables - replace the example below with your own
    private ArrayList<Book> listOfBooks;

    /**
     * Constructor for objects of class ListOfStock
     */
    public Storage()
    {
        this.listOfBooks = new ArrayList<Book>();
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void addBook(Book book)
    {
        this.listOfBooks.add(book);
    }
    
    public void addNewBook(String bookAuthor, String bookTitle, String bookPublisher, 
    String bookEdition, String bookGenre, String bookReleaseDate, 
    int bookPages, int bookPrice, boolean isBookASeries)
    {
        listOfBooks.add( new Book(bookAuthor, bookTitle, bookPublisher, bookEdition, bookGenre, bookReleaseDate, bookPages, bookPrice, isBookASeries));
    }
    
    public void removeBookFromList(int index)
    {
        listOfBooks.remove(index);
    }
        
    public void removeFromListByName(Book book)
    {
        if (this.listOfBooks.equals(book))
            listOfBooks.remove(book);
        else
            System.out.println("The book does not exist!");
    }
    
    public void searchForBook(Book book)
    {
        if (this.listOfBooks.equals(book))
            System.out.println(book);
        else
            System.out.println("The book does not exist!");
    }
    
    
}
