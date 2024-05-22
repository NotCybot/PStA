package th.rosenheim.oop;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WebseitenGenerator {
    private List<Stadt>  staedte = new ArrayList<>();

    public void addStadt(Stadt stadt) {
        staedte.add(stadt);
    }
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
    private String generatePage(String navigation, String content) {
        return "<html><body>"+navigation+content+"</body></html>";
    }

    public void generate() throws IOException {
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
