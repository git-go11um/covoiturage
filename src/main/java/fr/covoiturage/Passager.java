package fr.covoiturage;

import java.util.ArrayList;
import java.util.List;



public class Passager extends Utilisateur implements Evaluable{
    
    private ArrayList<Trajet> trajetsuivis;
    private String destPref = "";
    private List<Integer> notes;


    public Passager(String nom, String villeDepart, String villeArrivee, String destPref, int moyenneDistance) {
        super(nom, villeDepart, villeArrivee, moyenneDistance);
        this.destPref = destPref;
        this.trajetsuivis=new ArrayList<>();
        this.notes=new ArrayList<>();
    }


    @Override
    public String getNom() {
        return "Passager : " + super.getNom(); // Surcharge du getter
    }


    @Override
    public void setNom(String nom) {
        super.setNom(nom);
    }


    @Override
    public String getVilleDepart() {
        return "Ville de départ : " + super.getVilleDepart(); // Surcharge du getter
    }

    @Override
    public String getVilleArrivee() {
        return "Ville d'arrivée : " + super.getVilleArrivee(); // Surcharge du getter
    }


    public ArrayList<Trajet> getTrajetsuivis() {
        return trajetsuivis;
    }

    public String getDestPref() {
        return destPref;
    }
    public void setDestPref(String destPref) {
        this.destPref = destPref;
    }

    public void suivreTrajet(Trajet trajet){
        trajetsuivis.add(trajet);
    }

    @Override
    public void ajouterNote(int note) {
        notes.add(note);
    }

    @Override
    public double calculerNoteMoyenne() {
        return notes.stream().mapToInt(Integer::intValue).average().orElse(0);
    }

    @Override
    public void afficherProfil(){
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Passager [nom=" + nom + ", villeDepart=" + villeDepart + ", villeArrivee=" + villeArrivee
                + ", trajetsPassager=" + trajetsuivis + ", destPref=" + destPref + "]";
    }

    










    



    

}
