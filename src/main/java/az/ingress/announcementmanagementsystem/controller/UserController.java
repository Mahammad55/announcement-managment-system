package az.ingress.announcementmanagementsystem.controller;

import az.ingress.announcementmanagementsystem.dto.request.LoginRequest;
import az.ingress.announcementmanagementsystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/login")
    public void login(@RequestBody LoginRequest loginRequest) {
        userService.login(loginRequest);
    }
}
