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
        return super.getNom(); // Surcharge du getter
    }

    @Override
    public void setNom(String nom) {
        super.setNom(nom); // Utilisez super.setNom() pour définir le nom de l'utilisateur
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



    public void ajouterTrajet(Trajet trajet) {
        if (trajet != null) {
            trajets.add(trajet);
        } else {
            System.out.println("Erreur : Le trajet à ajouter ne peut pas être null.");
        }
    }



    @Override
    public void afficherProfil(){
        System.out.println(toString());
    }


    @Override
    public void ajouterNote(Utilisateur utilisateur, int note) {
        if (utilisateur instanceof Passager) {
            Passager passager = (Passager) utilisateur;
            passager.ajouterNote(note); // Appeler la méthode ajouterNote du passager
            System.out.println("Le conducteur " + getNom() + " a donné une note de " + note + " au passager " + passager.getNom());
        } else {
            System.out.println("Seuls les passagers peuvent être notés par les conducteurs.");
        }
    }

    public void ajouterNote(int note) {
        notes.add(note);
        System.out.println("Note ajoutée : " + note); // Ajout d'un message de débogage
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
        return "Conducteur [nom=" + getNom() + ", villeDepart=" + getVilleDepart() + ", villeArrivee=" + getVilleArrivee() +
               ", voiture=" + voiture + ", distance totale : " + calculerDistanceTotale() + " km" + ", note moyenne : " + calculerNoteMoyenne() + "]";
    }


        /*
        return "Conducteur [nom=" + nom + ", villeDepart=" + villeDepart + ", villeArrivee=" + villeArrivee
                + ", trajets=" + trajets + ", voiture=" + voiture + calculerDistanceTotale() + "]";
    }*/





    





   


















    
}
