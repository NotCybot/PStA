package th.rosenheim.oop;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
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

    @BeforeAll
    public static void setUp() throws IOException {
        WebseitenGenerator webseitenGenerator = new WebseitenGenerator();

        Grossstadt München = new Grossstadt("München", Wetter.REGNERISCH, List.of("Schwabing", "Sendlingen", "Lehel", "Nympenburg"));
        Kleinstadt Rosenheim = new Kleinstadt("Rosenheim", Wetter.BEWOELKT);
        Grossstadt Köln = new Grossstadt("Köln", Wetter.SONNIG, List.of("Ehrenfeld", "Raderthal", "Nippes", "Poll", "Esch", "Pesch", "Kalk"));


        webseitenGenerator.addStadt(München);
        webseitenGenerator.addStadt(Rosenheim);
        webseitenGenerator.addStadt(Köln);

        webseitenGenerator.generateWebsites();
    }

    @Test
    public void testindexContent() throws IOException {
        String index = Files.readString(new File("./output/index.html").toPath());
        assertTrue(index.contains("<a href=\"wetter_grossstadt_muenchen.html\">München</a>"));
        assertTrue(index.contains("<a href=\"wetter_kleinstadt_rosenheim.html\">Rosenheim</a>"));
        assertTrue(index.contains("<a href=\"wetter_grossstadt_koeln.html\">Köln</a>"));
    }

    @Test
    public void testmuenchenContent() throws IOException {
        String münchen = Files.readString(new File("./output/wetter_grossstadt_muenchen.html").toPath());
        assertTrue(münchen.contains("<p>In München ist es regnerisch.</p>"));
        assertTrue(münchen.contains("<p>Dies trifft auch für Schwabing, Sendlingen, Lehel und Nympenburg zu.</p>"));
    }

    @Test
    public void testkoelnContent() throws IOException {
        String köln = Files.readString(new File("./output/wetter_grossstadt_koeln.html").toPath());
        assertTrue(köln.contains("<p>In Köln ist es sonnig.</p>"));
        assertTrue(köln.contains("<p>Dies trifft auch für Ehrenfeld, Raderthal, Nippes, Poll, Esch, Pesch und Kalk zu.</p>"));
    }

    @Test
    public void testrosenheim() throws IOException {

        String rosenheim = Files.readString(new File("./output/wetter_kleinstadt_rosenheim.html").toPath());
        assertTrue(rosenheim.contains("<p>In Rosenheim ist es bewoelkt.</p>"));

    }

    @AfterAll
    public static void deletedirectory() {
        File outputDir = new File("./output");
        if (outputDir.exists()) {
            for (File file : outputDir.listFiles()) {
                file.delete();
            }
            outputDir.delete();
        }
    }
}
