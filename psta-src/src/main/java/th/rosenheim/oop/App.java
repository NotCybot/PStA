package th.rosenheim.oop;


import java.util.List;

public class App {


    public static void main(String[] args) {
        WebseitenGenerator webseitenGenerator = new WebseitenGenerator();


        Grossstadt München = new Grossstadt("München", Wetter.REGNERISCH, List.of("Schwabing", "Sendlingen", "Lehel", "Nympenburg"));
        Kleinstadt Rosenheim = new Kleinstadt("Rosenheim", Wetter.BEWOELKT);
        Grossstadt Köln = new Grossstadt("Köln", Wetter.SONNIG, List.of("Ehrenfeld", "Raderthal", "Nippes", "Poll", "Esch", "Pesch", "Kalk"));


        webseitenGenerator.addStadt(München);
        webseitenGenerator.addStadt(Rosenheim);
        webseitenGenerator.addStadt(Köln);

        webseitenGenerator.generate();
    }

}
