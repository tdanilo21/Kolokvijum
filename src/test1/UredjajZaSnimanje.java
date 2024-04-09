package test1;

public abstract class UredjajZaSnimanje {
    protected String proizvodjac;
    protected Nastavnik vlasnik;
    protected SnimakUToku snimakUToku;

    public UredjajZaSnimanje(String proizvodjac, Nastavnik vlasnik){
        this.proizvodjac = proizvodjac;
        this.vlasnik = vlasnik;
        vlasnik.dodajUredjaj(this);
    }

    public boolean Snima(){
        return this.snimakUToku != null;
    }
    public abstract void pocniSnimanje(int time);
    public Snimak zavrsiSnimanje(String name, int time){
        if (this.snimakUToku == null)
            return null;
        Snimak snimak = new Snimak(name, this.snimakUToku.getTip(), time - this.snimakUToku.getVremePocetka());
        this.snimakUToku = null;
        return snimak;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass())
            return false;
        UredjajZaSnimanje uredjaj = (UredjajZaSnimanje)o;
        return this.proizvodjac.equals(uredjaj.proizvodjac)
                && this.vlasnik.equals(uredjaj.vlasnik);
    }
}
