package pkg39_03_korlevel;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
       try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Kérem a sablon fájl nevét: ");            
            String sablonFajlNev = sc.nextLine();
            Sablon levelSablon = new Sablon(sablonFajlNev);
            
            System.out.print("Kérem a címzetteket tartalmazó fájl nevét: ");
            String cimzettekFajlNev = sc.nextLine();
            LevelAdatOlvaso olvaso = new LevelAdatOlvaso(cimzettekFajlNev);
            
            System.out.print("Kérem a fájl név sablont: ");
            String fajlNevSablon = sc.nextLine();            
            FajlNev fajlnev = new FajlNev(fajlNevSablon);         
                        
            int levelSorszam = 1;
            
            Map<String, String> eredmeny = olvaso.next();
            while (!eredmeny.isEmpty()) {
                Level kikuldendoLevel = new Level(levelSablon, fajlnev, eredmeny);
                kikuldendoLevel.fajlbaIr(levelSorszam);
                levelSorszam++;
                eredmeny = olvaso.next();
            }
            olvaso.zar();
        } catch (SorszamException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
