package by.ivc.okscertificate.application.security;

import by.ivc.okscertificate.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final AccountService accountService;
    private final CustomAuthenticationProvider customAuthenticationProvider;


    @Autowired
    public SecurityConfiguration(AccountService userService, CustomAuthenticationProvider customAuthenticationProvider) {
        this.accountService = userService;
        this.customAuthenticationProvider = customAuthenticationProvider;
    }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(customAuthenticationProvider).userDetailsService(accountService);
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(customAuthenticationProvider).userDetailsService(accountService);
        //auth.inMemoryAuthentication().withUser("admin").password("$2a$10$/wcaYsgu2fnv9YG2SlnZCeyjrb9FDIhhS9n3EHkXixmxpzPr/haIu").roles("SUPER_ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/user").hasRole("SUPER_ADMIN").anyRequest().fullyAuthenticated().and().httpBasic();
    }
}
