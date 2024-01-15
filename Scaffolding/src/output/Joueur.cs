namespace t;

public class Joueur{
    
  private string id_joueur;
  private string nom;
  private DateTime dtn;
  private string chemin;
    
    public string getId_joueur() {
        return id_joueur;
    }
    public void setId_joueur(string id_joueur) {
        this.id_joueur = id_joueur;
    }
    public string getNom() {
        return nom;
    }
    public void setNom(string nom) {
        this.nom = nom;
    }
    public DateTime getDtn() {
        return dtn;
    }
    public void setDtn(DateTime dtn) {
        this.dtn = dtn;
    }
    public string getChemin() {
        return chemin;
    }
    public void setChemin(string chemin) {
        this.chemin = chemin;
    }
}