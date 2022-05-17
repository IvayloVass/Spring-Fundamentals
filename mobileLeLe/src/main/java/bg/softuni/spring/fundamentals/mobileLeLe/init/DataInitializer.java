package bg.softuni.spring.fundamentals.mobileLeLe.init;

import bg.softuni.spring.fundamentals.mobileLeLe.services.BrandService;
import bg.softuni.spring.fundamentals.mobileLeLe.services.ModelService;
import bg.softuni.spring.fundamentals.mobileLeLe.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataInitializer implements CommandLineRunner {

    private final UserService userService;
    private final BrandService brandService;
    private final ModelService modelService;

    @Autowired
    public DataInitializer(UserService userService, BrandService brandService, ModelService modelService) {
        this.userService = userService;
        this.brandService = brandService;
        this.modelService = modelService;
    }

    @Override
    public void run(String... args) {
        userService.persistUserAndRole();
        brandService.persistBrand();
        modelService.persistModel();
    }

}
