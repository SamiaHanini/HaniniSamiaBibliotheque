package bibliotheque.metier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Ouvrage {
    protected String titre;
    protected int ageMin;
    protected LocalDate dateParution;
    protected TypeOuvrage to;
    protected double prixLocation;
    protected String langue;
    protected String genre;

    protected List<bibliotheque.metier.Auteur> lauteurs=new ArrayList<>();
    protected List<bibliotheque.metier.Exemplaire> lex = new ArrayList<>();


    public Ouvrage(String titre, int ageMin, LocalDate dateParution, TypeOuvrage to, double prixLocation, String langue, String genre) {
        this.titre = titre;
        this.ageMin = ageMin;
        this.dateParution = dateParution;
        this.to = to;
        this.prixLocation = prixLocation;
        this.langue = langue;
        this.genre = genre;
    }



    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getAgeMin() {
        return ageMin;
    }

    public void setAgeMin(int ageMin) {
        this.ageMin = ageMin;
    }

    public LocalDate getDateParution() {
        return dateParution;
    }

    public void setDateParution(LocalDate dateParution) {
        this.dateParution = dateParution;
    }

    public TypeOuvrage getTo() {
        return to;
    }

    public void setTo(TypeOuvrage to) {
        this.to = to;
    }

    public double getPrixLocation() {
        return prixLocation;
    }

    public void setPrixLocation(double prixLocation) {
        this.prixLocation = prixLocation;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<bibliotheque.metier.Auteur> getLauteurs() {
        return lauteurs;
    }

    public void setLauteurs(List<bibliotheque.metier.Auteur> lauteurs) {
        this.lauteurs = lauteurs;
    }

    public List<bibliotheque.metier.Exemplaire> getLex() {
        return lex;
    }

    public void setLex(List<bibliotheque.metier.Exemplaire> lex) {
        this.lex = lex;
    }


    public abstract double amendeRetard(int njours);
    @Override
    public String toString() {
        return "Ouvrage{" +
                "titre='" + titre + '\'' +
                ", ageMin=" + ageMin +
                ", dateParution=" + dateParution +
                ", to=" + to +
                ", prixLocation=" + prixLocation +
                ", langue='" + langue + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
    public void addAuteur(bibliotheque.metier.Auteur a ){
        lauteurs.add(a);
        a.getLouvrage().add(this);
    }

    public void remove(bibliotheque.metier.Auteur a){
        lauteurs.remove(a);
        a.getLouvrage().remove(this);
    }
    public void addExemplaire(bibliotheque.metier.Exemplaire e){
        lex.add(e);
        e.setOuvrage(this);
    }

    public void remove(bibliotheque.metier.Exemplaire e){
        lex.remove(e);
        e.setOuvrage(null);
    }
    public List<bibliotheque.metier.Exemplaire>listerExemplaires(){
        //TODO lister exemplaires ouvrage
        return lex;
    }

    public List<bibliotheque.metier.Exemplaire>listerExemplaires(boolean enLocation){
        //TODO lister exemplaires ouvrage en location ou non
        //condition if dans boucle false or true
        return null;
    }
}
