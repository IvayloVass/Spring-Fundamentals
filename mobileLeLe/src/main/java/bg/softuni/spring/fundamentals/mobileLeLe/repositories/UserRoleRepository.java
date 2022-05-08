package bg.softuni.spring.fundamentals.mobileLeLe.repositories;

import bg.softuni.spring.fundamentals.mobileLeLe.models.entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}
