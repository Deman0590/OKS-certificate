package by.ivc.okscertificate.application.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
public class DBConfiguration {

    private String driverClassName;
    private String url;
    private String username;

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Profile("dev")
    @Bean
    public String devDatabaseConnection() {
        System.out.println("DB connection for DEV");
        System.out.println("url: " + url);
        System.out.println("user name: " + username);
        return "DB connection for DEV";
    }

    @Profile("test")
    @Bean
    public String testDatabaseConnection() {
        System.out.println("DB Connection for TEST");
        System.out.println("url: " + url);
        System.out.println("user name: " + username);
        return "DB Connection to RDS_TEST - Low Cost Instance";
    }

    @Profile("prod")
    @Bean
    public String prodDatabaseConnection() {
        System.out.println("DB Connection for PROD");
        System.out.println("url: " + url);
        System.out.println("user name: " + username);
        return "DB Connection to RDS_PROD - High Performance Instance";
    }
}
