package by.ivc.okssertificate.application.configuration;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:connection.properties")
public class ApplicationConfiguration {

    private final Environment environment;

    @Autowired
    public ApplicationConfiguration(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public DataSource dataSource(){
        return DataSourceBuilder.create()
                .url(environment.getProperty("postgre.url"))
                .username(environment.getProperty("postgre.username"))
                .password(environment.getProperty("postgre.password"))
                .driverClassName("org.postgresql.Driver")
                .build();
    }

    @Bean
    public SpringLiquibase liquibase(){
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog("classpath:liquibase-changeLog.xml");
        liquibase.setDataSource(dataSource());
        return liquibase;
    }
}
