package bg.softuni.spring.fundamentals.mobileLeLe.models.binding;

import bg.softuni.spring.fundamentals.mobileLeLe.models.validation.UniqueUsername;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserRegisterBindingDto {

    @NotEmpty(message = "First name should be provided")
    @Size(min = 4, max = 20)
    private String firstName;

    @NotEmpty(message = "Last name should be provided")
    @Size(min = 4, max = 20)
    private String lastName;

    @NotEmpty(message = "Username should be provided")
    @Size(min = 4, max = 20)
    @UniqueUsername
    private String username;

    @NotEmpty(message = "Password should be provided")
    @Size(min = 5, max = 20)
    private String password;

    public UserRegisterBindingDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username != null ? username.trim() : null;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
