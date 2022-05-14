package bg.softuni.spring.fundamentals.mobileLeLe;

import bg.softuni.spring.fundamentals.mobileLeLe.models.entities.Brand;
import bg.softuni.spring.fundamentals.mobileLeLe.models.entities.Model;
import bg.softuni.spring.fundamentals.mobileLeLe.models.entities.User;
import bg.softuni.spring.fundamentals.mobileLeLe.models.entities.enums.Category;
import bg.softuni.spring.fundamentals.mobileLeLe.repositories.BrandRepository;
import bg.softuni.spring.fundamentals.mobileLeLe.repositories.ModelRepository;
import bg.softuni.spring.fundamentals.mobileLeLe.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataInitializer implements CommandLineRunner {

    private final BrandRepository brandRepository;
    private final ModelRepository modelRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public DataInitializer(BrandRepository brandRepository, ModelRepository modelRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.brandRepository = brandRepository;
        this.modelRepository = modelRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        persistBrandAndModel();
        persistUser();

    }

    private void persistUser() {
        if (userRepository.count() == 0) {
            User mitak = new User("super@duper", passwordEncoder.encode("secretPass"), "Mitak", "Petrov", LocalDateTime.now());
            mitak.setActive(true);
            userRepository.save(mitak);
        }
    }

    private void persistBrandAndModel() {
        if (brandRepository.count() == 0 & modelRepository.count() == 0) {
            Brand mazda = new Brand("mazda", LocalDateTime.now());
            Model cx30 = new Model("cx-30", Category.CAR, 2010, LocalDateTime.now());
            cx30.setBrand(mazda);
            Model mx5 = new Model("mx-5", Category.CAR, 2010, LocalDateTime.of(1980, 11, 1, 12, 30));
            mx5.setBrand(mazda);
            brandRepository.save(mazda);
            modelRepository.save(cx30);
            modelRepository.save(mx5);

        }
    }
}
