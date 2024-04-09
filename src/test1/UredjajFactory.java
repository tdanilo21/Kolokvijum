package test1;

public class UredjajFactory {
    public static UredjajZaSnimanje create(String proizvodjac, TipUredjaja tip, Nastavnik vlasnik){
        switch (tip){
            case MIKROFON:
                return new Mikrofon(proizvodjac, vlasnik);
            case KAMERA:
                return new Kamera(proizvodjac, vlasnik);
            default:
                return null;
        }
    }
}
