package th.rosenheim.oop;


import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains tests for the WebseitenGenerator class.
 */

public class AppTest {

    /**
     * This test checks the main functionality of the WebseitenGenerator class.
     *
     * @throws IOException If an I/O error occurs while reading the generated files.
     */

    @Test
    public void testApp() throws IOException {
        WebseitenGenerator webseitenGenerator = new WebseitenGenerator();


        Grossstadt München = new Grossstadt("München", Wetter.REGNERISCH, List.of("Schwabing", "Sendlingen", "Lehel", "Nympenburg"));
        Kleinstadt Rosenheim = new Kleinstadt("Rosenheim", Wetter.BEWOELKT);
        Grossstadt Köln = new Grossstadt("Köln", Wetter.SONNIG, List.of("Ehrenfeld", "Raderthal", "Nippes", "Poll", "Esch", "Pesch", "Kalk"));


        webseitenGenerator.addStadt(München);
        webseitenGenerator.addStadt(Rosenheim);
        webseitenGenerator.addStadt(Köln);

        webseitenGenerator.generateWebsites();

        String index = Files.readString(new File("./output/index.html").toPath());
        assertTrue(index.contains("<a href=\"wetter_grossstadt_muenchen.html\">München</a>"));
        assertTrue(index.contains("<a href=\"wetter_kleinstadt_rosenheim.html\">Rosenheim</a>"));
        assertTrue(index.contains("<a href=\"wetter_grossstadt_koeln.html\">Köln</a>"));


        String münchen = Files.readString(new File("./output/wetter_grossstadt_muenchen.html").toPath());
        assertTrue(münchen.contains("<p>In München ist es regnerisch.<p>"));


        String rosenheim = Files.readString(new File("./output/wetter_kleinstadt_rosenheim.html").toPath());
        assertTrue(rosenheim.contains("<p>In Rosenheim ist es bewoelkt.</p>"));


        }
    }
