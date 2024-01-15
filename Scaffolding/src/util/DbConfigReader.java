package util;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;

import scaffolding.DBConfig;

public class DbConfigReader {
    String filePath = System.getProperty("user.dir")+"/src/configFiles/dbconfigs.json";
    //String cheminExecution = System.getProperty("user.dir");
    
    public DBConfig read() throws Exception{
        //System.out.println("Chemin : "+cheminExecution);
        // Obtenir le chemin du fichier Java en cours
        //String cheminFichierJavaEnCours = CheminFichierJavaEnCours.class.getProtectionDomain().getCodeSource().getLocation().getPath();

        //System.out.println("Chemin du fichier Java en cours : " + cheminFichierJavaEnCours);
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            Gson gson = new Gson();
            DBConfig dbconfig = gson.fromJson(reader, DBConfig.class);
            return dbconfig;
        } catch (IOException e) {
            throw e;
        }
    }
}
