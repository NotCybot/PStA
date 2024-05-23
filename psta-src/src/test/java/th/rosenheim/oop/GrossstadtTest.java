package th.rosenheim.oop;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GrossstadtTest {

    @Test
    public void testGrossstadt() {
        Grossstadt München = new Grossstadt("München", Wetter.REGNERISCH, List.of("Schwabing", "Sendlingen", "Lehel", "Nympenburg"));


        String expectedContent = "<p>In München ist es regnerisch.<p>"+
                "<p>Dies trifft auch für Schwabing, Sendlingen, Lehel und Nympenburg zu.</p>";
        assertEquals(expectedContent, München.getContent());

        String expectedURLPrefix = "wetter_grossstadt_";
        assertEquals(expectedURLPrefix, München.getURLPrefix());

        String expectedURL = "wetter_grossstadt_muenchen.html";
        assertEquals(expectedURL, München.getURL());
    }

}
