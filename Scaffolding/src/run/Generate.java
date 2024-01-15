package run;

import java.util.List;
import java.util.Scanner;
import scaffolding.DynamicClassGenerator;
import scaffolding.MyClasse;
import scaffolding.Scaffold;
import util.StringUtil;

public class Generate {
    public static void main(String[] args) {
        try {
            System.out.println("generating...");
//            List<String> ls = StringUtil.getLibraries("spring");
//            for (String l : ls) {
//                System.out.println(l);
//            }
          
            //Scaffold.generate("nba", "joueur", "joueur","t","java");
            //Scaffold.generate("commerce", "service", "service","t","java");
            //Scaffold.generateController("baovola", "look", "look","t","dotnet");
            //Scaffold.generate(args[0], args[1], args[2],args[3],"csharp");
            //MyClasse m = DynamicClassGenerator.getClass("postgres", "java","timestamp");
            //System.out.println(" " + m.getClassName() + " "+m.getPackageName());
            
           
            System.out.print("Choisir: \n");
            System.out.print("      1/ Classe\n");
            System.out.print("      2/Controller\n");
 
            Scanner scanner = new Scanner(System.in);
            System.out.print("Entrer votre choix: ");
            String i= scanner.nextLine();
            int val = Integer.valueOf(i);
            if(val==1){
                System.out.print("Entrez votre mot de passe : ");
                String mdp = scanner.nextLine();
                System.out.print("Entrez le nom de la table : ");
                String table = scanner.nextLine();
                System.out.print("Entrez le nom du model : ");
                String model = scanner.nextLine();
                System.out.print("Entrez le nom du package : ");
                String pack = scanner.nextLine();
                System.out.print("Entrez le nom du language : ");
                String language = scanner.nextLine();
                Scaffold.generate(mdp, table, model, pack, language);
            }else{
                System.out.print("Entrez votre mot de passe : ");
                String mdp = scanner.nextLine();
                System.out.print("Entrez le nom de la table : ");
                String table = scanner.nextLine();
                System.out.print("Entrez le nom du controller : ");
                String model = scanner.nextLine();
                System.out.print("Entrez le nom du package : ");
                String pack = scanner.nextLine();
                System.out.print("Entrez le nom du language : ");
                String language = scanner.nextLine();
                Scaffold.generateController(mdp, table, model, pack, language);
            }

            scanner.close();
            
            
            //Scaffold.generate(mdp,table,model,pack,language);

        
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
