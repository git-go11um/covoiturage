package fr.covoiturage;

import java.util.List;

/**
 * Classe principale pour lancer l'application de covoiturage.
 * Cette classe contient la méthode main qui initialise les objets et exécute les opérations principales.
 */
public class Lanceur {

    /**
     * Point d'entrée principal de l'application.
     *
     * @param args les arguments de la ligne de commande
     */
    public static void main(String[] args) {
        Conducteur conducteur1 = new Conducteur("Robert", "Paris", "Lyon", 0, "4x4", 0);
        Conducteur conducteur2 = new Conducteur("Dédé", "Lille", "Lyon", 0, "4L", 0);
        Conducteur conducteur3 = new Conducteur("Alphonse", "Bordeaux", "Marseille", 0, "coccinelle", 0);
        Conducteur conducteur4 = new Conducteur("André", "Marseille", "Strasbourg", 0, "ford-T", 0);
        Passager pass1 = new Passager("aaaaa", "b", "c","d", 0);
        Passager pass2 = new Passager("bbbbb", "c", "d","e", 0);

        Trajet traj1 = new Trajet("Paris","Bordeaux", 587, 6.2291,conducteur1,6);
        Trajet traj2 = new Trajet("Paris","Lille", 225, 2.4883,conducteur1,2);
        Trajet traj3 = new Trajet("Paris","Lyon", 466, 4.843,conducteur1,4);
        Trajet traj4 = new Trajet("Paris","Marseille", 773, 8.016,conducteur1,8);
        Trajet traj5 = new Trajet("Paris","Strasbourg", 491, 5.2939,conducteur1,5);
        Trajet traj6 = new Trajet("Lille","Bordeaux", 798, 8.4335,conducteur1,8);
        Trajet traj7 = new Trajet("Lille","Lyon", 691, 7.3981,conducteur1,7);
        Trajet traj8 = new Trajet("Lille","Marseille", 999, 10.6713,conducteur1,10);
        Trajet traj9 = new Trajet("Lille","Strasbourg", 524, 5.6112,conducteur1,5);
        Trajet traj10 = new Trajet("Bordeaux","Lyon", 554, 5.678,conducteur1,5);
        Trajet traj11 = new Trajet("Bordeaux","Marseille", 645, 6.8303,conducteur1,6);
        Trajet traj12 = new Trajet("Bordeaux","Strasbourg", 964, 10.4542,conducteur1,10);
        Trajet traj13 = new Trajet("Lyon","Marseille", 313, 3.3233,conducteur1,3);
        Trajet traj14 = new Trajet("Lyon","Strasbourg", 493, 5.3941,conducteur1,5);
        Trajet traj15 = new Trajet("Marseille","Strasbourg", 800, 8.5671,conducteur1,8);
        Trajet traj16 = new Trajet("Paris","Melun", 100, 0.8851,conducteur1,0.5);

        PlateformeCovoiturage plateforme = new PlateformeCovoiturage(0,0);

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

        plateforme.ajouterUtilisateur(pass1);
        plateforme.ajouterUtilisateur(pass2);

        List<Trajet> resultats = plateforme.rechercherTrajet("Lille", "Lyon");
        for (Trajet trajet : resultats) {
            System.out.println(trajet);
        }

        conducteur1.ajouterTrajet(traj15);
        conducteur1.ajouterTrajet(traj3);
        conducteur2.ajouterTrajet(traj1);
        conducteur3.ajouterTrajet(traj7);
        conducteur4.ajouterTrajet(traj1);
        conducteur4.ajouterTrajet(traj2);
        conducteur4.ajouterTrajet(traj3);

        List<Conducteur> topConducteurs = plateforme.topConducteurs();

        System.out.println("Top 3 Conducteurs :");
        for (Conducteur conducteur : topConducteurs) {
            System.out.println(conducteur.getNom() + " : " + conducteur.calculerDistanceTotale() + " km");
        }

        traj1.setConducteur(conducteur1);
        traj1.ajouterPassager(pass1);
        traj1.ajouterPassager(pass2); // Ajout d'un autre passager
        traj16.estRapide();
        System.out.println(plateforme.rechercherTrajet("Paris", "Bordeaux"));

        conducteur1.afficherProfil();
        pass1.afficherProfil(); // Affichage du profil du passager
        System.out.println(traj1.estLong());
        plateforme.afficherTrajets();
        pass1.suivreTrajet(plateforme, "Paris", "Lyon");
        pass1.ajouterNote(conducteur1, 12);
        pass1.ajouterNote(conducteur1, 14);
        pass1.ajouterNote(conducteur2, 5);
        pass1.ajouterNote(conducteur3, 9);
        pass1.ajouterNote(conducteur1, 18);

        System.out.println(conducteur1.calculerNoteMoyenne());
        System.out.println(conducteur1);
        conducteur1.ajouterNote(pass1, 7);
        System.out.println(pass1.calculerNoteMoyenne());

        plateforme.afficherStatistiques();

        plateforme.trierConducteursParNote();

        // Tests supplémentaires
        pass1.setNom("NouveauNom"); // Modification du nom du passager
        System.out.println("Nouveau nom du passager : " + pass1.getNom());

        conducteur1.setVilleDepart("NouvelleVilleDepart"); // Modification de la ville de départ du conducteur
        System.out.println("Nouvelle ville de départ du conducteur : " + conducteur1.getVilleDepart());

        System.out.println("Liste des trajets suivis par le passager : " + pass1.getTrajetSuivis());

        System.out.println("Distance totale parcourue par le conducteur : " + conducteur1.calculerDistanceTotale() + " km");
    }
}
