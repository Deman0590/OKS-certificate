package by.ivc.okscertificate.application.configuration;

import liquibase.integration.spring.SpringLiquibase;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
public class ApplicationConfiguration {

//    private final Environment environment;
//
//    @Autowired
//    public ApplicationConfiguration(Environment environment) {
//        this.environment = environment;
//    }

//    @Bean
//    public DataSource dataSource(){
//        return DataSourceBuilder.create()
//                .url(environment.getProperty("postgre.url"))
//                .username(environment.getProperty("postgre.username"))
//                .password(environment.getProperty("postgre.password"))
//                .driverClassName("org.postgresql.Driver")
//                .build();
//    }

//    @Bean
//    public SpringLiquibase liquibase(){
//        SpringLiquibase liquibase = new SpringLiquibase();
//        liquibase.setChangeLog("classpath:changelog.xml");
//        liquibase.setDataSource(dataSource());
//        return liquibase;
//    }

//    @Bean
//    public SqlSessionFactory sqlSessionFactory() throws Exception {
//        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        Resource[] resources = resolver.getResources("classpath*:mapper/*.xml");
//
//        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource(dataSource());
//        sqlSessionFactoryBean.setMapperLocations(resources);
//        sqlSessionFactoryBean.setTypeAliasesPackage("by.ivc.okscertificate.data.entity");
//
//        return sqlSessionFactoryBean.getObject();
//    }
}
