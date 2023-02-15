package bibliotheque;

import java.time.LocalDate;

public class Gestion {
    public static void main(String[] args) {
        //test
        Auteur a = new Auteur("Verne","Jules","France");
        Livre l = new Livre("Vingt mille lieues sous les mers",10, LocalDate.of(1880,1,1),1.50,"français","aventure","a125",350,TypeLivre.ROMAN,"histoire de sous-marin");
        a.getLouvrage().add(l);
        l.getLauteurs().add(a);
        Rayon r = new Rayon("r12","aventure");
        Exemplaire e = new Exemplaire("m12","état neuf",l);
        e.setRayon(r);
        r.getLex().add(e);
        Lecteur lec = new Lecteur(1,"Dupont","Jean",LocalDate.of(2000,1,4),"Mons","jean.dupont@mail.com","0458774411");
        Location loc = new Location(LocalDate.of(2023,2,1),LocalDate.of(2023,3,1),lec,e);
        lec.getLloc().add(loc);
        e.getLloc().add(loc);
        System.out.println(a);
        System.out.println(l);
        System.out.println(r);
        System.out.println(e);
        System.out.println(lec);
        System.out.println(loc);

    }
}