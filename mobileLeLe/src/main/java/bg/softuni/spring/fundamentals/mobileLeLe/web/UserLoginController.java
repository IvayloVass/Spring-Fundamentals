package bg.softuni.spring.fundamentals.mobileLeLe.web;

import bg.softuni.spring.fundamentals.mobileLeLe.models.dtos.UserLoginDto;
import bg.softuni.spring.fundamentals.mobileLeLe.services.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserLoginController {

    private final UserServiceImpl userService;

    public UserLoginController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/users/login")
    public String login() {
        return "auth-login";
    }

    @PostMapping()
    public String login(UserLoginDto userLoginDto) {
        //ToDo
        return "redirect:/index";
    }
}
