import java.util.*;

public class User{

    //admin creds
    private final static String adminUsername = "admin";
    private final static String adminPass = "ADmin!";

    private final String username;
    private String password;
    private List<Product> cart;
    private List<Offer> offers;
    private List<Double> history;
    private boolean isAdmin = false;

    User(String username, String password){
        this.username = username;
        this.password = password;
        this.offers = new ArrayList<>();
        this.cart = new ArrayList<>();
        this.history = new ArrayList<>();
        this.checkAdmin();
    }

    public boolean auth(String username, String password){
        return this.username.equals(username.trim()) && this.password.equals(password.trim());
    }

    private void checkAdmin(){
        if(!this.isAdmin){
            if(this.username.equals(User.adminUsername) && this.password.equals(User.adminPass)){
                this.isAdmin = true;
            }
        }
    }

    public String getUsername(){ return this.username; }
    public String getPassword(){ return this.password; }
    public List<Product> getCart(){ return this.cart; }
    public List<Double> getHistory(){ return this.history; }
    public List<Offer> getOffers(){ return this.offers; }
    public String getUserType(){ return this.isAdmin? "User": "Admin"; }
    public double calculateTotalBill(){
        double amount = 0.0;
        for(Product p : this.cart){
            amount += p.getPrice();
        }
        return amount;
    }

    public boolean addToCart(Product product){
        if(product == null) return false;
        this.cart.add(product);
        return true;
    }

    // need to add couple more security checks...
    public boolean removeFromCart(Product product){
        if(product == null) return false;
        this.cart.remove(product);
        return true;
    }

    public boolean addOffer(Offer offer){
        if(offer == null) return false;
        this.offers.add(offer);
        return true;
    }

    public boolean removeFromOffer(Offer offer){
        if(offer == null) return false;
        this.offers.remove(offer);
        return true;
    }

    public boolean addTransaction(double amount){
        if(amount < 0) return false;
        this.history.add(amount);
        return true;
    }

    public boolean removeTransaction(double amount){
        return false;
    }
}



















