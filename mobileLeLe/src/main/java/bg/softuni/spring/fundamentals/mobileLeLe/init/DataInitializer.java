package bg.softuni.spring.fundamentals.mobileLeLe.init;

import bg.softuni.spring.fundamentals.mobileLeLe.services.BrandService;
import bg.softuni.spring.fundamentals.mobileLeLe.services.ModelService;
import bg.softuni.spring.fundamentals.mobileLeLe.services.OfferService;
import bg.softuni.spring.fundamentals.mobileLeLe.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataInitializer implements CommandLineRunner {

    private final UserService userService;
    private final BrandService brandService;
    private final ModelService modelService;
    private final OfferService offerService;

    @Autowired
    public DataInitializer(UserService userService, BrandService brandService, ModelService modelService, OfferService offerService) {
        this.userService = userService;
        this.brandService = brandService;
        this.modelService = modelService;
        this.offerService = offerService;
    }

    @Override
    public void run(String... args) {
        userService.persistUserAndRole();
        brandService.persistBrand();
        modelService.persistModel();
        offerService.persistOffer();
    }

}
