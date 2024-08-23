/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmap.configs;

import com.busmap.pojo.Route;
//import com.busmap.validator.RouteNameValidator;
//import com.busmap.validator.WebAppValidator;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.util.HashSet;
import java.util.Set;
import javax.validation.ConstraintViolation;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 *
 * @author lechi
 */
@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.busmap.controllers",
    "com.busmap.repository",
    "com.busmap.service",
    "com.busmap.validator",})
public class WebAppContextConfig implements WebMvcConfigurer {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/pages/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver
                = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");
        return resolver;
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource m = new ResourceBundleMessageSource();
        m.setBasename("messages");

        return m;
    }

//    @Bean
//    public Cloudinary cloudinary() {
//        Cloudinary cloudinary
//                = new Cloudinary(ObjectUtils.asMap(
//                        "cloud_name", "BusMap",
//                        "api_key", "544758496811834",
//                        "api_secret", "rDqPoK24mq56G9Tw8WA6Fh0q1Qs",
//                        "secure", true));
//        return cloudinary;
//    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/resources/css/");
    }

    @Override
    public Validator getValidator() {
        return validator();
    }

    @Bean
    public LocalValidatorFactoryBean validator() {
        LocalValidatorFactoryBean v = new LocalValidatorFactoryBean();
        v.setValidationMessageSource(messageSource());
        return v;
    }

        
//    @Bean
//    public WebAppValidator routeValidator(){
//        Set<Validator> springValidators = new HashSet<>(); 
//        springValidators.add(new RouteNameValidator());
//        
//        WebAppValidator v = new WebAppValidator();
//        v.setSpringValidators(springValidators);
//        return v;
//        
//    }
}
