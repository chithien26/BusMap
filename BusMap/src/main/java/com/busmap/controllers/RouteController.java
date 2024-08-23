/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmap.controllers;

import com.busmap.pojo.Route;
import com.busmap.service.RouteService;
//import com.busmap.validator.RouteNameValidator;
//import com.busmap.validator.WebAppValidator;
import com.github.mustachejava.Binding;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author lechi
 */
@Controller
@RequestMapping("/admin")
public class RouteController {
    @Autowired
    private RouteService routeService;
//    @Autowired
//    private WebAppValidator routeValidator;
    
//    @InitBinder
//    public void initBinder(WebDataBinder binder){
//        binder.setValidator(routeValidator);
//    }
    
    @RequestMapping(path = "/routes")
    public String list(Model model, @RequestParam Map<String, String> params){
        model.addAttribute("routes", routeService.getRoutes(params));
        return "routes";
    }
    
    @PostMapping(path = "/routes")
    public String add(@ModelAttribute(value = "route") @Valid Route route, BindingResult result ){
        if(!result.hasErrors()){
            return "redirect:/";
        }
        else{
            return "routes";
        }
    }
}
