package bg.softuni.spring.fundamentals.mobileLeLe.session;

import bg.softuni.spring.fundamentals.mobileLeLe.models.entities.enums.Role;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Component
@SessionScope
public class CurrentUser {

    private String username;
    private String firstName;
    private String lastName;
    private boolean isLoggedIn;
    private List<Role> roles;

    public CurrentUser() {
        this.roles = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public CurrentUser addRole(Role role) {
        roles.add(role);
        return this;
    }

    public boolean isAdmin() {
        return roles.contains(Role.ADMIN);
    }

    public void clearRoles() {
        this.roles.clear();
    }

    public void clear() {
        setLoggedIn(false);
        setUsername(null);
        setFirstName(null);
        setLastName(null);
        this.clearRoles();
    }

}
