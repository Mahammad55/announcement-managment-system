package az.ingress.announcementmanagementsystem.service.impl;

import az.ingress.announcementmanagementsystem.dto.request.LoginRequest;
import az.ingress.announcementmanagementsystem.enums.ExceptionMessage;
import az.ingress.announcementmanagementsystem.exception.NotFoundException;
import az.ingress.announcementmanagementsystem.repository.UserRepository;
import az.ingress.announcementmanagementsystem.service.UserService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static az.ingress.announcementmanagementsystem.enums.LoginStatus.LOGGED_IN;
import static az.ingress.announcementmanagementsystem.enums.LoginStatus.LOGGED_OUT;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    @Transactional
    public void login(LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        userRepository.findUserByUsernameAndPassword(username, password)
                .map(user -> {
                    user.setStatus(LOGGED_IN);
                    return user;
                })
                .orElseThrow(() -> new NotFoundException(ExceptionMessage.USER_NOT_FOUND.getMessage().formatted(username + "," + password)));
    }

    @PostConstruct
    public void resetAllUsersLoginStatus() {
        userRepository.findAll().forEach(user -> {
            user.setStatus(LOGGED_OUT);
            userRepository.save(user);
        });
    }
}