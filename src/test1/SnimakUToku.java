package test1;

public class SnimakUToku {
    private TipSnimka tip;
    private int vremePocetka; // u minutima

    public SnimakUToku(TipSnimka tip, int vremePocetka){
        this.tip = tip;
        this.vremePocetka = vremePocetka;
    }

    public TipSnimka getTip() { return tip; }
    public int getVremePocetka() { return vremePocetka; }
}
