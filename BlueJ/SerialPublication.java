/**
 *
 */
public class SerialPublication extends Literature {

    /**
     *
     * @param title the publications title
     * @param publisher the publications publisher
     * @param releaseDate the release date
     * @param pages the number of pages in the literature
     * @param price the price of the literature
     */
    public SerialPublication(String title, String publisher, String releaseDate, int pages, int price) {
        super(title, publisher, releaseDate, price, pages);
    }
}
