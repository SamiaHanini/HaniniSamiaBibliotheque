package bibliotheque.metier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.time.LocalDateTime;

public class Exemplaire {

    private String matricule;
    private String descriptionEtat;

    private Ouvrage ouvrage;
    private Rayon rayon;

    private List<Location> lloc= new ArrayList<>();


    public Exemplaire(String matricule, String descriptionEtat,Ouvrage ouvrage) {
        this.matricule = matricule;
        this.descriptionEtat=descriptionEtat;
        this.ouvrage = ouvrage;
        this.ouvrage.getLex().add(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exemplaire that = (Exemplaire) o;
        return Objects.equals(matricule, that.matricule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricule);
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getDescriptionEtat() {
        return descriptionEtat;
    }

    public void setDescriptionEtat(String descriptionEtat) {
        this.descriptionEtat = descriptionEtat;
    }

    public Ouvrage getOuvrage() {
        return ouvrage;
    }

    public void setOuvrage(Ouvrage ouvrage) {
        if(this.ouvrage!=null) this.ouvrage.getLex().remove(this);
        this.ouvrage = ouvrage;
        this.ouvrage.getLex().add(this);
    }

    public Rayon getRayon() {
        return rayon;
    }

    public void setRayon(Rayon rayon) {
        if(this.rayon!=null) this.rayon.getLex().remove(this);
        this.rayon=rayon;
        this.rayon.getLex().add(this);
    }

    public List<Location> getLloc() {
        return lloc;
    }

    public void setLloc(List<Location> lloc) {
        this.lloc = lloc;
    }

    @Override
    public String toString() {
        return "Exemplaire{" +
                "matricule='" + matricule + '\'' +
                ", descriptionEtat='" + descriptionEtat + '\'' +
                ", ouvrage=" + ouvrage +
                ", rayon=" + rayon +
                '}';
    }


    public void modifierEtat(String etat){
        this.setDescriptionEtat(etat);
    }

    public Lecteur lecteurActuel(){

        List<Location> loca = new ArrayList<>();
        //dernière location de la liste qui n'a pas été restituté
        for(Location loc : lloc){

            if(loc.getDateRestitution().isBefore(LocalDate.now())){

                loca.add(loc);
            }
        }
        int last = loca.size();
        Lecteur lect = new Lecteur();
        Location locat = new Location();
        locat = loca.get(last-1);
        lect = locat.getLoueur();
        return lect;
    }

    public List<Lecteur> lecteurs(){
        List<Lecteur> lec = new ArrayList<>();
        for(Location loc : lloc){
           lec.add(loc.getLoueur());
        }
        return lec;
    }

    public void envoiMailLecteurActuel(Mail mail){
        //TODO envoi mail lecteur exemplaire
        //println du contenu du mail
        List<Location> loca = new ArrayList<>();
        //dernière location de la liste qui n'a pas été restituté
        for(Location loc : lloc){

            if(loc.getDateRestitution().isBefore(LocalDate.now())){

                loca.add(loc);
            }
        }
        int last = loca.size();
        Lecteur lect = new Lecteur();
        Location locat = new Location();
        locat = loca.get(last-1);
        lect = locat.getLoueur();
        return lect;
    }
    public void envoiMailLecteurs(Mail mail){
        //TODO envoi mail lecteurs exemplaire
        //println du contenu du mail

    }

    public boolean enRetard(){
        //TODO enretard exeplaire
        return false;
    }

    public int joursRetard(){
        //TODO jours retard exemplaire
        return 0;
    }


    public boolean enLocation(){
        //TODO en location exemplaires
        return false;
    }



}
