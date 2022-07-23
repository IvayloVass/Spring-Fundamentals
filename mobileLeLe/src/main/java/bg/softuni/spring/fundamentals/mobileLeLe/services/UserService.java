package bg.softuni.spring.fundamentals.mobileLeLe.services;
import bg.softuni.spring.fundamentals.mobileLeLe.models.dtos.UserRegisterDto;
import bg.softuni.spring.fundamentals.mobileLeLe.models.entities.User;

import java.util.Optional;


public interface UserService {

    void persistUserAndRole();

    void registerAndLoginUser(UserRegisterDto userRegisterDto);

    Optional<User> findByUsername(String username);
}
