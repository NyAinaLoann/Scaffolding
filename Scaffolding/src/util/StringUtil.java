package util;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class StringUtil {
    public static String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
    
    public static String extract(String word, String keyword) {
        // Utilisation de replaceAll pour supprimer tous les occurrences du keyword
        return word.replaceAll(keyword, "");
    }
    
    public static String getValue(String language, String key) {
        // Charger le fichier JSON
        
        Gson gson = new Gson();
        String configFile = System.getProperty("user.dir")+"/src/configFiles/controllervariable.json";
        
        try (Reader reader = new FileReader(configFile)) {
            JsonObject config = gson.fromJson(reader, JsonObject.class);

            if (config.has(language)) {
                JsonObject languageConfig = config.getAsJsonObject(language);

                if (languageConfig.has( extract(key, "#") )) {
                    //System.out.println( " extraction " + extract(key, "#") 
                    //+ " " + languageConfig.get(extract(key, "#")).getAsString());
                    return languageConfig.get(extract(key, "#")).getAsString();
                }
            }
        } catch (Exception e) {
            //e.printStackTrace();
            return key;
        }

        // Retourner la clé si la langue ou la clé spécifiée n'a pas été trouvée
        return key;
    }
    
    public static List<String> getLibraries(String language) {
        Gson gson = new Gson();
        String configFile = System.getProperty("user.dir")+"/src/configFiles/controllervariable.json";
        try (Reader reader = new FileReader(configFile)) {
            JsonObject config = gson.fromJson(reader, JsonObject.class);

            if (config.has(language)) {
                JsonObject languageConfig = config.getAsJsonObject(language);

                if (languageConfig.has("libraries")) {
                    JsonArray librariesArray = languageConfig.getAsJsonArray("libraries");
                    List<String> librariesList = new ArrayList<>();

                    for (int i = 0; i < librariesArray.size(); i++) {
                        librariesList.add(librariesArray.get(i).getAsString());
                    }

                    return librariesList;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Retourne une liste vide si la clé ou le langage n'est pas trouvé
        return new ArrayList<>();
    }
    
}
