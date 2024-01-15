package t;
import java.sql.Date;

public class Joueur {
    
  private String id_joueur;
  private String nom;
  private Date dtn;
  private String chemin;
    
    public String getId_joueur() {
        return id_joueur;
    }
    public void setId_joueur(String id_joueur) {
        this.id_joueur = id_joueur;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public Date getDtn() {
        return dtn;
    }
    public void setDtn(Date dtn) {
        this.dtn = dtn;
    }
    public String getChemin() {
        return chemin;
    }
    public void setChemin(String chemin) {
        this.chemin = chemin;
    }
}
