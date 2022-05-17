package bg.softuni.spring.fundamentals.mobileLeLe.services;

import bg.softuni.spring.fundamentals.mobileLeLe.models.dtos.UserLoginDto;


public interface UserService {

    boolean login(UserLoginDto userLoginDto);

    void logout();

    void persistUserAndRole();
}
