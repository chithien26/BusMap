/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmap.controllers;

import com.busmap.pojo.Route;
import com.busmap.service.RouteService;
import com.busmap.service.StationService;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author lechi
 */
@Controller
@ControllerAdvice
public class HomeController {

    @Autowired
    private Environment env;

    @Autowired
    private RouteService routeService;
    @Autowired
    private StationService stationService;

    @RequestMapping("/")
    public String index(Model model) {
        return "index";
    }

    @RequestMapping(path = "/contact")
    public String contact(Model model) {
        return "contact";
    }
    
    @RequestMapping("/test")
    public String test(){
        Route route = new Route(); 
        route.setId(14);
        route.setName("test - test");
        this.routeService.addOrUpdate(route);
        return "redirect:routes";
    }
//    @RequestMapping(path = "/routes", method = RequestMethod.GET)
//    public String routes(Model model, @RequestParam Map<String, String> params) {
//        model.addAttribute("routes", routeService.getRoutes(params));
//        return "routes";
//    }

//    @RequestMapping(path = "/stations")
//    public String stations(Model model) {
//        model.addAttribute("stations", stationService.getStations());
//        return "stations";
//    }

}
