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
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author lechi
 */
@Controller
//@ControllerAdvice
public class RouteController {
    
    @Autowired
    private RouteService routeService;
//    @Autowired
//    private WebAppValidator routeValidator;
    
//    @InitBinder
//    public void initBinder(WebDataBinder binder){
//        binder.setValidator(routeValidator);
//    }
    
    @GetMapping(path = "/routes")
    public String list(Model model, @RequestParam Map<String, String> params){
        model.addAttribute("routes", routeService.getRoutes(params));
        model.addAttribute("route", new Route());
        return "routes";
    }
    
    @PostMapping(path = "/routes")
    public String add(Model model, @ModelAttribute(value = "route") @Valid Route route, BindingResult rs ){
//        if(rs.hasErrors()){
//            return "routes";
//        }
        try {
            this.routeService.addOrUpdate(route);
        } catch (Exception ex) {
            model.addAttribute("errMsg", ex.getMessage());
            return "routes";

        }
//        this.routeService.addOrUpdate(route);
        return "redirect:/routes";
    }
    
    @GetMapping(path = "/routes/{routeId}")
    public String details(Model model, @PathVariable(value = "routeId") int id){
        model.addAttribute("route", this.routeService.getRouteById(id));
        return "routeDetails";
    }
    
    @PostMapping(path = "/routes/{routeId}")
    public String update(Model model, @ModelAttribute(value = "route") @Valid Route route, BindingResult rs ){
//        try {
//            this.routeService.addOrUpdate(route);
//        } catch (Exception ex) {
//            model.addAttribute("errMsg", ex.getMessage());
//            return "routes";
//
//        }
        this.routeService.addOrUpdate(route);
        return "redirect:/routes";
    }
    
    @RequestMapping(path = "/routes/{routeId}/delete")
    public String delete(Model model, @PathVariable(value = "routeId") int id){
        this.routeService.deleteRoute(id);
        return "redirect:/routes";
    }
    
    
    
    
   
}
