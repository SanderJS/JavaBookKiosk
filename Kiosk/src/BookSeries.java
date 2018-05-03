/**
 *
 */
public class BookSeries extends AbnormalPublication {
    private String seriesName;
    private String edition;
    private String refNumber;
    private String genre;

    public BookSeries(String author, String title, String publisher, String edition, String genre,
                      String refNumber, String releaseDate, int pages, int price, String seriesName) {
        super(author, title, publisher, releaseDate, pages, price);
        this.seriesName = seriesName;
        this.edition = edition;
        this.refNumber = refNumber;
        this.genre = genre;
    }

    /**
     * Prints all the details of the book.
     */
    public String printDetailsAsString() {
        String returnString = "";
        returnString += "################################################\n";
        returnString += "Title: " + super.getTitle() + ", Author: " + super.getAuthor() + "\n";
        returnString += "Genre: " + genre + ", Pages: " + super.getPages() + "\n";
        returnString += "Price: " + super.getPrice() + " USD" + "\n";
        returnString += "Release date: " + super.getReleaseDate() + "\n";
        returnString += "Publisher: " + super.getPublisher() + "\n";
        if (refNumber.equals("")) {
            returnString += "Reference number not set" + "\n";
        } else {
            returnString += "ISBN: " + refNumber + "\n";
        }
        returnString += "Series: " + seriesName + "\n";
        return returnString;
    }
}
