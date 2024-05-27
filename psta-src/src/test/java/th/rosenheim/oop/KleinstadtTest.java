package th.rosenheim.oop;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class tests the KleinstadtTest class.
 */

public class KleinstadtTest {

    /**
     *  Declare the Kleinstadt object
     */

    private static Kleinstadt rosenheim;

    /**
     * Set up the Kleinstadt object before running all the tests
     */

    @BeforeAll
    public static void setUp() {
        rosenheim = new Kleinstadt("Rosenheim", Wetter.SONNIG);
    }

    /**
     * Test the getContent method
     */

    @Test
    public void testgetContent() {
        String expectedContent = "<p>In Rosenheim ist es sonnig.</p>";

        assertEquals(expectedContent, rosenheim.getContent());
    }

    /**
     * Test the getURLPrefix method
     */

    @Test
    public void testgetURLPrefix() {
        String expectedURLPrefix = "wetter_kleinstadt_";

        assertEquals(expectedURLPrefix, rosenheim.getURLPrefix());
    }

    /**
     * Test the getURL method
     */

    @Test
    public void testgetURL() {
        String expectedURL = "wetter_kleinstadt_rosenheim.html";

        assertEquals(expectedURL, rosenheim.getURL());
    }
}
