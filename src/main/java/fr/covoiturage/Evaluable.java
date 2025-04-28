package fr.covoiturage;

public interface Evaluable {

    void ajouterNote(Utilisateur utilisateur, int note);

    double calculerNoteMoyenne();


}
