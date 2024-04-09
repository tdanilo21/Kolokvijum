package test1;
import java.util.ArrayList;
import java.util.List;

public class Sastanak {
    private String predmet;
    private int satPocetka;
    private int satZavrsetka;
    private boolean aktivan;
    private List<UcesnikSastanka> ucesnici = new ArrayList<UcesnikSastanka>();
    private Nastavnik domacin;
    private List<Snimak> snimci = new ArrayList<Snimak>();

    public Sastanak(String predmet, int satPocetka, int satZavrsetka){
        this.predmet = predmet;
        this.satPocetka = satPocetka;
        this.satZavrsetka = satZavrsetka;
    }

    public String getPredmet() { return predmet; }
    public int getSatPocetka() { return satPocetka; }
    public int getSatZavrsetka() { return satZavrsetka; }
    public Nastavnik getDomacin() { return domacin; }
    public boolean isAktivan() { return aktivan; }
    public List<UcesnikSastanka> getUcesnici() { return ucesnici; }

    public void setDomacin(Nastavnik domacin) {
        this.ucesnici.remove(domacin);
        this.domacin = domacin;
    }
    public void setAktivan(boolean aktivan) { this.aktivan = aktivan; }

    public void dodajUcesnika(UcesnikSastanka ucesnik){
        if (this.ucesnici.contains(ucesnik))
            return;
        this.ucesnici.add(ucesnik);
    }
    public void ukloniUcesnika(UcesnikSastanka ucesnik){
        this.ucesnici.remove(ucesnik);
    }

    public void pocniSnimanje(UredjajZaSnimanje uredjaj, int time){
        if (this.aktivan && domacin.getUredjaji().contains(uredjaj))
            uredjaj.pocniSnimanje(time);
    }
    public void zavrsiSnimanje(UredjajZaSnimanje uredjaj, int time){
        if (uredjaj.Snima() && domacin.getUredjaji().contains(uredjaj))
            this.snimci.add(uredjaj.zavrsiSnimanje(this.predmet + this.satPocetka + "-" + this.satZavrsetka, time));
    }
    public void zavrsiSvaSnimanja(int time){
        for (UredjajZaSnimanje uredjaj : domacin.getUredjaji())
            zavrsiSnimanje(uredjaj, time);
    }

    public int compareTo(Sastanak sastanak){
        if (this.satPocetka == sastanak.satPocetka)
            return Integer.compare(this.satZavrsetka, sastanak.satZavrsetka);
        return Integer.compare(this.satPocetka, sastanak.satPocetka);
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass())
            return false;
        Sastanak sastanak = (Sastanak)o;
        return this.satPocetka == sastanak.satPocetka && this.satZavrsetka == sastanak.satZavrsetka;
    }

    @Override
    public String toString(){
        return "Sastanak { " +
                "predmet = '" + this.predmet + "', " +
                "satPocetka = " + this.satPocetka + ", " +
                "satZavrsetka = " + this.satZavrsetka + ", " +
                "aktivan = " + this.aktivan + ", " +
                "ucesnici = " + this.ucesnici + ", " +
                "domacin = " + this.domacin + ", " +
                "snimci = " + this.snimci + " }";
    }
}
