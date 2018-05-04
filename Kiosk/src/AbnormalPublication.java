import java.util.InputMismatchException;

/**
 *
 */
public class AbnormalPublication extends Literature {
   private String author;
   private int pages;
   private int price;

    /**
     *
     * @param author
     * @param title
     * @param publisher
     * @param releaseDate
     * @param pages
     * @param price
     */
   public AbnormalPublication(String author, String title, String publisher, String releaseDate, int pages, int price) {
       super(title, publisher, releaseDate, price, pages);
       this.author = author;
   }

   /**
    * Sets the name of the author.
    *
    * @param author
    */
    public void setAuthor(String author) throws InputMismatchException {
        if (author.length() == 0) {
            throw new InputMismatchException();
        } else {
            this.author = author;
        }
    }

    /**
     *
     * @return
     */
   public String getAuthor() {
       return author;
   }
}
