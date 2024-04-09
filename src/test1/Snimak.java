package test1;

public class Snimak {
    private String name;
    private TipSnimka tip;
    private int length; // u minutima

    public Snimak(String name, TipSnimka tip, int length){
        this.name = name;
        this.tip = tip;
        this.length = length;
    }

    public String getName() { return name; }
    public TipSnimka getTip() { return tip; }
    public int getLength() { return length; }

    @Override
    public String toString(){
        return "Snimak { name = '" + name + "', tip = " + tip + ", lenght = " + length + " }";
    }
}
