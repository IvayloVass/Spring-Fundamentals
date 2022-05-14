package bg.softuni.spring.fundamentals.mobileLeLe.services.impl;

import bg.softuni.spring.fundamentals.mobileLeLe.models.dtos.UserLoginDto;
import bg.softuni.spring.fundamentals.mobileLeLe.models.entities.User;
import bg.softuni.spring.fundamentals.mobileLeLe.repositories.UserRepository;
import bg.softuni.spring.fundamentals.mobileLeLe.services.UserService;
import bg.softuni.spring.fundamentals.mobileLeLe.session.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CurrentUser currentUser;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.currentUser = currentUser;
    }

    @Override
    public boolean login(UserLoginDto userLoginDto) {
        Optional<User> optionalUser = userRepository.findByUserName(userLoginDto.getUsername());
        if (optionalUser.isEmpty()) {
            logout();
            return false;
        }
        boolean successfulMatch = passwordEncoder
                .matches(userLoginDto.getPassword(), optionalUser.get().getPassword());

        if (successfulMatch) {
            User loggedInUser = optionalUser.get();
            currentUser.setUsername(loggedInUser.getUserName());
            currentUser.setFirstName(loggedInUser.getFirstName());
            currentUser.setLastName(loggedInUser.getLastName());
            currentUser.setLoggedIn(true);
        }
        return successfulMatch;
    }

    @Override
    public void logout() {
        currentUser.clear();
    }
}
