package fr.covoiturage;

/**
 * Interface représentant un objet évaluable, c'est-à-dire un objet auquel
 * les utilisateurs peuvent attribuer des notes.
 */
public interface Evaluable {

    /**
     * Ajoute une note à cet objet évaluable.
     *
     * @param utilisateur l'utilisateur qui attribue la note
     * @param note la note attribuée, généralement comprise entre 1 et 5
     */
    void ajouterNote(Utilisateur utilisateur, int note);

    /**
     * Calcule et retourne la note moyenne attribuée à cet objet évaluable.
     *
     * @return la note moyenne
     */
    double calculerNoteMoyenne();
}
