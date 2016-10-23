package com.deltagroupbd.ocms.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.context.annotation.Bean;


@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/home").permitAll() 
                .antMatchers("/admin**").access("hasRole('ADMIN')")  
                .anyRequest().fullyAuthenticated() // or .anyRequest().authenticated()
                //.antMatchers("/home").access("hasRole('USER')") 
            .and()
                .formLogin()
                .loginPage("/login") 
                .loginProcessingUrl("/login")  //login form action url default /login
                //.usernameParameter("username").passwordParameter("password") if param name different
                //.and().csrf() bydefault enable spring 4
                .failureUrl("/login?error")
                .defaultSuccessUrl("/")
                .permitAll()
            .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/login?logout") //default you can chagne it
            .and()
                .exceptionHandling().accessDeniedPage("/access_denied");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                //.withUser("user").password("password").roles("USER"); //no encode
                //.passwordEncoder(passwordEncoder())
                .withUser("user").password("$2a$08$TqBK.DGbD91CqNb179z7MOFECgESLEmsUzNXIyG59HKvvtympNG7.").roles("USER");
        auth
            .inMemoryAuthentication()
                .passwordEncoder(passwordEncoder())
                .withUser("admin").password("$2a$08$s2ZfY7nA2HcciAiEVzF03.T7P/Tb4KGKyHzOB/9snHptpKw18MCyu").roles("ADMIN");
        auth
            .inMemoryAuthentication()
                .passwordEncoder(passwordEncoder())
                .withUser("dba").password("$2a$08$AbTYAIcqBbhTNv.qDIvStOjH8A3ibnAQdrvPj4gvPr7DbgzyZILm6").roles("ADMIN","DBA");
            //.authenticationProvider(authenticationProvider());

    }
    
    @Bean
    public PasswordEncoder passwordEncoder(){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }
    /*
    @Bean
    public AbstractUserDetailsAuthenticationProvider authenticationProvider() {
        //DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        //authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }*/
}
