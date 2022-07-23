package bg.softuni.spring.fundamentals.mobileLeLe.web;


import bg.softuni.spring.fundamentals.mobileLeLe.models.binding.UserRegisterBindingDto;
import bg.softuni.spring.fundamentals.mobileLeLe.models.dtos.UserRegisterDto;
import bg.softuni.spring.fundamentals.mobileLeLe.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserAuthController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserAuthController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/login")
    public String login() {
        return "auth-login";
    }

    @PostMapping("/login-error")
    public String onFailedLogin(@ModelAttribute("username") String username,
                                RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("username", username)
                .addFlashAttribute("bad_credentials", true);
        return "redirect:/users/login";
    }

    @PostMapping("/logout")
    public String logout() {
        return "redirect:/";
    }

    @ModelAttribute("userRegisterBindingDto")
    public UserRegisterBindingDto userRegisterBindingDto() {
        return new UserRegisterBindingDto();
    }

    @GetMapping("/register")
    public String openRegisterPage() {
        return "auth-register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid UserRegisterBindingDto userRegisterBindingDto
            , BindingResult bindingResult
            , RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRegisterBindingDto", userRegisterBindingDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingDto",
                    bindingResult);
            return "redirect:/users/register";
        }
/**
 Optional<User> registeredUser = userService.findByUsername(userRegisterBindingDto.getUsername());

 if (registeredUser.isPresent()) {
 redirectAttributes.addFlashAttribute("userRegisterBindingDto", userRegisterBindingDto);
 redirectAttributes.addFlashAttribute("isOccupied", true);
 return "redirect:/users/register";
 }
 **/
        UserRegisterDto userRegisterDto = modelMapper.map(userRegisterBindingDto, UserRegisterDto.class);
        userService.registerAndLoginUser(userRegisterDto);

        return "redirect:/";
    }
}
