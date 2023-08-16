
public class Errors {
    public static String invalidFuncCallError = "[!] Invalid Function call";
    public static String userLoginInvalidError = "[!] Invalid credentials";
    public static String userAlreadyExistsError = "[!] Username already taken, Use different username";
    public static String nonAdminUserError = "[!] Only Admin user can perform the task.";

    public static void nonAdminUserError(){
        System.out.println("[!] Only Admin user can perform the task.");
    }

    public static void invalidFuncCallError(){
        System.out.println("[!] Invalid Function call");
    }

    public static void userLoginInvalidError(){
        System.out.println("[!] Invalid credentials");
    }

    public static void userAlreadyExistsError(){
        System.out.println("[!] Username already taken, Use different username");
    }
}