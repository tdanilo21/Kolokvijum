package test1;

public class Kamera extends UredjajZaSnimanje {
    public Kamera(String proizvodjac, Nastavnik vlasnik){
        super(proizvodjac, vlasnik);
    }

    @Override
    public void pocniSnimanje(int time){
        this.snimakUToku = new SnimakUToku(TipSnimka.VIDEO, time);
    }
}
