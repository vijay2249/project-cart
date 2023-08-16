import org.jetbrains.annotations.NotNull;

public class AdminUser {
    private final String userName = "admin";
    private final String password = "ADmin!";

    protected boolean checkIsAdmin(@NotNull String username, @NotNull String password){
        return this.userName.equals(username.trim()) && this.password.equals(password.trim());
    }
}
