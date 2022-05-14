package bg.softuni.spring.fundamentals.mobileLeLe.services;

import bg.softuni.spring.fundamentals.mobileLeLe.models.dtos.UserLoginDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    boolean login(UserLoginDto userLoginDto);

    void logout();
}