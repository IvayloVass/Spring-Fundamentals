package bg.softuni.spring.fundamentals.mobileLeLe.services.impl;

import bg.softuni.spring.fundamentals.mobileLeLe.models.entities.Brand;
import bg.softuni.spring.fundamentals.mobileLeLe.repositories.BrandRepository;
import bg.softuni.spring.fundamentals.mobileLeLe.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    @Autowired
    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public void persistBrand() {

        if (brandRepository.count() == 0) {
            Brand mazda = new Brand("mazda", LocalDateTime.now());
            brandRepository.save(mazda);
        }

    }
}
