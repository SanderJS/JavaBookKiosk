/**
 *
 */
public class BookSeries extends Book {
    private String seriesName;

    public BookSeries(String author, String title, String publisher, String edition, String genre,
                      String refNumber, String releaseDate, int pages, int price, String seriesName) {
        super(author, title, publisher, edition, genre, refNumber, releaseDate, pages, price);
        this.seriesName = seriesName;
    }

    /**
     * Prints all the details of the book.
     */
    public String printDetailsAsString() {
        String returnString = "";
        returnString += "################################################\n";
        returnString += "Title: " + super.getTitle() + ", Author: " + super.getAuthor() + "\n";
        returnString += "Genre: " + super.getGenre() + ", Pages: " + super.getPages() + "\n";
        returnString += "Price: " + super.getPrice() + " USD" + "\n";
        returnString += "Release date: " + super.getReleaseDate() + "\n";
        returnString += "Publisher: " + super.getPublisher() + "\n";
        if (super.getRefNumber().equals("")) {
            returnString += "Reference number not set" + "\n";
        } else {
            returnString += "ISBN: " + super.getRefNumber() + "\n";
        }
        returnString += "Series: " + seriesName + "\n";
        return returnString;
    }
}
