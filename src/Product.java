//import java.util.*;

public class Product{
    private static int idCount = 1;
    private String name;
    private double price;
    private final int id;

    Product(String name, double price){
        this.name = name;
        this.price = price;
        this.id = idCount++;
    }

    public String getName(){ return this.name; }
    public double getPrice(){ return this.price; }
    public int getId(){ return this.id; }

    // check for UnknownError
    public boolean setName(String name){
        if( name.trim().isEmpty()) return false;
        this.name = name;
        return true;
    }

    public boolean setPrice(double price){
        if(price > 0) {
            this.price = price;
            return true;
        }
        return false;
    }
}