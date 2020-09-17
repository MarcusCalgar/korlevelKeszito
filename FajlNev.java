package pkg39_03_korlevel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FajlNev {

    private String fajlNevSablon;

    public FajlNev(String fajlNevSablon) throws SorszamException {
        if (groupCheck(fajlNevSablon)) {
            this.fajlNevSablon = fajlNevSablon;
        } else {
            throw new SorszamException("Nem megfelelő formátumú fájlnév sablon.");
        }
    }

    public String getFajlNev(int i) throws SorszamException {
        if ((i + "").length() > numOfPounds(i)) {
            System.out.println((i + "").length());
            throw new SorszamException("Túl nagy a megadott sorszám.");
        }
        String minta = "#+";
        return fajlNevSablon.replaceAll(minta, createNumber(i));
    }

    private boolean groupCheck(String fajlNevSablon) {
        Pattern p = Pattern.compile("#+");
        Matcher m = p.matcher(fajlNevSablon);
        int numberOfGroups = 0;
        while (m.find()) {
            numberOfGroups++;
            if (numberOfGroups > 1) {
                return false;
            }
        }
        return true;
    }

    private String createNumber(int i) {
        int numOfZeros = numOfPounds(i) - (i + "").length();
        String number = "";
        for (int j = 0; j < numOfZeros; j++) {
            number += "0";
        }
        return number += (i + "");
    }

    private int numOfPounds(int i) {
        int numOfPounds = 0;
        for (char x : fajlNevSablon.toCharArray()) {
            if (x == '#') {
                numOfPounds++;
            }
        }
        return numOfPounds;
    }
}
