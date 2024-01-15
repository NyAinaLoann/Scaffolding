package t;

public class Service {
    
  private String id_service;
  private String utilisateur;
  private String nom;
  private String mdp;
    
    public String getId_service() {
        return id_service;
    }
    public void setId_service(String id_service) {
        this.id_service = id_service;
    }
    public String getUtilisateur() {
        return utilisateur;
    }
    public void setUtilisateur(String utilisateur) {
        this.utilisateur = utilisateur;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getMdp() {
        return mdp;
    }
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
}
