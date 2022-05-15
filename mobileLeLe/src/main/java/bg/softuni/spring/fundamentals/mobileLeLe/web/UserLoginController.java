package bg.softuni.spring.fundamentals.mobileLeLe.web;

import bg.softuni.spring.fundamentals.mobileLeLe.models.dtos.UserLoginDto;
import bg.softuni.spring.fundamentals.mobileLeLe.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/users")
public class UserLoginController {

    private final UserService userService;

    @Autowired
    public UserLoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "auth-login";
    }

    @PostMapping("/login")
    public String submitLogin(@RequestParam String username, String password) {

        UserLoginDto userLoginDto = new UserLoginDto();
        userLoginDto.setUsername(username);
        //FixMe
        userLoginDto.setPassword(password);
        boolean loginSuccessful = userService.login(userLoginDto);

        if (loginSuccessful) {
            return "redirect:/";
        }

        return "redirect:/index";
    }
}
