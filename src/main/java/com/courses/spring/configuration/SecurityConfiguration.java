package com.courses.spring.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("customUserDetailsService")
    UserDetailsService userDetailsService;

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/","/registration**/**").permitAll()
                .antMatchers("/administrative**/**", "/index**/**").access("hasRole('DIRECTOR') or hasRole('TEACHER') or hasRole('USER')")
                .antMatchers("/createStudent**/**", "/createSubject**/**",
                        "/deleteStudent**/**", "/updateStudent**/**",
                        "/updateSubject**/**", "/deleteSubject**/**", "/updateUser**/**" ).access("hasRole('DIRECTOR')")
                .antMatchers("/infoStudent**/**", "/insertMark**/**", "/deleteMark**/**").access("hasRole('TEACHER')")
                .and().formLogin().loginPage("/login")
                .usernameParameter("login").passwordParameter("password")
                .and().csrf()
                .and().exceptionHandling().accessDeniedPage("/Access_Denied");
    }
}
