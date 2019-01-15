package by.ivc.okscertificate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class OksCertificateApplication {

    public static void main(String[] args) {
        SpringApplication.run(OksCertificateApplication.class, args);
    }
}
