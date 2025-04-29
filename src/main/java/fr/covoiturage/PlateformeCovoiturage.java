package fr.covoiturage;

import java.util.ArrayList;
import java.util.List;

public class PlateformeCovoiturage {
    double totalTrajet;
    private ArrayList<Utilisateur> utilisateurs;
    private ArrayList<Trajet> trajets;
    private double moyenneDistance;
    private int distanceTotale;
    private int nbTrajetLong;
    private int nbTrajet;
    private double pourcenTrajetLong;
    private double dureeTotale;
    private double vitesseMoyenneGlobale;

    public PlateformeCovoiturage(double moyenneDistance, int distanceTotale) {
        this.utilisateurs = new ArrayList<>();
        this.trajets = new ArrayList<>();
        this.moyenneDistance = moyenneDistance;
        this.distanceTotale = distanceTotale;
        this.dureeTotale = 0;
        this.vitesseMoyenneGlobale = 0;
    }

    
    // Constructeur sans paramètres
    public PlateformeCovoiturage() {
        this.utilisateurs = new ArrayList<>();
        this.trajets = new ArrayList<>();
        this.moyenneDistance = 0;
        this.distanceTotale = 0;
    }

    public ArrayList<Utilisateur> getListeUtilisateurs() {
        return utilisateurs;
    }
    public void setListeUtilisateurs(ArrayList<Utilisateur> listeUtilisateur) {
        this.utilisateurs = listeUtilisateur;
    }

    public void afficherTrajets() {
        for (Trajet trajet : trajets) {
            System.out.println(trajet);
        }
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
        this.distanceTotale = 0; // Réinitialiser distanceTotale à chaque appel
    
        for (Trajet trajet : trajets) {
            nbTrajet++;
            this.distanceTotale += trajet.getDistance(); // Utiliser getDistance() pour accéder à la distance
            }
    
        if (nbTrajet == 0) {
            return 0; // Si aucun trajet, la distance moyenne est 0
        }
        this.moyenneDistance = (double) this.distanceTotale / nbTrajet; // Caster en double pour éviter la division entière
        return this.moyenneDistance;
    }


    public void triNoteConducteur(){
        System.out.println("l'utilisateur ");
    }    

    public void calculerPourcentageTrajetsLongs() {
        nbTrajet = 0; // Réinitialiser le nombre total de trajets
        nbTrajetLong = 0; // Réinitialiser le nombre de trajets longs

        for (Trajet trajet : trajets) {
            nbTrajet++;
            if (trajet.getDistance() > 300) {
                nbTrajetLong++;
            }
        }

        if (nbTrajet > 0) {
            pourcenTrajetLong = (nbTrajetLong * 100.0) / nbTrajet;
        } else {
            pourcenTrajetLong = 0; // Si aucun trajet, le pourcentage est 0
        }
    }


    public void calculerVitesseMoyenneGlobale() {
        distanceTotale = 0;
        dureeTotale = 0; // Réinitialiser la durée totale à chaque appel

        for (Trajet trajet : trajets) {
            distanceTotale += trajet.getDistance();
            dureeTotale += trajet.getDuree(); // Utiliser getDuree() pour accéder à la durée
        }

        if (dureeTotale > 0) {
            vitesseMoyenneGlobale = distanceTotale / dureeTotale;
        } else {
            vitesseMoyenneGlobale = 0; // Si aucune durée, la vitesse moyenne est 0
        }
    }

    public void afficherStatistiques() {
        calculerMoyenneDistance(); // Calculer la moyenne des distances
        calculerPourcentageTrajetsLongs(); // Calculer le pourcentage de trajets longs
        calculerVitesseMoyenneGlobale(); // Calculer la vitesse moyenne globale
        System.out.println("Distance moyenne : " + moyenneDistance + " km");
        System.out.println("Pourcentage de trajets longs : " + pourcenTrajetLong + "%");
        System.out.println("Vitesse moyenne globale : " + vitesseMoyenneGlobale + " km/h");
    }

    public void trierConducteursParNote() {
        List<Conducteur> conducteurs = new ArrayList<>();
        for (Utilisateur utilisateur : utilisateurs) {
            if (utilisateur instanceof Conducteur) {
                conducteurs.add((Conducteur) utilisateur);
            }
        }

        // Tri manuel des conducteurs par note moyenne ascendante
        for (int i = 0; i < conducteurs.size(); i++) {
            for (int j = i + 1; j < conducteurs.size(); j++) {
                if (conducteurs.get(i).calculerNoteMoyenne() > conducteurs.get(j).calculerNoteMoyenne()) {
                    // Échange des conducteurs
                    Conducteur temp = conducteurs.get(i);
                    conducteurs.set(i, conducteurs.get(j));
                    conducteurs.set(j, temp);
                }
            }
        }

        // Affichage des conducteurs triés par note ascendante
        System.out.println("Conducteurs triés par note ascendante :");
        for (Conducteur conducteur : conducteurs) {
            System.out.println(conducteur);
        }
    }













}
