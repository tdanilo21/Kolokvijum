import test1.*;

public class Main {
    public static void main(String[] args) {
        Nastavnik n1 = new Nastavnik("nas1");
        Nastavnik n2 = new Nastavnik("nas2");

        UredjajZaSnimanje k1 = UredjajFactory.create("Asus", TipUredjaja.KAMERA, n1);
        UredjajZaSnimanje k2 = UredjajFactory.create("Asus", TipUredjaja.KAMERA, n2);
        UredjajZaSnimanje k3 = UredjajFactory.create("Lenovo", TipUredjaja.KAMERA, n2);
        UredjajZaSnimanje m1 = UredjajFactory.create("Asus", TipUredjaja.MIKROFON, n1);
        UredjajZaSnimanje m2 = UredjajFactory.create("Asus", TipUredjaja.MIKROFON, n2);

        Student s1 = new Student("stud1");
        Student s2 = new Student("stud2");
        Student s3 = new Student("stud3");

        Sastanak sas1 = new Sastanak("p1", 11, 13);
        sas1.setDomacin(n1);
        sas1.dodajUcesnika(s1);
        sas1.dodajUcesnika(s2);
        sas1.dodajUcesnika(s3);
        Sastanak sas2 = new Sastanak("p2", 12, 14);
        sas2.setDomacin(n1);
        sas2.dodajUcesnika(s1);
        sas2.dodajUcesnika(s2);
        Sastanak sas3 = new Sastanak("p3", 11, 13);
        sas3.setDomacin(n2);
        sas3.dodajUcesnika(s2);
        sas3.dodajUcesnika(s3);

        CentralniRegistar registar = CentralniRegistar.getInstance();
        registar.zakaziSastanak(sas1);
        sas1.pocniSnimanje(k1, 11 * 60);
        registar.pokreniSastanak(sas1, n1);
        sas1.pocniSnimanje(k1, 11 * 60);
        sas1.pocniSnimanje(m1, 11*60);
        sas1.zavrsiSnimanje(k1, 12*60);
        registar.otkaziSastanak(sas2);
        registar.zavrsiSastanak(sas1, n2);
        registar.zavrsiSastanak(sas1, n1);
        registar.zavrsiSastanak(sas2, n2);

        System.out.println(sas1);
    }
}