import java.util.*;

public class Shop{

    private static List<User> users = new ArrayList<>();
    private static List<Product> products = new ArrayList<>();
    private static List<Offer> offers = new ArrayList<>();

    private static User currentUser = null;


    private static void authUser(String username, String password){
        for(User u : Shop.users){
            if(u.getUsername().equals(username.trim()) && u.getPassword().equals(password.trim())){
                Shop.currentUser = u;
                System.out.println("[+] User - " + u.getUsername() + " login success");
                return;
            }
        }
        Errors.userLoginInvalidError();
        //System.out.println(Errors.userLoginInvalidError);
    }

    private static void authUser(User user){
        String username = user.getUsername().trim();
        String pass = user.getPassword().trim();
        for(User u : Shop.users){
            if(u.getUsername().equals(username) && u.getPassword().equals(pass)){
                Shop.currentUser = u;
                return;
            }
        }
        Errors.userLoginInvalidError();
    }

    private static boolean addNewUser(User user){
        for(User u : users){
            if(u.getUsername().equals(user.getUsername())){
                System.out.println(Errors.userAlreadyExistsError);
                return false;
            }
        }
        users.add(user);
        return true;
    }

    // user properties
    private static void printTransactionHistory(){
        if(Shop.currentUser != null){
            List<Double> history = Shop.currentUser.getHistory();
            System.out.println("[+] Transaction history for user - " + Shop.currentUser.getUsername());
            for(double d : history){
                System.out.println("Rs. " + d);
            }
        }else{
            System.out.println(Errors.invalidFuncCallError);
        }
    }
    private static double calculateTotalBill(){
        if(Shop.currentUser == null){
            System.out.println(Errors.userLoginInvalidError);
            return 0;
        }else{
            return Shop.currentUser.calculateTotalBill();
        }
    }
    private static void printCart(){
        if(Shop.currentUser == null){
            System.out.println(Errors.userLoginInvalidError);
            return;
        }
        List<Product> cart = Shop.currentUser.getCart();
        System.out.println("[+] User - " + Shop.currentUser.getUsername() + ", Shopping cart");
        for(Product p : cart){
            System.out.println(p);
        }
    }

    private static void applyOffer(Offer offer){

    }

    private static boolean removeFromCart(Product product){
        if(Shop.currentUser == null){
            System.out.println(Errors.userLoginInvalidError);
            return false;
        }
        return Shop.currentUser.removeFromCart(product);
    }
    private static boolean addToCart(Product product){
        if(Shop.currentUser == null){
            System.out.println(Errors.userLoginInvalidError);
            return false;
        }
        return Shop.currentUser.addToCart(product);
    }

    // admin properties
    private static boolean newProduct(Product product){
        String userType = Shop.currentUser.getUserType();
        if(userType.equals("Admin")){
            Shop.products.add(product);
            return true;
        }
        System.out.println(Errors.invalidFuncCallError);
        System.out.println(Errors.nonAdminUserError);
        return false;
    }
    private static boolean deleteProdcut(Product product){
        String userType = Shop.currentUser.getUserType();
        if(userType.equals("Admin")){
            Shop.products.remove(product);
            return true;
        }
        System.out.println(Errors.invalidFuncCallError);
        Errors.nonAdminUserError();
        return false;
    }
    private static boolean newOffer(Offer offer){
        String userType = Shop.currentUser.getUserType();
        if(userType.equals("Admin")){
            Shop.offers.add(offer);
            return true;
        }
        Errors.invalidFuncCallError();
        Errors.nonAdminUserError();
        return false;
    }

    public static void main(String[] args){

        // add dummy data to the database
        User user = new User("user1", "pass1");
        User user2 = new User("user2", "pass2");
        User adminUser = new User("admin", "Admin!");


        if(!Shop.addNewUser(user)) {
            Errors.userAlreadyExistsError();
            //System.out.println("[!] Username already exists user another username.");
            return;
        }
        if(!Shop.addNewUser(adminUser)){
            Errors.userAlreadyExistsError();
            return;
        }

        authUser(adminUser); //add admin user for adding products and offers in the shop...
        Product headset = new Product("Headset", 250);
        Product laptop = new Product("Laptop", 3000);
        Product mobile = new Product("Mobile", 3000);

        Shop.newProduct(headset);
        Shop.newProduct(laptop);

        authUser(user);
        Shop.newProduct(mobile); //should return error

        authUser("user2", "pass2"); //add user2



    }
}