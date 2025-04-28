package fr.covoiturage;

public class Utilisateur {
    
    private String nom ="";
    private String villeDepart="";
    private String villeArrivee="";
    private double moyenneDistance;
     
    public Utilisateur(String nom, String villeDepart, String villeArrivee, double moyenneDistance) {
        this.nom = nom;
        this.villeDepart = villeDepart;
        this.villeArrivee = villeArrivee;
        this.moyenneDistance = moyenneDistance;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public String getVilleDepart() {
        return villeDepart;
    }
    public void setVilleDepart(String villeDepart) {
        this.villeDepart = villeDepart;
    }

    public String getVilleArrivee() {
        return villeArrivee;
    }    
    public void setVilleArrivee(String villeArrivee) {
        this.villeArrivee = villeArrivee;
    }

    public double getMoyenneDistance() {
        return moyenneDistance;
    }
    public void setMoyenneDistance(double moyenneDistance) {

        this.moyenneDistance = moyenneDistance;
    }
    


    public void afficherProfil(){
        System.out.println("Profil de l'utilisateur :");
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Utilisateur [nom=" + nom + ", villeDepart=" + villeDepart + ", villeArrivee=" + villeArrivee + "]";
    }



    
}
