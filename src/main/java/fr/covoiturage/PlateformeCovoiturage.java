package fr.covoiturage;

import java.util.ArrayList;
import java.util.List;

public class PlateformeCovoiturage {
    ArrayList<Utilisateur> utilisateurs;
    ArrayList<Trajet> trajets;
    double moyenneDistance;
    int distanceTotale;

    public PlateformeCovoiturage() {
        this.utilisateurs = new ArrayList<>();
        this.trajets = new ArrayList<>();
    }

    public ArrayList<Utilisateur> getListeUtilisateurs() {
        return utilisateurs;
    }
    public void setListeUtilisateurs(ArrayList<Utilisateur> listeUtilisateur) {
        this.utilisateurs = listeUtilisateur;
    }

    public ArrayList<Trajet> getTrajets() {
        return trajets;
    }
    public void setTrajets(ArrayList<Trajet> trajets) {
        this.trajets = trajets;
    }

    public void ajouterUtilisateur(Utilisateur utilisateur){
        utilisateurs.add(utilisateur);
        }

    
    public void ajouterTrajet(Trajet trajet){
        trajets.add(trajet);
    }

    public List<Trajet> rechercherTrajet(String villeDepart, String villeArrivee) {
            List<Trajet> resultats = new ArrayList<>();
            for (Trajet trajet : trajets) {
                if (trajet.getDepart().equalsIgnoreCase(villeDepart) && trajet.getArrivee().equalsIgnoreCase(villeArrivee)) {
                    resultats.add(trajet);
                }
            }
            return resultats;
    }

    public List<Conducteur> topConducteurs() {
        List<Conducteur> conducteurs = new ArrayList<>();
        for (Utilisateur utilisateur : utilisateurs) {
            if (utilisateur instanceof Conducteur) {
                conducteurs.add((Conducteur) utilisateur);
            }
        }

        // Tri manuel des conducteurs par distance totale parcourue
        for (int i = 0; i < conducteurs.size(); i++) {
            for (int j = i + 1; j < conducteurs.size(); j++) {
                if (conducteurs.get(i).calculerDistanceTotale() < conducteurs.get(j).calculerDistanceTotale()) {
                    // Échange des conducteurs
                    Conducteur temp = conducteurs.get(i);
                    conducteurs.set(i, conducteurs.get(j));
                    conducteurs.set(j, temp);
                }
            }
        }

        // Sélection des trois meilleurs conducteurs
        List<Conducteur> top3Conducteurs = new ArrayList<>();
        int limite = Math.min(3, conducteurs.size());
        for (int i = 0; i < limite; i++) {
            top3Conducteurs.add(conducteurs.get(i));
        }
        return top3Conducteurs;
    }
        


    public double calculerMoyenneDistance() {
        int nbTrajet = 0;
        distanceTotale = 0; // Réinitialiser distanceTotale à chaque appel
    
        for (Trajet trajet : trajets) {
            nbTrajet++;
            distanceTotale += trajet.getDistance(); // Utiliser getDistance() pour accéder à la distance
        }
    
        if (nbTrajet == 0) {
            return 0; // Si aucun trajet, la distance moyenne est 0
        }
    
        moyenneDistance = (double) distanceTotale / nbTrajet; // Caster en double pour éviter la division entière
        return moyenneDistance;
    }

    public void afficherStatistiques(Conducteur conducteur){
        //System.out.println("l'utilisateur " + conducteur.getNom() + ", distance moyenne : " + getMoyenneDistance + ", " + trajetLong + "%, vitesse moyenne : "+ vitesseMoyenne);
        System.out.println("l'utilisateur " + conducteur.getNom() + ", distance moyenne : " + moyenneDistance);
    }
    public void triNoteConducteur(){
        System.out.println("l'utilisateur ");
    }    















}
