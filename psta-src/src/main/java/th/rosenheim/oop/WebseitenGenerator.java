package th.rosenheim.oop;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for generating web pages for each city.
 */

public class WebseitenGenerator {
    private List<Stadt>  staedte = new ArrayList<>();

    /**
     * Adds a city to the list of cities.
     *
     * @param stadt The city to add.
     */

    public void addStadt(Stadt stadt) {
        staedte.add(stadt);
    }

    /**
     * Generates the navigation bar for the web pages.
     *
     * @return The HTML for the navigation bar.
     */

    public String getNavigator() {
        String nav = "";
        for (Stadt stadt : staedte) {
            if (!nav.isEmpty()) {
                nav += " | ";
            }
            nav += "<a href=\"" + stadt.getURL() + "\">" + stadt.name + "</a>";
        }
        return "<h1>Die Wetter-Website</h1><p>" + nav + "</p>";
    }

    /**
     * Generates the HTML for a web page.
     *
     * @param navigation The HTML for the navigation bar.
     * @param content The HTML for the content of the page.
     * @return The HTML for the web page.
     */

    private String generatePage(String navigation, String content) {
        return "<html><body>"+navigation+content+"</body></html>";
    }

    /**
     * Generates the web pages for each city and saves them in the "output" directory.
     */

    public void generateWebsites() throws IOException {
        String navigation = getNavigator();

        File outputDir = new File("./output");
        if (!outputDir.exists()) {
            outputDir.mkdir();
        }
        try  (FileWriter indexwriter = new FileWriter(new File(outputDir, "index.html"))) {
            indexwriter.write(generatePage(navigation, ""));
        }

        staedte.stream().forEach(stadt -> {
            try (FileWriter writer = new FileWriter(new File(outputDir, stadt.getURL()))) {
                writer.write(generatePage(navigation, stadt.getContent()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }


}
