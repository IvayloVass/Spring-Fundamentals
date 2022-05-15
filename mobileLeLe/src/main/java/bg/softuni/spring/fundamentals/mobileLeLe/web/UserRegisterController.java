package bg.softuni.spring.fundamentals.mobileLeLe.web;


import bg.softuni.spring.fundamentals.mobileLeLe.models.binding.UserRegisterBindingDto;
import bg.softuni.spring.fundamentals.mobileLeLe.models.dtos.UserRegisterDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserRegisterController {

    @GetMapping("/register")
    public String openRegisterPage() {
        return "auth-register";
    }

    @PostMapping("/register")
    public String registerUser(UserRegisterBindingDto userRegisterBindingDto) {
        //ToDo
        UserRegisterDto userRegisterDto = new UserRegisterDto();
        userRegisterDto.setFirstName(userRegisterBindingDto.getFirstName());
        userRegisterDto.setLastName(userRegisterBindingDto.getLastName());
        userRegisterDto.setUsername(userRegisterBindingDto.getUsername());
        userRegisterDto.setPassword(userRegisterBindingDto.getPassword());
        userRegisterDto.setRoles(userRegisterBindingDto.getRoles());

        return "redirect:/";
    }
}
