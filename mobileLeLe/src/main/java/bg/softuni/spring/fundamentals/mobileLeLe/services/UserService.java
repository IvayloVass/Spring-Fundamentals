package bg.softuni.spring.fundamentals.mobileLeLe.services;

import bg.softuni.spring.fundamentals.mobileLeLe.models.dtos.UserLoginDto;
import bg.softuni.spring.fundamentals.mobileLeLe.models.dtos.UserRegisterDto;


public interface UserService {

    boolean login(UserLoginDto userLoginDto);

    void logout();

    void persistUserAndRole();

    void registerAndLoginUser(UserRegisterDto userRegisterDto);
}
