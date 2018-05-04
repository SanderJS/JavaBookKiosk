import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LiteratureTest {

    Book testBook;

    @Before
    public void setUp() throws Exception {
        testBook = new Book("Henrik Ibsen", "Et dukkehejm", "Gyldendal", "4. utgave", "drama",
                "48245909", "1879", 90, 8);
    }

    @Test
    public void testGetTitle() {
        assertEquals("Et dukkehejm", testBook.getTitle());
    }

    @Test
    public void testSetReleaseDate(String date) {
        date = "1879";
        assertEquals(date, testBook.getReleaseDate() );
    }
}