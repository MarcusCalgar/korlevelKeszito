package pkg39_03_korlevel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Sablon {

    private String sablon = "";

    public Sablon(String fajlNev) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fajlNev))) {
            String kovetkezoSor;
            while ((kovetkezoSor = br.readLine()) != null) {
                sablon += kovetkezoSor + "\n";
            }
        } catch (IOException ex) {
            System.out.println("Nem találom a " + fajlNev + " nevű fájlt.");
        }
    }

    public String getSablon() {
        return sablon;
    }
}
