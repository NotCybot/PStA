package th.rosenheim.oop;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class tests the Grossstadt class.
 */

public class GrossstadtTest {

    /**
     * Declare the Grossstadt object
     */

    private static Grossstadt münchen;

    /**
     * Set up the Grossstadt object before running all the tests
     */

    @BeforeAll
    public static void setUp() {
        münchen = new Grossstadt("München", Wetter.REGNERISCH, List.of("Schwabing", "Sendlingen", "Lehel", "Nympenburg"));
    }

    /**
     * Test the getContent method
     */

    @Test
    public void testgetContent () {
        String expectedContent = "<p>In München ist es regnerisch.</p>"+
                "<p>Dies trifft auch für Schwabing, Sendlingen, Lehel und Nympenburg zu.</p>";

        assertEquals(expectedContent, münchen.getContent());
    }

    /**
     * Test the getURLPrefix method
     */

    @Test
    public void testgetURLPrefix() {
        String expectedURLPrefix = "wetter_grossstadt_";
        assertEquals(expectedURLPrefix, münchen.getURLPrefix());
    }

    /**
     * Test the getURL method
     */

    @Test
    public void test() {

        String expectedURL = "wetter_grossstadt_muenchen.html";
        assertEquals(expectedURL, münchen.getURL());
    }

}
