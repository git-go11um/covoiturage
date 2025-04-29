package fr.covoiturage;

import java.util.ArrayList;

public class Trajet {
    String depart="";
    String arrivee="";
    int distance=0;
    double dureePrev=0;//a exprimer en minutes*0.0167 (1/60 = 0.0167)
    double duree=0;
    private Conducteur conducteur;
    ArrayList<Passager> listePassager;
    boolean estRapide=false;
    double vitesseMoyenne=0;
    




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

    

    public double getDuree() {
        return duree;
    }
    public void setDuree(double duree) {
        this.duree = duree;
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
    public void setDureePrev(double dureePrev) {
        this.dureePrev = dureePrev;
    }

    public Conducteur getConducteur() {
        return conducteur;
    }
    public void setConducteur(Conducteur conducteur) {
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
            this.vitesseMoyenne = (double) distance / dureePrev;
            System.out.println("La vitesse moyenne est de " + this.vitesseMoyenne + " km/h.");
        } else {
            System.out.println("La durée prévue doit être supérieure à zéro pour calculer la vitesse moyenne.");
        }
    }
    



    public boolean estLong() {
        return distance > 300; // Exemple de logique : un trajet est long s'il dépasse 100 km
          }

    public boolean estRapide() {
        System.out.println("vitesseMoyenne = " + this.vitesseMoyenne);
        if(this.vitesseMoyenne<=100){
            estRapide=false;
            System.out.println( "non n'est pas rapide");
        }else{
            estRapide=true;
            System.out.println( "oui est rapide");}
        return estRapide; //   estRapide() retourne vrai si la vitesse moyenne > 100 km/h 
    }




    @Override
    public String toString() {
        return "Trajet [depart=" + depart + ", arrivee=" + arrivee + ", distance=" + distance + ", dureePrev="
                + dureePrev + ", conducteur=" + conducteur.getNom() + ", listePassager=" + listePassager + "]";
    }








}
