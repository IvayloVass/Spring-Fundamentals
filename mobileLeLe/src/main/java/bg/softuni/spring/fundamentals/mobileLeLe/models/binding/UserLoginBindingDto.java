package bg.softuni.spring.fundamentals.mobileLeLe.models.binding;

public class UserLoginBindingDto {

    private String username;

    private String rowPassword;

    public UserLoginBindingDto() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRowPassword() {
        return rowPassword;
    }

    public void setRowPassword(String rowPassword) {
        this.rowPassword = rowPassword;
    }
}
