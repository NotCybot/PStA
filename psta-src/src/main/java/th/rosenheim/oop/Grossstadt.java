package th.rosenheim.oop;

import java.util.List;

/**
 * This class represents a large city.
 * It extends the Stadt class and adds a list of districts.
 */

public class Grossstadt extends Stadt {
    private List<String> stadtteile;

    /**
     * Constructor for the Grossstadt class.
     *
     * @param name The name of the city.
     * @param wetter The weather in the city.
     * @param stadtteile The list of districts in the city.
     */

    public Grossstadt(String name, Wetter wetter, List<String> stadtteile) {
        super(name, wetter);
        this.stadtteile = stadtteile;
    }

    /**
     * Returns the content for the city's web page.
     *
     * @return The HTML for the content of the city's web page.
     */

    @Override
    public String getContent() {
        String stadteileString = String.join(", ", stadtteile.subList(0, stadtteile.size() - 1)) + " und " + stadtteile.get(stadtteile.size() - 1);
        return "<p>In " + name + " ist es " + wetter.toString().toLowerCase()+".<p>"+
                "<p>Dies trifft auch für " + stadteileString + " zu.</p>";
    }

    /**
     * Returns the URL prefix for the city's web page.
     *
     * @return The URL prefix for the city's web page.
     */

    @Override
    protected String getURLPrefix() {
        return "wetter_grossstadt_";
    }
}
