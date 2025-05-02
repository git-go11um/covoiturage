package fr.covoiturage;

/**
 * Classe représentant un utilisateur dans le système de covoiturage.
 * Un utilisateur est défini par un nom, une ville de départ, une ville d'arrivée,
 * et une distance moyenne parcourue.
 */
public class Utilisateur {

    private String nom = "";
    private String villeDepart = "";
    private String villeArrivee = "";
    private double moyenneDistance;

    /**
     * Constructeur pour créer un nouvel utilisateur.
     *
     * @param nom le nom de l'utilisateur
     * @param villeDepart la ville de départ de l'utilisateur
     * @param villeArrivee la ville d'arrivée de l'utilisateur
     * @param moyenneDistance la distance moyenne parcourue par l'utilisateur
     */
    public Utilisateur(String nom, String villeDepart, String villeArrivee, double moyenneDistance) {
        this.nom = nom;
        this.villeDepart = villeDepart;
        this.villeArrivee = villeArrivee;
        this.moyenneDistance = moyenneDistance;
    }

    /**
     * Retourne le nom de l'utilisateur.
     *
     * @return le nom de l'utilisateur
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit le nom de l'utilisateur.
     *
     * @param nom le nouveau nom de l'utilisateur
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne la ville de départ de l'utilisateur.
     *
     * @return la ville de départ
     */
    public String getVilleDepart() {
        return villeDepart;
    }

    /**
     * Définit la ville de départ de l'utilisateur.
     *
     * @param villeDepart la nouvelle ville de départ
     */
    public void setVilleDepart(String villeDepart) {
        this.villeDepart = villeDepart;
    }

    /**
     * Retourne la ville d'arrivée de l'utilisateur.
     *
     * @return la ville d'arrivée
     */
    public String getVilleArrivee() {
        return villeArrivee;
    }

    /**
     * Définit la ville d'arrivée de l'utilisateur.
     *
     * @param villeArrivee la nouvelle ville d'arrivée
     */
    public void setVilleArrivee(String villeArrivee) {
        this.villeArrivee = villeArrivee;
    }

    /**
     * Retourne la distance moyenne parcourue par l'utilisateur.
     *
     * @return la distance moyenne parcourue
     */
    public double getMoyenneDistance() {
        return moyenneDistance;
    }

    /**
     * Définit la distance moyenne parcourue par l'utilisateur.
     *
     * @param moyenneDistance la nouvelle distance moyenne parcourue
     */
    public void setMoyenneDistance(double moyenneDistance) {
        this.moyenneDistance = moyenneDistance;
    }

    /**
     * Affiche le profil de l'utilisateur.
     */
    public void afficherProfil() {
        System.out.println("Profil de l'utilisateur :");
        System.out.println(this.toString());
    }

    /**
     * Retourne une représentation sous forme de chaîne de caractères de l'utilisateur.
     *
     * @return une représentation sous forme de chaîne de caractères de l'utilisateur
     */
    @Override
    public String toString() {
        return "Utilisateur [nom=" + nom + ", villeDepart=" + villeDepart + ", villeArrivee=" + villeArrivee + "]";
    }
}
