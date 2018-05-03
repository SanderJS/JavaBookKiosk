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
       super(title, publisher, releaseDate);
       this.author = author;
       this.pages = pages;
       this.price = price;
   }

    /**
     *
     * @return
     */
   public String getAuthor() {
       return author;
   }

    /**
     *
     * @return
     */
    public int getPages() {
        return pages;
    }

    /**
     *
     * @return
     */
    public int getPrice() {
        return price;
    }
}
