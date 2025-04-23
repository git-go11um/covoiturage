package fr.covoiturage;

import java.util.ArrayList;

public class Conducteur extends Utilisateur implements Evaluable{
    ArrayList<Trajet> trajets;
    ArrayList<Integer> notes;
    String voiture="";
    double vitesseMoyenne=0;
    
    
    public Conducteur(String nom, String villeDepart, String villeArrivee, double moyenneDistance, String voiture, double vitesseMoyenne) {
        super(nom, villeDepart, villeArrivee, moyenneDistance);
        this.voiture = voiture;
        this.vitesseMoyenne = vitesseMoyenne;
        this.trajets=new ArrayList<>();
        this.notes=new ArrayList<>();
        

    }


    @Override
    public double getMoyenneDistance() {
        return super.getMoyenneDistance();
    }

    @Override
    public void setMoyenneDistance(double moyenneDistance) {
        super.setMoyenneDistance(moyenneDistance);
    }

    public double getVitesseMoyenne() {
        return vitesseMoyenne;
    }


    @Override
    public String getNom() {
        return "Conducteur : " + super.getNom(); // Surcharge du getter
    }

    public ArrayList<Trajet> getTrajets() {
        return trajets;
    }
    public String getVoiture() {
        return voiture;
    }
    public void setVoiture(String voiture) {
        this.voiture = voiture;
    }

    public void ajouterTrajet(Trajet trajet){
        trajets.add(trajet);
    }




    @Override
    public void afficherProfil(){
        System.out.println(toString());
    }


    @Override
    public void ajouterNote(int note) {
        notes.add(note);
    }

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

    public double calculerDistanceTotale() {
        double distanceTotale = 0;
        for (Trajet trajet : trajets) {
            distanceTotale += trajet.getDistance();
        }
        return distanceTotale;
    }

    @Override
    public String toString() {
        return "Conducteur [nom=" + nom + ", trajets=" + trajets + ", voiture=" + voiture + " distance totale : " + calculerDistanceTotale() + "]";
    }


        /*
        return "Conducteur [nom=" + nom + ", villeDepart=" + villeDepart + ", villeArrivee=" + villeArrivee
                + ", trajets=" + trajets + ", voiture=" + voiture + calculerDistanceTotale() + "]";
    }*/





    





   


















    
}
