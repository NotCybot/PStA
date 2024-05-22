package th.rosenheim.oop;

public class Kleinstadt extends Stadt{
    public Kleinstadt(String name, Wetter wetter) {
        super(name, wetter);
    }
    @Override
    public String getContent() {
        return String.format("<p>In %s ist es %s.</p>", name, wetter.toString().toLowerCase());
    }

    @Override
    protected String getURLPrefix() {
        return "wetter_kleinstadt_";
    }
}
