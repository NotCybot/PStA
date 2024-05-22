package th.rosenheim.oop;

/**
 * Base class for all types of cities.
 */

public abstract  class Stadt {
    protected String name;
    protected Wetter wetter;

    /**
     * Constructor for the Stadt class.
     *
     * @param name The name of the city.
     * @param wetter The weather in the city.
     */

    public Stadt(String name, Wetter wetter) {
        this.name = name;
        this.wetter = wetter;
    }

    /**
     * Returns the content for the city's web page.
     *
     * @return The HTML for the content of the city's web page.
     */

    public abstract String getContent();

    /**
     * Returns the URL for the city's web page.
     *
     * @return The URL for the city's web page.
     */

    protected String formatURL() {
        return  name.toLowerCase()
                .replace(" ", "_")
                .replace("ä", "ae")
                .replace("ö", "oe")
                .replace("ü", "ue");
    }
    public  String getURL() {
        return getURLPrefix() + formatURL() + ".html";
    };

    /**
     * Returns the URL prefix for the city's web page.
     *
     * @return The URL prefix for the city's web page.
     */

    protected abstract String getURLPrefix();
}
