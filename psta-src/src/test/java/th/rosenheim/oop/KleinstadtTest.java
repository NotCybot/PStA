package th.rosenheim.oop;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class KleinstadtTest {

    private static Kleinstadt rosenheim;

    @BeforeAll
    public static void setUp() {
        rosenheim = new Kleinstadt("Rosenheim", Wetter.SONNIG);
    }
    @Test
    public void testgetContent() {
        String expectedContent = "<p>In Rosenheim ist es sonnig.</p>";

        assertEquals(expectedContent, rosenheim.getContent());
    }
    @Test
    public void testgetURLPrefix() {
        String expectedURLPrefix = "wetter_kleinstadt_";

        assertEquals(expectedURLPrefix, rosenheim.getURLPrefix());
    }
    @Test
    public void testgetURL() {
        String expectedURL = "wetter_kleinstadt_rosenheim.html";

        assertEquals(expectedURL, rosenheim.getURL());
    }
}
