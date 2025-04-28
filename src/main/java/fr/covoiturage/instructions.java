package fr.covoiturage;
/* package fr.magic.covoiturage;

public class instructions {

    TP Covoiturage

    Instructions 

Instructions

Le but est de développer un système de gestion de trajets pour une plateforme de covoiturage. 
L'application doit permettre de gérer des utilisateurs (conducteurs ou passagers), des trajets et de proposer des outils d'analyse (meilleur conducteur, trajet le plus long, etc.)

 
Les utilisateurs :-------------------------------------------------------------------------------------------------------------------------utilisateurs---------------

Nous avons sur cette plateforme des utilisateurs avec : 

    un nom, une ville de départ, une ville d'arrivee                                                                        ********************OK********************
    les getters setters, le constructeur et une méthode afficherProfil()                                                    ********************OK********************

Nos utilisateurs peuvent être différenciés en deux types/rôle : 

    les conducteurs : 
        ils ont une voiture, une liste de trajets                                                                           ********************OK********************
        méthodes : ajouter un trajet, calculer la distance totale parcourue                                                 ********************OK********************
    Les passagers :
        ils ont une liste de trajets suivi, leur destination préférée                                                       ********************OK********************
        méthodes : suivre un trajet, donner une note à un conducteur                                                        ********************OK********************

La classe Trajet------------------------------------------------------------------------------------------------------------------------------trajet------------------

Un trajet est défini par : 

    Départ, arrivée et distance (en km)                                                                                     ********************OK********************
    durée estimée                                                                                                           ********************OK********************
    conducteur                                                                                                              ********************OK********************
    liste de passager                                                                                                       ********************OK********************

On va rajouter les méthodes :

    ajouterPassager(Passager p) : empêche les doublons                                                                      ********************OK********************
    calculerVitesseMoyenne()                                                                                                ********************OK********************
    estLong() retourne vrai si la distance > 300km                                                                          ********************OK********************
    estRapide() retourne vrai si la vitesse moyenne > 100 km/h                                                              ********************OK********************

Gestion des trajets

Créer une classe PlateformeCovoiturage qui contient : ---------------------------------------------------------------------------------PlateformeCovoiturage----------

    une liste de tous les utilisateurs                                                                                      ********************OK********************
    une liste de tous les trajets                                                                                           ********************OK********************

Comme méthodes : 

    ajouterUtilisateur(Utilisateur u)                                                                                       ********************OK********************
    ajouterTrajet(Trajet t)                                                                                                 ********************OK********************
    rechercherTrajet(String villeDepart, String villeArrivee)                                                               ********************OK********************
    topConducteurs() : retourne les 3 conducteurs avec la plus grande distance totale parcourue                             ********************OK********************
    afficherStatistiques() qui affiche                                                                                      ------------------------------------------
        la moyenne des distances                                                                                            ********************OK********************
        le pourcentage de trajets longs                                                                                     ------------------------------------------
        la vitesse moyenne globale                                                                                          ------------------------------------------

Interface Evaluable  ------------------------------------------------------------------------------------------------------------------------Evaluable----------------

Ajouter une interface Evaluable qui contient les méthodes ajouterNote() et calculerNoteMoyenne().                           ********************OK********************

Le but est de donner la possibilité de noter tout objet notable (elle est donc implémentée par passager et conducteur)      ********************OK********************

A la suite de quoi on pourra rajouter dans la classe PlateformeCovoiturage une méthode qui trie par note les conducteurs    ------------------------------------------


Ajout des tests (JUnit)-----------------------------------------------------------------------------------------------------------------test unitaires----------------

tester prioritairement  : 

    le bon ajout des passagers
    le calcul de la vitesse moyenne du trajet
    les statistiques globales de la plateforme

Vous pouvez rajouter plus de tests unitaires si vous le souhaitez.
Javadoc, Git

Pensez à ajouter la javadoc à votre code. -----------------------------------------------------------------------------------------------------JavaDoc----------------

Si vous voulez vous entrainer à utiliser Git vous pouvez déployer votre projet sur Git au début et "push" régulièrement vos avancées. 

 
Des idées pour aller encore plus loin (complètement facultatif)

Si vous voulez encore élargir ce projet vous pouvez : 

    implémenter un système de récompense pour les meilleurs conducteurs
    exporter les trajets en CSV (ça vous demandera un peu de recherche personnelle) -----------------------------------------------------------------------------------

N'hésitez pas à vous approprier le projet et à rajouter ce qui vous semble intéressant. 

}
 */