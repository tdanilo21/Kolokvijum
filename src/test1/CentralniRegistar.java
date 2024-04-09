package test1;
import java.util.ArrayList;
import java.util.List;

public class CentralniRegistar {
    private List<Sastanak> odrzaniSastanci = new ArrayList<Sastanak>();
    private List<Sastanak> zakazaniSastanci = new ArrayList<Sastanak>();
    private static CentralniRegistar instance;

    private CentralniRegistar(){}

    public static CentralniRegistar getInstance(){
        if (CentralniRegistar.instance == null)
            CentralniRegistar.instance = new CentralniRegistar();
        return CentralniRegistar.instance;
    }

    public void zakaziSastanak(Sastanak sastanak){
        zakazaniSastanci.add(sastanak);
    }

    public void otkaziSastanak(Sastanak sastanak){
        zakazaniSastanci.remove(sastanak);
    }

    public void pokreniSastanak(Sastanak sastanak, Nastavnik domacin){
        if (domacin.equals(sastanak.getDomacin()) && this.zakazaniSastanci.contains(sastanak) && !sastanak.isAktivan())
            sastanak.setAktivan(true);
    }

    public void zavrsiSastanak(Sastanak sastanak, Nastavnik domacin){
        if (domacin.equals(sastanak.getDomacin()) && this.zakazaniSastanci.contains(sastanak) && sastanak.isAktivan()){
            sastanak.setAktivan(false);
            this.zakazaniSastanci.remove(sastanak);
            sastanak.zavrsiSvaSnimanja(sastanak.getSatZavrsetka() * 60);
            this.odrzaniSastanci.add(sastanak);
        }
    }

    public void stampajPrisustvoSortirano(){

    }
}
