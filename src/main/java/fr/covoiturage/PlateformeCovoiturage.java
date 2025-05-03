package fr.covoiturage;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe représentant une plateforme de covoiturage.
 * Cette classe gère les utilisateurs, les trajets, et fournit diverses fonctionnalités
 * telles que la recherche de trajets, le calcul de statistiques, etc.
 */
public class PlateformeCovoiturage {
    double totalTrajet;
    private ArrayList<Utilisateur> utilisateurs;
    private ArrayList<Trajet> trajets;
    private double moyenneDistance;
    private int distanceTotale;
    private double pourcenTrajetLong;
    private double dureeTotale;
    private double vitesseMoyenneGlobale;

    /**
     * Constructeur pour créer une nouvelle plateforme de covoiturage avec une distance moyenne et une distance totale spécifiées.
     *
     * @param moyenneDistance la distance moyenne des trajets
     * @param distanceTotale la distance totale des trajets
     */
    public PlateformeCovoiturage(double moyenneDistance, int distanceTotale) {
        this.utilisateurs = new ArrayList<>();
        this.trajets = new ArrayList<>();
        this.moyenneDistance = moyenneDistance;
        this.distanceTotale = distanceTotale;
        this.dureeTotale = 0;
        this.vitesseMoyenneGlobale = 0;
    }

    /**
     * Constructeur sans paramètres pour créer une nouvelle plateforme de covoiturage.
     */
    public PlateformeCovoiturage() {
        this.utilisateurs = new ArrayList<>();
        this.trajets = new ArrayList<>();
        this.moyenneDistance = 0;
        this.distanceTotale = 0;
    }

    /**
     * Retourne la liste des utilisateurs de la plateforme.
     *
     * @return la liste des utilisateurs
     */
    public ArrayList<Utilisateur> getListeUtilisateurs() {
        return utilisateurs;
    }

    /**
     * Définit la liste des utilisateurs de la plateforme.
     *
     * @param listeUtilisateur la nouvelle liste des utilisateurs
     */
    public void setListeUtilisateurs(ArrayList<Utilisateur> listeUtilisateur) {
        this.utilisateurs = listeUtilisateur;
    }

    /**
     * Affiche tous les trajets de la plateforme.
     */
    public void afficherTrajets() {
        for (Trajet trajet : trajets) {
            System.out.println(trajet);
        }
    }

    /**
     * Définit la liste des trajets de la plateforme.
     *
     * @param trajets la nouvelle liste des trajets
     */
    public void setTrajets(ArrayList<Trajet> trajets) {
        this.trajets = trajets;
    }
    /**
    * Retourne la liste des trajets enregistrés sur la plateforme.
     *
    * @return une liste contenant tous les trajets enregistrés sur la plateforme
    */
    public ArrayList<Trajet> getTrajets() {
        return trajets;
    }

    /**
     * Ajoute un utilisateur à la plateforme.
     *
     * @param utilisateur l'utilisateur à ajouter
     */
    public void ajouterUtilisateur(Utilisateur utilisateur) {
        utilisateurs.add(utilisateur);
    }

    /**
     * Ajoute un trajet à la plateforme.
     *
     * @param trajet le trajet à ajouter
     */
    public void ajouterTrajet(Trajet trajet) {
        trajets.add(trajet);
    }

    /**
     * Recherche des trajets entre une ville de départ et une ville d'arrivée.
     *
     * @param villeDepart la ville de départ
     * @param villeArrivee la ville d'arrivée
     * @return la liste des trajets correspondants
     */
    public List<Trajet> rechercherTrajet(String villeDepart, String villeArrivee) {
        List<Trajet> resultats = new ArrayList<>();
        for (Trajet trajet : trajets) {
            if (trajet.getDepart().equalsIgnoreCase(villeDepart) && trajet.getArrivee().equalsIgnoreCase(villeArrivee)) {
                resultats.add(trajet);
            }
        }
        return resultats;
    }
    

    /**
     * Retourne la liste des trois meilleurs conducteurs en fonction de la distance totale parcourue.
     *
     * @return la liste des trois meilleurs conducteurs
     */
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
    


    /**
     * Calcule la distance moyenne des trajets.
     *
     * @return la distance moyenne des trajets
     */
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

   

    /**
     * Calcule le pourcentage de trajets longs (distance > 300 km).
     */
    public void calculerPourcentageTrajetsLongs() {
        int nbTrajet = 0; // Déclarer comme variable locale
        int nbTrajetLong = 0; // Déclarer comme variable locale
    
        for (Trajet trajet : trajets) {
            nbTrajet++;
            if (trajet.getDistance() > 300) {
                nbTrajetLong++;
            }
        }
    
        System.out.println("Nombre total de trajets : " + nbTrajet);
        System.out.println("Nombre de trajets longs : " + nbTrajetLong);
    
        if (nbTrajet > 0) {
            pourcenTrajetLong = (nbTrajetLong * 100.0) / nbTrajet;
        } else {
            pourcenTrajetLong = 0; // Si aucun trajet, le pourcentage est 0
        }
    
        System.out.println("Pourcentage de trajets longs : " + pourcenTrajetLong);
    }
    
    
    
    
    
    

    /**
     * Calcule la vitesse moyenne globale des trajets.
     */
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

    /**
     * Retourne le pourcentage de trajets longs (distance > 300 km).
     *
     * @return le pourcentage de trajets longs
     */
    public double getPourcenTrajetLong() {
        return pourcenTrajetLong;
    }

    /**
     * Retourne la vitesse moyenne globale des trajets.
     *
     * @return la vitesse moyenne globale
     */
    public double getVitesseMoyenneGlobale() {
        return vitesseMoyenneGlobale;
    }

    /**
     * Affiche les statistiques de la plateforme, telles que la distance moyenne,
     * le pourcentage de trajets longs, et la vitesse moyenne globale.
     */
    public void afficherStatistiques() {
        calculerMoyenneDistance(); // Calculer la moyenne des distances
        calculerPourcentageTrajetsLongs(); // Calculer le pourcentage de trajets longs
        calculerVitesseMoyenneGlobale(); // Calculer la vitesse moyenne globale
        System.out.println("Distance moyenne : " + moyenneDistance + " km");
        System.out.println("Pourcentage de trajets longs : " + pourcenTrajetLong + "%");
        System.out.println("Vitesse moyenne globale : " + vitesseMoyenneGlobale + " km/h");
    }

    /**
     * Trie les conducteurs par note moyenne ascendante et affiche la liste triée.
     */
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
