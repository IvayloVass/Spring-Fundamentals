package bg.softuni.spring.fundamentals.mobileLeLe.services;

import org.springframework.stereotype.Service;

@Service
public interface UserService {

    boolean login(String username, String password);
}
