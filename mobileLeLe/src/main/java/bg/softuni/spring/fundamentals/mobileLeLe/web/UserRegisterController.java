package bg.softuni.spring.fundamentals.mobileLeLe.web;


import bg.softuni.spring.fundamentals.mobileLeLe.models.binding.UserRegisterBindingDto;
import bg.softuni.spring.fundamentals.mobileLeLe.models.dtos.UserRegisterDto;
import bg.softuni.spring.fundamentals.mobileLeLe.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserRegisterController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserRegisterController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/register")
    public String openRegisterPage() {
        return "auth-register";
    }

    @PostMapping("/register")
    public String registerUser(UserRegisterBindingDto userRegisterBindingDto) {
        //ToDo validation

        UserRegisterDto userRegisterDto = modelMapper.map(userRegisterBindingDto, UserRegisterDto.class);
        userService. registerAndLoginUser(userRegisterDto);

        return "redirect:/";
    }
}
