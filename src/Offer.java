public class Offer{
    private int id;
    private String name;
    private double discount;

    Offer(String name, double discount, int id){
        this.name = name;
        this.discount = discount;
        this.id = id;
    }

    public String getName(){ return this.name; }
    public double getDiscount(){ return this.discount; }

    public boolean setName(String name){
        if( name.trim().length() == 0) return false;
        this.name = name;
        return true;
    }
    public boolean setDiscount(double discount){
        if( discount < 0) return false;
        this.discount = discount;
        return true;
    }
}