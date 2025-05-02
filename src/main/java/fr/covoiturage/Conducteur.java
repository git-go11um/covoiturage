package fr.covoiturage;

import java.util.ArrayList;

/**
 * La classe Conducteur représente un conducteur dans le système de covoiturage.
 * Elle hérite de la classe Utilisateur et implémente l'interface Evaluable.
 */
public class Conducteur extends Utilisateur implements Evaluable {
    private ArrayList<Trajet> trajets;
    private ArrayList<Integer> notes;
    private String voiture;
    private double vitesseMoyenne;

    /**
     * Constructeur de la classe Conducteur.
     *
     * @param nom le nom du conducteur
     * @param villeDepart la ville de départ
     * @param villeArrivee la ville d'arrivée
     * @param moyenneDistance la distance moyenne parcourue
     * @param voiture la voiture du conducteur
     * @param vitesseMoyenne la vitesse moyenne du conducteur
     */
    public Conducteur(String nom, String villeDepart, String villeArrivee, double moyenneDistance, String voiture, double vitesseMoyenne) {
        super(nom, villeDepart, villeArrivee, moyenneDistance);
        this.voiture = voiture;
        this.vitesseMoyenne = vitesseMoyenne;
        this.trajets = new ArrayList<>();
        this.notes = new ArrayList<>();
    }

    /**
     * Retourne la distance moyenne parcourue par le conducteur.
     *
     * @return la distance moyenne
     */
    @Override
    public double getMoyenneDistance() {
        return super.getMoyenneDistance();
    }

    /**
     * Définit la distance moyenne parcourue par le conducteur.
     *
     * @param moyenneDistance la nouvelle distance moyenne
     */
    @Override
    public void setMoyenneDistance(double moyenneDistance) {
        super.setMoyenneDistance(moyenneDistance);
    }

    /**
     * Retourne la vitesse moyenne du conducteur.
     *
     * @return la vitesse moyenne
     */
    public double getVitesseMoyenne() {
        return vitesseMoyenne;
    }

    /**
     * Retourne le nom du conducteur.
     *
     * @return le nom du conducteur
     */
    @Override
    public String getNom() {
        return super.getNom();
    }

    /**
     * Définit le nom du conducteur.
     *
     * @param nom le nouveau nom du conducteur
     */
    @Override
    public void setNom(String nom) {
        super.setNom(nom);
    }

    /**
     * Retourne la liste des trajets effectués par le conducteur.
     *
     * @return la liste des trajets
     */
    public ArrayList<Trajet> getTrajets() {
        return trajets;
    }

    /**
     * Retourne la voiture du conducteur.
     *
     * @return la voiture
     */
    public String getVoiture() {
        return voiture;
    }

    /**
     * Définit la voiture du conducteur.
     *
     * @param voiture la nouvelle voiture
     */
    public void setVoiture(String voiture) {
        this.voiture = voiture;
    }

    /**
     * Ajoute un trajet à la liste des trajets du conducteur.
     *
     * @param trajet le trajet à ajouter
     */
    public void ajouterTrajet(Trajet trajet) {
        if (trajet != null) {
            trajets.add(trajet);
        } else {
            System.out.println("Erreur : Le trajet à ajouter ne peut pas être null.");
        }
    }

    /**
     * Affiche le profil du conducteur.
     */
    @Override
    public void afficherProfil() {
        System.out.println(toString());
    }

    /**
     * Ajoute une note à un passager.
     *
     * @param utilisateur l'utilisateur à noter
     * @param note la note à ajouter
     */
    @Override
    public void ajouterNote(Utilisateur utilisateur, int note) {
        if (utilisateur instanceof Passager) {
            Passager passager = (Passager) utilisateur;
            passager.ajouterNote(note);
            System.out.println("Le conducteur " + getNom() + " a donné une note de " + note + " au passager " + passager.getNom());
        } else {
            System.out.println("Seuls les passagers peuvent être notés par les conducteurs.");
        }
    }

    /**
     * Ajoute une note au conducteur.
     *
     * @param note la note à ajouter
     */
    public void ajouterNote(int note) {
        notes.add(note);
        System.out.println("Note ajoutée : " + note);
    }

    /**
     * Calcule la note moyenne du conducteur.
     *
     * @return la note moyenne
     */
    @Override
    public double calculerNoteMoyenne() {
        if (notes.isEmpty()) {
            return 0;
        }

        int somme = 0;
        for (int note : notes) {
            somme += note;
        }

        return (double) somme / notes.size();
    }

    /**
     * Calcule la distance totale parcourue par le conducteur.
     *
     * @return la distance totale
     */
    public double calculerDistanceTotale() {
        double distanceTotale = 0;
        for (Trajet trajet : trajets) {
            distanceTotale += trajet.getDistance();
        }
        return distanceTotale;
    }

    /**
     * Retourne une représentation sous forme de chaîne de caractères du conducteur.
     *
     * @return la représentation sous forme de chaîne de caractères
     */
    @Override
    public String toString() {
        return "Conducteur [nom=" + getNom() + ", villeDepart=" + getVilleDepart() + ", villeArrivee=" + getVilleArrivee() +
               ", voiture=" + voiture + ", distance totale : " + calculerDistanceTotale() + " km" + ", note moyenne : " + calculerNoteMoyenne() + "]";
    }
}
