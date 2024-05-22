package th.rosenheim.oop;

import java.util.List;

public class Grossstadt extends Stadt {
    private List<String> stadtteile;

    public Grossstadt(String name, Wetter wetter, List<String> stadtteile) {
        super(name, wetter);
        this.stadtteile = stadtteile;
    }
    @Override
    public String getContent() {
        String stadteileString = String.join(", ", stadtteile.subList(0, stadtteile.size() - 1)) + " und " + stadtteile.get(stadtteile.size() - 1);
        return "<p>In " + name + "ist es " + wetter.toString().toLowerCase()+".<p>"+
                "<p>Dies trifft auch für " + stadteileString + "zu.</p>";
    }

    @Override
    public String getURL() {
        return "wetter_grossstadt_" + formatURL() + ".html";
    }
}
