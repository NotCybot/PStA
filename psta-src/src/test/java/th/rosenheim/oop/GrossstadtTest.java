package th.rosenheim.oop;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GrossstadtTest {

    private static Grossstadt münchen;

    @BeforeAll
    public static void setUp() {
        münchen = new Grossstadt("München", Wetter.REGNERISCH, List.of("Schwabing", "Sendlingen", "Lehel", "Nympenburg"));
    }
    @Test
    public void testgetContent () {
        String expectedContent = "<p>In München ist es regnerisch.</p>"+
                "<p>Dies trifft auch für Schwabing, Sendlingen, Lehel und Nympenburg zu.</p>";

        assertEquals(expectedContent, münchen.getContent());
    }
    @Test
    public void testgetURLPrefix() {
        String expectedURLPrefix = "wetter_grossstadt_";
        assertEquals(expectedURLPrefix, münchen.getURLPrefix());
    }

    @Test
    public void test() {

        String expectedURL = "wetter_grossstadt_muenchen.html";
        assertEquals(expectedURL, münchen.getURL());
    }

}
