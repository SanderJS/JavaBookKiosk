import java.util.InputMismatchException;

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
    private String title;
    private String publisher;
    private String releaseDate;
    private String literatureType;
    private int price;
    private int pages;

    public Literature() {

    }

    /**
    * constructor of the text superclass
    *
    * @param title is the title of the text
    * @param publisher is the publisher of the text
    * @param releaseDate is the release date of the text
    */
    public Literature(String title, String publisher, String releaseDate, int price, int pages) {
        this.title = title;
        this.publisher = publisher;
        this.releaseDate = releaseDate;
        this.price = price;
        this.pages = pages;
    }

    /**
    * Sets the title of the Literature
    *
    * @param title is the Literature title
    */
    public void setTitle(String title) throws InputMismatchException {
        if (title.length() == 0) {
            throw new InputMismatchException();
        } else {
            this.title = title;
        }
    }

    /**
    * sets the publisher of the Literature
    *
    * @param publisher sets the Literature's publisher
    */
    public void setPublisher(String publisher) throws InputMismatchException {
        if (publisher.length() == 0) {
            throw new InputMismatchException();
        } else {
            this.publisher = publisher;
        }
    }

    /**
     * Sets the release date of the literature.
     *
     * @param releaseDate sets the release date of the literature
     */
    public void setReleaseDate(String releaseDate) throws InputMismatchException {
        if (releaseDate.length() == 0) {
            throw new InputMismatchException();
        } else {
            this.releaseDate = releaseDate;
        }
    }

    /**
     *
     * @param price
     * @throws InputMismatchException
     */
    public void setPrice(int price) throws InputMismatchException {
            if (price <= 0) {
                throw new InputMismatchException();
            } else {
                this.price = price;
            }
    }

    /**
     *
     * @param pages
     * @throws InputMismatchException
     */
    public boolean setPages(int pages) throws InputMismatchException {
        int setPages = 1;
        boolean returnBoolean = false;

        if (pages <= 0) {
            throw new InputMismatchException();
        }

        try {
            switch (setPages) {
                case 1:
                    this.pages = pages;
                    returnBoolean = true;
                    break;
            }
        } catch (InputMismatchException ime) {
        returnBoolean = false;
        }
        return returnBoolean;
    }

    /**
    * Returns the title of the Literature
    *
    * @return the title of the Literature
    */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @return
     */
    public String getReleaseDate() {
        return releaseDate;
    }

    /**
    *  Returns the publisher for the Literature.
    *
    * @return the publisher of the Literature.
    */
    public String getPublisher() {
        return publisher;
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