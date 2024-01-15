package scaffolding;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;

public class DynamicClassGenerator {
    
    //private static final Gson gson = new Gson();
    //private static final String configFile = System.getProperty("user.dir")+"/src/configFiles/sqltypelanguage.json";
    
    public static MyClasse getClass(String sqlType,String language) throws Exception{
        try {
            if(language.compareTo("java")==0){
                return mapSqlType(language, sqlType);
            }
            else if(language.compareTo("csharp")==0){
                return mapSqlType(language, sqlType);
            }
            else{
                throw new Exception("Defaut de language");
            }
        } catch (Exception e) {
            throw new Exception("Aucune classe trouvee pour "+sqlType);
        }
    }
    
    public static MyClasse mapSqlType(String language, String sqltype) {
        Gson gson = new Gson();
        String configFile = System.getProperty("user.dir")+"/src/configFiles/sqltypelanguage.json";
        //JsonObject config = gson.fromJson(configFile, JsonObject.class);

        try (Reader reader = new FileReader(configFile)) {
            JsonObject config = gson.fromJson(reader, JsonObject.class);
             
            if (config.has(language)) {
                JsonObject languageConfig = config.getAsJsonObject(language);
                JsonObject classConfig = null;
                JsonArray sqlTypesArray = null;
                List<String> sqlTypesList = null;
                String packageName = null;
                
                for (String className : languageConfig.keySet()) {
                    classConfig = languageConfig.getAsJsonObject(className);
                    sqlTypesArray = classConfig.getAsJsonArray("sqltype");
                    sqlTypesList = gson.fromJson(sqlTypesArray, List.class);

                    if (sqlTypesList.contains(sqltype)) {
                        packageName = classConfig.get("package").getAsString();
                        return new MyClasse(className, packageName);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Return a default value or handle the case when the configuration is not found.
        return new MyClasse("Object", "java.lang");

       
    }

    
//    public static MyClasse mapSqlTypeToJava(String sqlType) {
//        String classename = "";
//        String packagename = "";
//        System.out.println(sqlType.toLowerCase());
//        switch (sqlType.toLowerCase()) {
//            case "varchar":
//            case "text":
//            case "json":
//            case "char":
//            case "uuid":
//                classename = "String";
//                packagename = "java.lang";
//                break;
//            case "int":
//                classename = "Integer";
//                packagename = "java.lang";
//                break;
//            case "bigint":
//            case "serial":
//                classename = "Long";
//                packagename = "java.lang";
//                break;
//            case "numeric":
//            case "decimal":
//            case "double":
//                classename = "Double";
//                packagename = "java.lang";
//                break;
//            case "real":
//                classename = "Float";
//                packagename = "java.lang";
//                break;
//            case "date":
//                classename = "Date";
//                packagename = "java.sql";
//                break;
//            case "time":
//                classename = "Time";
//                packagename = "java.sql";
//                break;
//            case "timestamp":
//                classename = "Timestamp";
//                packagename= "java.sql";
//                break;
//            case "boolean":
//                classename = "Boolean";
//                packagename = "java.lang";
//                break;
//            default:
//                classename = "Object";
//                packagename = "java.lang";   
//                break;         
//        }
//        return new MyClasse(classename,packagename);
//    } 
//    
//    public static MyClasse MapSqlTypeToCSharp(String sqlType)
//    {
//        String className = "";
//        String namespaceName = "";
//
//        switch (sqlType.toLowerCase())
//        {
//            case "varchar":
//            case "text":
//            case "json":
//            case "char":
//            case "uuid":
//                className = "string";
//                namespaceName = "System";
//                break;
//            case "int":
//                className = "int";
//                namespaceName = "System";
//                break;
//            case "bigint":
//            case "serial":
//                className = "long";
//                namespaceName = "System";
//                break;
//            case "numeric":
//            case "decimal":
//            case "double":
//                className = "double";
//                namespaceName = "System";
//                break;
//            case "real":
//                className = "float";
//                namespaceName = "System";
//                break;
//            case "date":
//                className = "DateTime";
//                namespaceName = "System";
//                break;
//            case "time":
//                className = "TimeSpan";
//                namespaceName = "System";
//                break;
//            case "timestamp":
//                className = "DateTime";
//                namespaceName = "System";
//                break;
//            case "boolean":
//                className = "bool";
//                namespaceName = "System";
//                break;
//            default:
//                className = "object";
//                namespaceName = "System";
//                break;
//        }
//    return new MyClasse(className, namespaceName);
//    }

}
