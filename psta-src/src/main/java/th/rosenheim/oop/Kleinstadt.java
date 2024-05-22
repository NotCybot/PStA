package th.rosenheim.oop;

/**
 * This class represents a small city.
 * It extends the Stadt class.
 */

public class Kleinstadt extends Stadt{

    /**
     * Constructor for the Kleinstadt class.
     *
     * @param name The name of the city.
     * @param wetter The weather in the city.
     */

    public Kleinstadt(String name, Wetter wetter) {
        super(name, wetter);
    }

    /**
     * Returns the content for the city's web page.
     *
     * @return The HTML for the content of the city's web page.
     */

    @Override
    public String getContent() {
        return String.format("<p>In %s ist es %s.</p>", name, wetter.toString().toLowerCase());
    }

    /**
     * Returns the URL prefix for the city's web page.
     *
     * @return The URL prefix for the city's web page.
     */

    @Override
    protected String getURLPrefix() {
        return "wetter_kleinstadt_";
    }
}
