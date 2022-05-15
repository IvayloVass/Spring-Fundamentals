package bg.softuni.spring.fundamentals.mobileLeLe.services.impl;

import bg.softuni.spring.fundamentals.mobileLeLe.models.entities.Model;
import bg.softuni.spring.fundamentals.mobileLeLe.models.entities.enums.Category;
import bg.softuni.spring.fundamentals.mobileLeLe.repositories.BrandRepository;
import bg.softuni.spring.fundamentals.mobileLeLe.repositories.ModelRepository;
import bg.softuni.spring.fundamentals.mobileLeLe.services.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;

    @Autowired
    public ModelServiceImpl(ModelRepository modelRepository, BrandRepository brandRepository) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
    }

    @Override
    public void persistModel() {
        if (modelRepository.count() == 0) {
            Model cx30 = new Model("cx-30", Category.CAR, 2010, LocalDateTime.now());
            cx30.setBrand(brandRepository.findByName("mazda"));
            Model mx5 = new Model("mx-5", Category.CAR, 2010, LocalDateTime.of(1980, 11, 1, 12, 30));
            mx5.setBrand(brandRepository.findByName("mazda"));
            modelRepository.save(cx30);
            modelRepository.save(mx5);
        }

    }
}
