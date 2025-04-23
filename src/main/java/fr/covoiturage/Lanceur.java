package fr.covoiturage;

import java.util.ArrayList;
import java.util.List;

public class Lanceur {
    public static void main(String[] args) {
        Conducteur conducteur1 = new Conducteur("Robert", "Paris", "Lyon", 0, "4x4", 0);
        Conducteur conducteur2 = new Conducteur("Dédé", "Lille", "Lyon", 0, "4L", 0);
        Conducteur conducteur3 = new Conducteur("Alphonse", "Bordeaux", "Marseille", 0, "coccinelle", 0);
        Conducteur conducteur4 = new Conducteur("André", "Marseille", "Strasbourg", 0, "ford-T", 0);
        Passager pass1 = new Passager("aaaaa", "b", "c","d", 0);
        Passager pass2 = new Passager("bbbbb", "c", "d","e", 0);

        Trajet traj1 = new Trajet("Paris","Bordeaux", 587, 6.2291,"o");
        Trajet traj2 = new Trajet("Paris","Lille", 225, 2.4883,"o");
        Trajet traj3 = new Trajet("Paris","Lyon", 466, 4.843,"o");
        Trajet traj4 = new Trajet("Paris","Marseille", 773, 8.016,"o");
        Trajet traj5 = new Trajet("Paris","Strasbourg", 491, 5.2939,"o");
        Trajet traj6 = new Trajet("Lille","Bordeaux", 798, 8.4335,"o");
        Trajet traj7 = new Trajet("Lille","Lyon", 691, 7.3981,"o");
        Trajet traj8 = new Trajet("Lille","Marseille", 999, 10.6713,"o");
        Trajet traj9 = new Trajet("Lille","Strasbourg", 524, 5.6112,"o");
        Trajet traj10 = new Trajet("Bordeaux","Lyon", 554, 5.678,"o");
        Trajet traj11 = new Trajet("Bordeaux","Marseille", 645, 6.8303,"o");
        Trajet traj12 = new Trajet("Bordeaux","Strasbourg", 964, 10.4542,"o");
        Trajet traj13 = new Trajet("Lyon","Marseille", 313, 3.3233,"o");
        Trajet traj14 = new Trajet("Lyon","Strasbourg", 493, 5.3941,"o");
        Trajet traj15 = new Trajet("Marseille","Strasbourg", 800, 8.5671,"o");
        Trajet traj16 = new Trajet("Paris","Melun", 50, 0.8851,"o");

        PlateformeCovoiturage plateforme = new PlateformeCovoiturage();

        plateforme.ajouterTrajet(traj1);
        plateforme.ajouterTrajet(traj2);
        plateforme.ajouterTrajet(traj3);
        plateforme.ajouterTrajet(traj4);
        plateforme.ajouterTrajet(traj5);
        plateforme.ajouterTrajet(traj6);
        plateforme.ajouterTrajet(traj7);
        plateforme.ajouterTrajet(traj8);
        plateforme.ajouterTrajet(traj9);
        plateforme.ajouterTrajet(traj10);
        plateforme.ajouterTrajet(traj11);
        plateforme.ajouterTrajet(traj12);
        plateforme.ajouterTrajet(traj13);
        plateforme.ajouterTrajet(traj14);
        plateforme.ajouterTrajet(traj15);
        plateforme.ajouterTrajet(traj16);

        plateforme.ajouterUtilisateur(conducteur1);
        plateforme.ajouterUtilisateur(conducteur2);
        plateforme.ajouterUtilisateur(conducteur3);
        plateforme.ajouterUtilisateur(conducteur4);

        // Rechercher les trajets de "Lille" à "Lyon"
        List<Trajet> resultats = plateforme.rechercherTrajet("Lille", "Lyon");

        // Afficher les résultats
        for (Trajet trajet : resultats) {
            System.out.println(trajet);
        }

        conducteur1.ajouterTrajet(traj15);
        conducteur1.ajouterTrajet(traj3);
        conducteur2.ajouterTrajet(traj1);
        conducteur3.ajouterTrajet(traj7);
        conducteur4.ajouterTrajet(traj15);


        List<Conducteur> topConducteurs = plateforme.topConducteurs();

        System.out.println("Top 3 Conducteurs :");
        for (Conducteur conducteur : topConducteurs) {
            System.out.println(conducteur.getNom() + " : " + conducteur.calculerDistanceTotale() + " km");
        }


        //System.out.println(topConducteurs);


        /* List<Trajet> trajets = plateforme.getTrajets();

        System.out.println("Top 3 Conducteurs :");
        for (Conducteur conducteur : topConducteurs) {
            System.out.println(conducteur.getNom() + " : " + conducteur.calculerDistanceTotale() + " km");
        } */
       
        traj1.setConducteur("conducteur1");
        traj1.ajouterPassager(pass1);
        System.out.println(plateforme.rechercherTrajet("Paris", "Bordeaux"));
        System.out.println(conducteur4);
        plateforme.afficherStatistiques(conducteur4);
    }
}
