package az.ingress.announcementmanagementsystem.service;

import az.ingress.announcementmanagementsystem.dto.request.LoginRequest;

public interface UserService {
    void login(LoginRequest loginRequest);
}
