package th.rosenheim.oop;


import java.io.IOException;
import java.util.List;

/**
 * This is the main class that runs the application.
 */

public class App {

    /**
     * The main method that runs the application.
     *
     * @param args The command line arguments.
     * @throws IOException If an I/O error occurs.
     */

    public static void main(String[] args) throws IOException {
        WebseitenGenerator webseitenGenerator = new WebseitenGenerator();


        Grossstadt München = new Grossstadt("München", Wetter.REGNERISCH, List.of("Schwabing", "Sendlingen", "Lehel", "Nympenburg"));
        Kleinstadt Rosenheim = new Kleinstadt("Rosenheim", Wetter.BEWOELKT);
        Grossstadt Köln = new Grossstadt("Köln", Wetter.SONNIG, List.of("Ehrenfeld", "Raderthal", "Nippes", "Poll", "Esch", "Pesch", "Kalk"));


        webseitenGenerator.addStadt(München);
        webseitenGenerator.addStadt(Rosenheim);
        webseitenGenerator.addStadt(Köln);

        webseitenGenerator.generateWebsites();
    }

}
