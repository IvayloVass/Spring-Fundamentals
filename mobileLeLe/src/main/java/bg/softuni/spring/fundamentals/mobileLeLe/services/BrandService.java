package bg.softuni.spring.fundamentals.mobileLeLe.services;


import bg.softuni.spring.fundamentals.mobileLeLe.models.entities.Brand;

import java.util.List;

public interface BrandService {

    void persistBrand();

    List<Brand> getAllBrands();
}
