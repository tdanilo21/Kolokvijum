package test1;
import java.util.ArrayList;
import java.util.List;

public class Nastavnik extends UcesnikSastanka {
    private List<UredjajZaSnimanje> uredjaji = new ArrayList<UredjajZaSnimanje>();

    public Nastavnik(String username){
        super(username);
    }

    public void dodajUredjaj(UredjajZaSnimanje uredjaj){
        this.uredjaji.add(uredjaj);
    }
    public void ukloniUredjaj(UredjajZaSnimanje uredjaj){
        this.uredjaji.remove(uredjaj);
    }
    public List<UredjajZaSnimanje> getUredjaji(){ return this.uredjaji; }
}
