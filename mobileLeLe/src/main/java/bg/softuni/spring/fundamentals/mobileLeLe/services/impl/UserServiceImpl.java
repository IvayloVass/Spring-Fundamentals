package bg.softuni.spring.fundamentals.mobileLeLe.services.impl;

import bg.softuni.spring.fundamentals.mobileLeLe.models.dtos.UserRegisterDto;
import bg.softuni.spring.fundamentals.mobileLeLe.models.entities.User;
import bg.softuni.spring.fundamentals.mobileLeLe.models.entities.UserRole;
import bg.softuni.spring.fundamentals.mobileLeLe.models.entities.enums.Role;
import bg.softuni.spring.fundamentals.mobileLeLe.repositories.UserRepository;
import bg.softuni.spring.fundamentals.mobileLeLe.repositories.UserRoleRepository;
import bg.softuni.spring.fundamentals.mobileLeLe.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final UserDetailsService userDetailsService;

    private final PasswordEncoder passwordEncoder;
    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder,
                           UserRoleRepository userRoleRepository,
                           UserDetailsService userDetailsService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRoleRepository = userRoleRepository;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public void persistUserAndRole() {
        initializeRoles();
        initializeUsers();

    }

    @Override
    public void registerAndLoginUser(UserRegisterDto userRegisterDto) {

        UserRole role = userRoleRepository.findByName(Role.USER);

        User newUser = new User();
        newUser.setUsername(userRegisterDto.getUsername());
        newUser.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));
        newUser.setFirstName(userRegisterDto.getFirstName());
        newUser.setLastName(userRegisterDto.getLastName());
        newUser.setActive(true);
        newUser.setUserRole(List.of(role));
        newUser.setCreated(LocalDateTime.now());

        userRepository.save(newUser);
        login(newUser);

    }

    private void login(User newUser) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(newUser.getUsername());
        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(),
                userDetails.getAuthorities());

        SecurityContextHolder
                .getContext()
                .setAuthentication(authentication);

    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
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
