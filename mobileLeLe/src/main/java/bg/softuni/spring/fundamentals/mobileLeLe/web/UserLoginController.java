package bg.softuni.spring.fundamentals.mobileLeLe.web;

import bg.softuni.spring.fundamentals.mobileLeLe.models.binding.UserLoginBindingDto;
import bg.softuni.spring.fundamentals.mobileLeLe.models.dtos.UserLoginDto;
import bg.softuni.spring.fundamentals.mobileLeLe.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserLoginController {

    private final UserService userService;

    @Autowired
    public UserLoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/login")
    public String login() {
        return "auth-login";
    }

    @PostMapping("users/login")
    public String submitLogin(UserLoginBindingDto userLoginBindingDto) {

        UserLoginDto userLoginDto = new UserLoginDto();
        userLoginDto.setUsername(userLoginBindingDto.getUsername());
        //FixMe
        userLoginDto.setPassword(userLoginBindingDto.getRowPassword());
        boolean loginSuccessful = userService.login(userLoginDto);

        if (loginSuccessful) {
            return "redirect:/";
        }

        return "redirect:/index";
    }
}
