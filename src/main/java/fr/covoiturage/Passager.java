package fr.covoiturage;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe représentant un passager dans le système de covoiturage.
 * Un passager peut suivre des trajets, ajouter des notes aux conducteurs
 * et calculer sa note moyenne.
 */
public class Passager extends Utilisateur implements Evaluable {

    private ArrayList<Trajet> trajetSuivis;
    private String destPref = "";
    private List<Integer> notes;

    /**
     * Constructeur pour créer un nouveau passager.
     *
     * @param nom le nom du passager
     * @param villeDepart la ville de départ du passager
     * @param villeArrivee la ville d'arrivée du passager
     * @param destPref la destination préférée du passager
     * @param moyenneDistance la distance moyenne parcourue par le passager
     */
    public Passager(String nom, String villeDepart, String villeArrivee, String destPref, int moyenneDistance) {
        super(nom, villeDepart, villeArrivee, moyenneDistance);
        this.destPref = destPref;
        this.trajetSuivis = new ArrayList<>();
        this.notes = new ArrayList<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getNom() {
        return super.getNom(); // Surcharge du getter
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setNom(String nom) {
        super.setNom(nom);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getVilleDepart() {
        return "Ville de départ : " + super.getVilleDepart(); // Surcharge du getter
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getVilleArrivee() {
        return "Ville d'arrivée : " + super.getVilleArrivee(); // Surcharge du getter
    }

    /**
     * Retourne la liste des trajets suivis par le passager.
     *
     * @return la liste des trajets suivis
     */
    public ArrayList<Trajet> getTrajetSuivis() {
        return trajetSuivis;
    }

    /**
     * Retourne la destination préférée du passager.
     *
     * @return la destination préférée
     */
    public String getDestPref() {
        return destPref;
    }

    /**
     * Définit la destination préférée du passager.
     *
     * @param destPref la nouvelle destination préférée
     */
    public void setDestPref(String destPref) {
        this.destPref = destPref;
    }

    /**
     * Ajoute un trajet à la liste des trajets suivis par le passager.
     *
     * @param plateforme la plateforme de covoiturage
     * @param villeDepart la ville de départ du trajet
     * @param villeArrivee la ville d'arrivée du trajet
     */
    public void suivreTrajet(PlateformeCovoiturage plateforme, String villeDepart, String villeArrivee) {
        List<Trajet> trajetsTrouves = plateforme.rechercherTrajet(villeDepart, villeArrivee);

        if (!trajetsTrouves.isEmpty()) {
            for (Trajet trajet : trajetsTrouves) {
                if (!trajetSuivis.contains(trajet)) {
                    trajetSuivis.add(trajet);
                }
            }
            System.out.println("Le passager " + getNom() + " suit maintenant la liste de trajets suivante : " + getTrajetSuivis());
        } else {
            System.out.println("Aucun trajet correspondant trouvé pour le départ de " + villeDepart + " et l'arrivée à " + villeArrivee);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void ajouterNote(Utilisateur utilisateur, int note) {
        if (utilisateur instanceof Conducteur) {
            Conducteur conducteur = (Conducteur) utilisateur;
            conducteur.ajouterNote(note); // Ajouter directement la note au conducteur
            System.out.println("Le passager " + getNom() + " a donné une note de " + note + " au conducteur " + conducteur.getNom());
        } else if (utilisateur instanceof Passager) {
            notes.add(note);
            System.out.println("Le passager " + getNom() + " a reçu une note de " + note + " de la part de " + utilisateur.getNom());
        } else {
            System.out.println("Seuls les conducteurs peuvent être notés par les passagers, et seuls les passagers peuvent noter d'autres passagers.");
        }
    }

    /**
     * Ajoute une note au passager.
     *
     * @param note la note à ajouter
     */
    public void ajouterNote(int note) {
        notes.add(note);
        System.out.println("Note ajoutée : " + note); // Ajout d'un message de débogage
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double calculerNoteMoyenne() {
        if (notes.isEmpty()) {
            return 0; // Si la liste des notes est vide, retourner 0
        }

        int somme = 0;
        for (int note : notes) {
            somme += note;
        }

        return (double) somme / notes.size();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void afficherProfil() {
        System.out.println(toString());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Passager [nom=" + getNom() + ", villeDepart=" + getVilleDepart() + ", villeArrivee=" + getVilleArrivee()
                + ", trajetsPassager=" + trajetSuivis + ", destPref=" + destPref + "]";
    }
}
