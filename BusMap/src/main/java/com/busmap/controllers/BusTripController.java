/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmap.controllers;

import com.busmap.pojo.BusTrip;
import com.busmap.service.BusTripService;
import com.busmap.service.RouteService;
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
public class BusTripController {
    @Autowired
    private BusTripService busTripService;
    
    @Autowired
    private RouteService routeService;
//    @Autowired
//    private WebAppValidator routeValidator;
    
//    @InitBinder
//    public void initBinder(WebDataBinder binder){
//        binder.setValidator(routeValidator);
//    }
    @ModelAttribute
    public void commAttrs(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("routes", routeService.getRoutes(params));
    }
    
    @GetMapping(path = "/bus_trips")
    public String list(Model model, @RequestParam Map<String, String> params){
        model.addAttribute("busTrips", busTripService.getBusTrips(params));
        model.addAttribute("busTrip", new BusTrip());
        return "bus_trips";
    }
    
    @PostMapping(path = "/bus_trips")
    public String add(Model model, @ModelAttribute(value = "busTrip") @Valid BusTrip busTrip, BindingResult rs ){
//        if(rs.hasErrors()){
//            return "routes";
//        }
        try {
            this.busTripService.addOrUpdate(busTrip);
        } catch (Exception ex) {
            model.addAttribute("errMsg", ex.getMessage());
            return "bus_trips";

        }
        return "redirect:/bus_trips";
    }
    
    @GetMapping(path = "/bus_trips/{busTripId}")
    public String details(Model model, @PathVariable(value = "busTripId") int id){
        model.addAttribute("busTrip", this.busTripService.getBusTripById(id));
        return "busTripDetails";
    }
    
    @PostMapping(path = "/bus_trips/{busTripId}")
    public String update(Model model, @ModelAttribute(value = "busTrip") @Valid BusTrip busTrip, BindingResult rs ){
//        try {
//            this.routeService.addOrUpdate(route);
//        } catch (Exception ex) {
//            model.addAttribute("errMsg", ex.getMessage());
//            return "routes";
//
//        }
        this.busTripService.addOrUpdate(busTrip);
        return "redirect:/bus_trips";
    }
    
    @RequestMapping(path = "/bus_trips/{busTripId}/delete")
    public String delete(Model model, @PathVariable(value = "busTripId") int id){
        this.busTripService.deleteBusTrip(id);
        return "redirect:/bus_trips";
    }
}
