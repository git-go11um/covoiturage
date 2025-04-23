package fr.covoiturage;

import java.util.ArrayList;

public class Trajet {
    String depart="";
    String arrivee="";
    int distance=0;
    double dureePrev=0;//a exprimer en minutes*0.0167 (1/60 = 0.0167)
    String conducteur="";
    ArrayList<Passager> listePassager;
    




    public Trajet(String depart, String arrivee, int distance, double dureePrev, String conducteur) {
        this.depart = depart;
        this.arrivee = arrivee;
        this.distance = distance;
        this.dureePrev = dureePrev;
        this.conducteur = conducteur;
        this.listePassager = new ArrayList<>();
    }

    

    public String getDepart() {
        return depart;
    }
    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getArrivee() {
        return arrivee;
    }
    public void setArrivee(String arrivee) {
        this.arrivee = arrivee;
    }

    public int getDistance() {
        return distance;
    }
    public void setDistance(int distance) {
        this.distance = distance;
    }

    public double getDureePrev() {
        return dureePrev;
    }
    public void setDureePrev(int dureePrev) {
        this.dureePrev = dureePrev;
    }

    public String getConducteur() {
        return conducteur;
    }
    public void setConducteur(String conducteur) {
        this.conducteur = conducteur;
    }

    public ArrayList<Passager> getListePassager() {
        return listePassager;
    }
    public void setListePassager(ArrayList<Passager> listePassager) {
        this.listePassager = listePassager;
    }

    public void ajouterPassager(Passager p) {
    listePassager.add(p); // Ajoute le passager à la liste
    System.out.println("L'utilisateur " + p.getNom() + " a été ajouté."); // Affiche un message
    }

    
    public void calculerVitesseMoyenne() {
        if (dureePrev > 0) {
            double vitesseMoyenne = (double) distance / dureePrev;
            System.out.println("La vitesse moyenne est de " + vitesseMoyenne + " km/h.");
        } else {
            System.out.println("La durée prévue doit être supérieure à zéro pour calculer la vitesse moyenne.");
        }
    }
    
    public boolean estLong() {
        return distance > 300; // Exemple de logique : un trajet est long s'il dépasse 100 km
    }

    public boolean estRapide() {
        return FOIREUUUUUX dureePrev < 2; //   estRapide() retourne vrai si la vitesse moyenne > 100 km/h 
    }




    @Override
    public String toString() {
        return "Trajet [depart=" + depart + ", arrivee=" + arrivee + ", distance=" + distance + ", dureePrev="
                + dureePrev + ", conducteur=" + conducteur + ", listePassager=" + listePassager + "]";
    }










}
