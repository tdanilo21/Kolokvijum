package test1;

public class Mikrofon extends UredjajZaSnimanje {
    public Mikrofon(String proizvodjac, Nastavnik vlasnik){
        super(proizvodjac, vlasnik);
    }

    @Override
    public void pocniSnimanje(int time){
        this.snimakUToku = new SnimakUToku(TipSnimka.AUDIO, time);
    }
}
