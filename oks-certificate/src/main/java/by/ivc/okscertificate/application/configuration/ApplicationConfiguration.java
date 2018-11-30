package by.ivc.okscertificate.application.configuration;

import by.ivc.okscertificate.dto.mapper.BaseMapper;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public BaseMapper baseMapper() {
        return new BaseMapper();
    }

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
