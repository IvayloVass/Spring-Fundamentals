package bg.softuni.spring.fundamentals.mobileLeLe.services.impl;

import bg.softuni.spring.fundamentals.mobileLeLe.models.dtos.UserLoginDto;
import bg.softuni.spring.fundamentals.mobileLeLe.models.dtos.UserRegisterDto;
import bg.softuni.spring.fundamentals.mobileLeLe.models.entities.User;
import bg.softuni.spring.fundamentals.mobileLeLe.models.entities.UserRole;
import bg.softuni.spring.fundamentals.mobileLeLe.models.entities.enums.Role;
import bg.softuni.spring.fundamentals.mobileLeLe.repositories.UserRepository;
import bg.softuni.spring.fundamentals.mobileLeLe.repositories.UserRoleRepository;
import bg.softuni.spring.fundamentals.mobileLeLe.services.UserService;
import bg.softuni.spring.fundamentals.mobileLeLe.session.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CurrentUser currentUser;
    private final UserRoleRepository userRoleRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, CurrentUser currentUser, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.currentUser = currentUser;
        this.userRoleRepository = userRoleRepository;
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
            login(loggedInUser);

            loggedInUser.getUserRole()
                    .forEach(r -> currentUser.addRole(r.getName()));
        }
        return successfulMatch;
    }

    @Override
    public void logout() {
        currentUser.clear();
    }

    @Override
    public void persistUserAndRole() {
        initializeRoles();
        initializeUsers();

    }

    @Override
    public void registerAndLoginUser(UserRegisterDto userRegisterDto) {

        UserRole role = userRoleRepository.findByName(Role.USER);

        User userAttemptRegistration = new User();
        userAttemptRegistration.setUserName(userRegisterDto.getFirstName());
        userAttemptRegistration.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));
        userAttemptRegistration.setFirstName(userRegisterDto.getFirstName());
        userAttemptRegistration.setLastName(userRegisterDto.getLastName());
        userAttemptRegistration.setActive(true);
        userAttemptRegistration.setUserRole(List.of(role));
        userAttemptRegistration.setCreated(LocalDateTime.now());

        userRepository.save(userAttemptRegistration);
        login(userAttemptRegistration);

    }

    private void login(User user) {
        currentUser.setUsername(user.getUserName());
        currentUser.setFirstName(user.getFirstName());
        currentUser.setLastName(user.getLastName());
        currentUser.setLoggedIn(true);
    }

    private void initializeUsers() {

        UserRole adminRole = userRoleRepository.findByName(Role.ADMIN);
        UserRole userRole = userRoleRepository.findByName(Role.USER);

        if (userRepository.count() == 0) {
            User mitak = new User("super@duper", passwordEncoder.encode("secretPass"),
                    "Mitak", "Petrov", LocalDateTime.now());
            User risto = new User("Risto", passwordEncoder.encode("12345"),
                    "Risto", "Motoristo", LocalDateTime.now());
            mitak.setActive(true);
            risto.setActive(true);

            mitak.setUserRole(List.of(adminRole, userRole));
            userRepository.save(mitak);

            risto.setUserRole((List.of(userRole)));
            userRepository.save(risto);

        }

    }

    private void initializeRoles() {
        if (userRoleRepository.count() == 0) {

            UserRole admin = new UserRole();
            admin.setName(Role.ADMIN);

            UserRole regular = new UserRole();
            regular.setName(Role.USER);

            userRoleRepository.saveAll(List.of(admin, regular));
        }

    }

}
