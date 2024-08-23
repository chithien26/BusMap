/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmap.configs;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author lechi
 */
@Configuration
@EnableWebSecurity
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.busmap.controllers",
    "com.busmap.repository",
    "com.busmap.service",})
public class SecurityConfigs extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public Cloudinary cloudinary() {
        Cloudinary cloudinary
                = new Cloudinary(ObjectUtils.asMap(
                        "cloud_name", "BusMap",
                        "api_key", "544758496811834",
                        "api_secret", "rDqPoK24mq56G9Tw8WA6Fh0q1Qs",
                        "secure", true));
        return cloudinary;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .usernameParameter("username")
                .passwordParameter("password");
        
        http.formLogin().defaultSuccessUrl("/")
                .failureUrl("/login?error");
        
        http.logout().logoutSuccessUrl("/login");
        
        http.exceptionHandling()
                .accessDeniedPage("/login?accessDenied");
        
//        http.authorizeRequests().antMatchers("/").permitAll()
//                .antMatchers("/**/add")
//                .access("hasRole('ROLE_ADMIN')");
//        .antMatchers("/**/pay")
//                .access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")

        http.csrf().disable();
    }

}
