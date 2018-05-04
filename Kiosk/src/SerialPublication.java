/**
 *
 */
public class SerialPublication extends Literature {
    private int pages;
    private int price;

    /**
     *
     * @param title the publications title
     * @param publisher the publications publisher
     * @param releaseDate the release date
     * @param pages the number of pages in the literature
     * @param price the price of the literature
     */
    public SerialPublication(String title, String publisher, String releaseDate, int pages, int price) {
        super(title, publisher, releaseDate);
        this.pages = pages;
        this.price = price;
    }

    /**
     * returns the pages of the publication
     *
     * @return
     */
    protected int getPages() {
        return pages;
    }

    /**
     * returns the price of the publication
     *
     * @return
     */
    protected int getPrice() {
        return price;
    }

    /**
     * Sets the number of pages in the publication.
     *
     * @param pages the number of pages
     */
    public void setPages(int pages) {
        this.pages = pages;
    }

    /**
     * Sets the price of the publication.
     *
     * @param price the price of the publication
     */
    public void setPrice(int price) {
        this.price = price;
    }
}
