package bg.softuni.spring.fundamentals.mobileLeLe.web;

import bg.softuni.spring.fundamentals.mobileLeLe.models.binding.UserLoginBindingDto;
import bg.softuni.spring.fundamentals.mobileLeLe.models.dtos.UserLoginDto;
import bg.softuni.spring.fundamentals.mobileLeLe.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserLoginController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public UserLoginController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/login")
    public String login() {
        return "auth-login";
    }

    @PostMapping("/login")
    public String submitLogin(UserLoginBindingDto userLoginBindingDto) {

        UserLoginDto userLoginDto = modelMapper.map(userLoginBindingDto, UserLoginDto.class);

        boolean loginSuccessful = userService.login(userLoginDto);

        if (loginSuccessful) {
            return "redirect:/";
        }

        return "redirect:/index";
    }
}
