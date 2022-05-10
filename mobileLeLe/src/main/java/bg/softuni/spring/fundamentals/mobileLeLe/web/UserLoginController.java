package bg.softuni.spring.fundamentals.mobileLeLe.web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserLoginController {

    @GetMapping("/users/login")
    public String userLogin() {
        return "auth-login";
    }
}
