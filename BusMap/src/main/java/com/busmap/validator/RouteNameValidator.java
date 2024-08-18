/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmap.validator;

import com.busmap.pojo.Route;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author lechi
 */
@Component
public class RouteNameValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return Route.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Route r = (Route) target;
        if(!r.getName().contains("-")){
            errors.rejectValue("name", "route.name.err");
        }
    }
    
}
