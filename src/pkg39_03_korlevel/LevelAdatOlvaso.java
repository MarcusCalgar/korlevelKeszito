package pkg39_03_korlevel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LevelAdatOlvaso {

    private BufferedReader buffer;
    private Pattern minta = Pattern.compile("([0-9]+);([a-zA-Z .]{1,30});([^@ ]+@[a-z\\.]+[^\\W\\.]{1,30});(\\d{4}-\\d{2}-\\d{2})");

    public LevelAdatOlvaso(String fajlNev) throws FileNotFoundException {
        try {
            buffer = new BufferedReader(new FileReader(fajlNev));
        } catch (FileNotFoundException ex) {
            System.out.println("Nem találom a " + fajlNev + " nevű fájlt.");
        }
    }

    public Map<String, String> next() throws IOException {
        Map<String, String> talalat = new HashMap<>();
        Map<String, String> ures = new HashMap<>();
        String beolvasottSor;
        if ((beolvasottSor = buffer.readLine()) != null) {
            while (beolvasottSor.startsWith("#")) {
                beolvasottSor = buffer.readLine();
                if (beolvasottSor == null) {
                    return ures;
                }
            }
            Matcher kereso = minta.matcher(beolvasottSor);
            while (kereso.find()) {
                talalat.put("NEV", kereso.group(2));
                talalat.put("EMAIL", kereso.group(3));
                talalat.put("SZULDATUM", kereso.group(4));
            }
            return talalat;
        } else {            
            return ures;
        }
    }

    public void zar() throws IOException {
        buffer.close();
    }
}
