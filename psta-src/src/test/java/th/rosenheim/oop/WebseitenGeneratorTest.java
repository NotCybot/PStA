package th.rosenheim.oop;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WebseitenGeneratorTest {

    private static WebseitenGenerator webseitenGenerator;
    private static Grossstadt münchen;
    private static Kleinstadt rosenheim;
    private static Grossstadt köln;

    @BeforeAll
    public static void setUp() throws IOException {
        webseitenGenerator = new WebseitenGenerator();

        münchen = new Grossstadt("München", Wetter.REGNERISCH, List.of("Schwabing", "Sendlingen", "Lehel", "Nympenburg"));
        rosenheim = new Kleinstadt("Rosenheim", Wetter.BEWOELKT);
        köln = new Grossstadt("Köln", Wetter.SONNIG, List.of("Ehrenfeld", "Raderthal", "Nippes", "Poll", "Esch", "Pesch", "Kalk"));

        webseitenGenerator.addStadt(münchen);
        webseitenGenerator.addStadt(rosenheim);
        webseitenGenerator.addStadt(köln);

        webseitenGenerator.generateWebsites();

    }


    @Test
    public void testaddStadt() {
        List<Stadt> staedte = webseitenGenerator.getStaedte();
        assertTrue(staedte.contains(münchen));
        assertTrue(staedte.contains(rosenheim));
        assertTrue(staedte.contains(köln));

    }

    @Test
    public void testgetNavigation() throws IOException {
        String navigation = webseitenGenerator.getNavigation();
        assertTrue(navigation.contains("München"));
        assertTrue(navigation.contains("Rosenheim"));
        assertTrue(navigation.contains("Köln"));
    }

    @Test
    public void testGeneratePage() {
        String navigation = webseitenGenerator.getNavigation();
        List<Stadt> staedte = webseitenGenerator.getStaedte();

        for (Stadt stadt : staedte) {
            String expectedHtml = "<html><body>" + navigation + stadt.getContent() + "</body></html>";
            String actualHtml = webseitenGenerator.generatePage(navigation, stadt.getContent());

            assertEquals(expectedHtml, actualHtml);
        }
        //Generate Websites should be tested in AppTest
    }
}
