package th.rosenheim.oop;

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
                nav += "| ";
            }
            nav += "<a href=\"" + stadt.getURL() + "\">" + stadt.name + "</a>";
        }
        return "<h1>Die Wetter-Website</h1><p>" + nav + "</p>";
    }
    private String generatePage(String navigation, String content) {
        return "<html><body>"+navigation+content+"</body></html>";
    }


}
