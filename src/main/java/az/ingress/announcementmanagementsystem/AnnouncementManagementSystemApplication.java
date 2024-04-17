package az.ingress.announcementmanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class AnnouncementManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnnouncementManagementSystemApplication.class, args);
    }
}