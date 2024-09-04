/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmap.controllers;

import com.busmap.pojo.RouteStation;
import com.busmap.service.RouteStationService;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author lechi
 */
@Controller
public class RouteStationController {
    @Autowired
    private RouteStationService routeStationService;
//    @Autowired
//    private WebAppValidator routeValidator;
    
//    @InitBinder
//    public void initBinder(WebDataBinder binder){
//        binder.setValidator(routeValidator);
//    }
    
    @GetMapping(path = "/route_stations")
    public String list(Model model, @RequestParam Map<String, String> params){
        model.addAttribute("routeStations", routeStationService.getRouteStaion(params));
        model.addAttribute("routeStation", new RouteStation());
        return "route_stations";
    }
    
    @PostMapping(path = "/route_stations")
    public String add(Model model, @ModelAttribute(value = "routeStation") @Valid RouteStation routeStation, BindingResult rs ){
//        if(rs.hasErrors()){
//            return "routes";
//        }
        try {
            this.routeStationService.addOrUpdate(routeStation);
        } catch (Exception ex) {
            model.addAttribute("errMsg", ex.getMessage());
            return "route_stations";

        }
//        this.routeService.addOrUpdate(route);
        return "redirect:/route_stations";
    }
    
    @GetMapping(path = "/route_stations/{routeStationId}")
    public String details(Model model, @PathVariable(value = "routeStationId") int id){
        model.addAttribute("routeStation", this.routeStationService.getRouteStationById(id));
        return "routeStationDetails";
    }
    
    @PostMapping(path = "/route_stations/{routeStationId}")
    public String update(Model model, @ModelAttribute(value = "routeStation") @Valid RouteStation routeStation, BindingResult rs ){
//        try {
//            this.routeService.addOrUpdate(route);
//        } catch (Exception ex) {
//            model.addAttribute("errMsg", ex.getMessage());
//            return "routes";
//
//        }
        this.routeStationService.addOrUpdate(routeStation);
        return "redirect:/route_stations";
    }
    
    @RequestMapping(path = "/route_stations/{routeStationId}/delete")
    public String delete(Model model, @PathVariable(value = "routeStationId") int id){
        this.routeStationService.deleteRouteStation(id);
        return "redirect:/route_stations";
    }
}
