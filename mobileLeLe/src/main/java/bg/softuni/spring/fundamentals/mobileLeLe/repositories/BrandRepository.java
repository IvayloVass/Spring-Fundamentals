package bg.softuni.spring.fundamentals.mobileLeLe.repositories;

import bg.softuni.spring.fundamentals.mobileLeLe.models.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

    Brand findByName(String name);
}
