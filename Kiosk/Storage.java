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
    private ArrayList<Book> listOfBooks;

    /**
     * Initiates the list of all the books.
     * 
     */
    public Storage()
    {
        this.listOfBooks = new ArrayList<Book>();
    }

    /**
     * Add an already excisting book to the list.
     * 
     * @param book is the name of the object that hold the book.
     */
    public void addBook(Book book)
    {
        this.listOfBooks.add(book);
    }
    
    /**
     * Adds a new book object and adds it to the list.
     * 
     * @param bookAuthor author of the book.
     * @param bookTitle title of the book.
     * @param bookPublisher the publisher of the book.
     * @param bookEdition the edition of the book.
     * @param bookPages total pages in the book.
     * @param bookPrice the price of the book in NOK.
     * @param bookGenre the genre of the book.
     * @param bookReleaseDate the release date of the book.
     * @param isBookASeries denotes if the book is part of a series or not.
     */
    public void addNewBook(String bookAuthor, String bookTitle, String bookPublisher, 
    String bookEdition, String bookGenre, String bookReleaseDate, 
    int bookPages, int bookPrice, boolean isBookASeries)
    {
        listOfBooks.add( new Book(bookAuthor, bookTitle, bookPublisher, 
            bookEdition, bookGenre, bookReleaseDate, 
            bookPages, bookPrice, isBookASeries));
    }
    
    /**
     * Removes a book from the list based on its position in the list.
     * 
     * @param index is the position in the list.
     */
    public void removeBookFromList(int index)
    {
        listOfBooks.remove(index);
    }
    
    /**
     * Removes the selected book from the list.
     * 
     * @param book is the name of the book that you search for to delete.
    
    public void removeFromListByName(Book book)
    {
        if (this.listOfBooks.equals(book))
            listOfBooks.remove(book);
        else
            System.out.println("The book does not exist!");
    }
    */
   
    /**
     * gets a book with the same author name as the input.
     * 
     * @param author is the name of the author.
     * @return foundBook is the return with same author.
     */
    public Book getBookByAuthor(String author)
    {
        Book foundBook = null;
        for (Book b : this.listOfBooks)
        {
            if (b.getAuthor().equals(author))
            {
                foundBook = b;
            }
        }
        return foundBook;
    }
}
