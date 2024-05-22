package th.rosenheim.oop;


public abstract  class Stadt {
    protected String name;
    protected Wetter wetter;

    public Stadt(String name, Wetter wetter) {
        this.name = name;
        this.wetter = wetter;
    }

    public abstract String getContent();

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
    protected abstract String getURLPrefix();
}
