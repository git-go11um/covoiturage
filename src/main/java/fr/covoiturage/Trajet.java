package fr.covoiturage;

import java.util.ArrayList;

/**
 * Classe représentant un trajet dans le système de covoiturage.
 * Un trajet est défini par une ville de départ, une ville d'arrivée, une distance,
 * une durée prévue, un conducteur, et une liste de passagers.
 */
public class Trajet {
    private String depart = "";
    private String arrivee = "";
    private int distance = 0;
    private double dureePrev = 0; // à exprimer en minutes * 0.0167 (1/60 = 0.0167)
    private double duree = 0;
    private Conducteur conducteur;
    private ArrayList<Passager> listePassager;
    private boolean estRapide = false;
    private double vitesseMoyenne = 0;

    /**
     * Constructeur pour créer un nouveau trajet.
     *
     * @param depart la ville de départ
     * @param arrivee la ville d'arrivée
     * @param distance la distance du trajet
     * @param dureePrev la durée prévue du trajet
     * @param conducteur le conducteur du trajet
     * @param duree la durée réelle du trajet
     */
    public Trajet(String depart, String arrivee, int distance, double dureePrev, Conducteur conducteur, double duree) {
        this.depart = depart;
        this.arrivee = arrivee;
        this.distance = distance;
        this.dureePrev = dureePrev;
        this.conducteur = conducteur;
        this.duree = duree;
        this.listePassager = new ArrayList<>();
        this.calculerVitesseMoyenne();
    }

    /**
     * Retourne la durée réelle du trajet.
     *
     * @return la durée réelle du trajet
     */
    public double getDuree() {
        return duree;
    }

    /**
     * Définit la durée réelle du trajet.
     *
     * @param duree la nouvelle durée réelle du trajet
     */
    public void setDuree(double duree) {
        this.duree = duree;
    }

    /**
     * Retourne la ville de départ du trajet.
     *
     * @return la ville de départ
     */
    public String getDepart() {
        return depart;
    }

    /**
     * Définit la ville de départ du trajet.
     *
     * @param depart la nouvelle ville de départ
     */
    public void setDepart(String depart) {
        this.depart = depart;
    }

    /**
     * Retourne la ville d'arrivée du trajet.
     *
     * @return la ville d'arrivée
     */
    public String getArrivee() {
        return arrivee;
    }

    /**
     * Définit la ville d'arrivée du trajet.
     *
     * @param arrivee la nouvelle ville d'arrivée
     */
    public void setArrivee(String arrivee) {
        this.arrivee = arrivee;
    }

    /**
     * Retourne la distance du trajet.
     *
     * @return la distance du trajet
     */
    public int getDistance() {
        return distance;
    }

    /**
     * Définit la distance du trajet.
     *
     * @param distance la nouvelle distance du trajet
     */
    public void setDistance(int distance) {
        this.distance = distance;
    }

    /**
     * Retourne la durée prévue du trajet.
     *
     * @return la durée prévue du trajet
     */
    public double getDureePrev() {
        return dureePrev;
    }

    /**
     * Définit la durée prévue du trajet.
     *
     * @param dureePrev la nouvelle durée prévue du trajet
     */
    public void setDureePrev(double dureePrev) {
        this.dureePrev = dureePrev;
    }

    /**
     * Retourne le conducteur du trajet.
     *
     * @return le conducteur du trajet
     */
    public Conducteur getConducteur() {
        return conducteur;
    }

    /**
     * Définit le conducteur du trajet.
     *
     * @param conducteur le nouveau conducteur du trajet
     */
    public void setConducteur(Conducteur conducteur) {
        this.conducteur = conducteur;
    }

    /**
     * Retourne la liste des passagers du trajet.
     *
     * @return la liste des passagers
     */
    public ArrayList<Passager> getListePassager() {
        return listePassager;
    }

    /**
     * Définit la liste des passagers du trajet.
     *
     * @param listePassager la nouvelle liste des passagers
     */
    public void setListePassager(ArrayList<Passager> listePassager) {
        this.listePassager = listePassager;
    }

    /**
     * Ajoute un passager à la liste des passagers du trajet.
     *
     * @param p le passager à ajouter
     */
    public void ajouterPassager(Passager p) {
        listePassager.add(p); // Ajoute le passager à la liste
        System.out.println("L'utilisateur " + p.getNom() + " a été ajouté."); // Affiche un message
    }

    /**
     * Calcule la vitesse moyenne du trajet en fonction de la distance et de la durée réelle.
     */
    public void calculerVitesseMoyenne() {
        if (duree > 0) {
            this.vitesseMoyenne = (double) distance / duree;
            System.out.println("La vitesse moyenne est de " + this.vitesseMoyenne + " km/h.");
        } else {
            System.out.println("La durée réelle doit être supérieure à zéro pour calculer la vitesse moyenne.");
        }
    }

    /**
     * Vérifie si le trajet est considéré comme long (distance > 300 km).
     *
     * @return vrai si le trajet est long, faux sinon
     */
    public boolean estLong() {
        return distance > 300; // Exemple de logique : un trajet est long s'il dépasse 300 km
    }

    /**
     * Vérifie si le trajet est considéré comme rapide (vitesse moyenne > 100 km/h).
     *
     * @return vrai si le trajet est rapide, faux sinon
     */
    public boolean estRapide() {
        System.out.println("vitesseMoyenne = " + this.vitesseMoyenne);
        if (this.vitesseMoyenne <= 100) {
            estRapide = false;
            System.out.println("non n'est pas rapide");
        } else {
            estRapide = true;
            System.out.println("oui est rapide");
        }
        return estRapide; // estRapide() retourne vrai si la vitesse moyenne > 100 km/h
    }

    /**
     * Retourne une représentation sous forme de chaîne de caractères du trajet.
     *
     * @return une représentation sous forme de chaîne de caractères du trajet
     */
    @Override
    public String toString() {
        return "Trajet [depart=" + depart + ", arrivee=" + arrivee + ", distance=" + distance + ", dureePrev="
                + dureePrev + ", conducteur=" + conducteur.getNom() + ", listePassager=" + listePassager + "]";
    }
}
