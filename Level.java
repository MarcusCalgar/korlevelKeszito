package pkg39_03_korlevel;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Level {

    private String levelSzoveg;
    private FajlNev fajlNev;

    public String getLevelSzoveg() {
        return levelSzoveg;
    }

    public Level(Sablon sablon, FajlNev fajlnev, Map<String, String> adatok) {
        this.fajlNev = fajlnev;
        StringBuffer kikuldendoLevelSzoveg = new StringBuffer();
        Pattern minta = Pattern.compile("\\$\\{([A-Z]+)\\}");
        Matcher kereso = minta.matcher(sablon.getSablon());
        while (kereso.find()) {
            String mezoKod = kereso.group(1);
            String mire = adatok.get(mezoKod);
            kereso.appendReplacement(kikuldendoLevelSzoveg, mire);
        }
        kereso.appendTail(kikuldendoLevelSzoveg);
        levelSzoveg = kikuldendoLevelSzoveg.toString();
    }

    public void fajlbaIr(int sorszam) throws IOException, SorszamException {
        String fajl = fajlNev.getFajlNev(sorszam);
        try (PrintWriter pw = new PrintWriter(new FileWriter(fajlNev.getFajlNev(sorszam)))) {
            pw.print(levelSzoveg);
        } catch (SorszamException | IOException ex) {
            throw new IOException("Hiba a " + fajlNev + ".txt" + " fájl írása közben.");
        }
    }
}
