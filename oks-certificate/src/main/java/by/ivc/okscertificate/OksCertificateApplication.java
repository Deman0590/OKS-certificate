package by.ivc.okscertificate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class OksCertificateApplication {

    private static final Logger logger = LoggerFactory.getLogger(OksCertificateApplication.class);

    public static void main(String[] args) {
        logger.info("Application start");
        SpringApplication.run(OksCertificateApplication.class, args);
    }
}
