package bg.softuni.spring.fundamentals.mobileLeLe.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("/")
    public ModelAndView homePage(ModelAndView mav) {
        mav.setViewName("index");
        return mav;
    }
}
