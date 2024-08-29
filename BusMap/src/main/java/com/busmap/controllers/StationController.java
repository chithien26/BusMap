/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmap.controllers;

import com.busmap.pojo.Route;
import com.busmap.pojo.Station;
import com.busmap.service.StationService;
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
public class StationController {
    @Autowired
    private StationService stationService;
    
    @GetMapping(path = "/stations")
    public String list(Model model, @RequestParam Map<String, String> params){
        model.addAttribute("stations", stationService.getStations(params));
        model.addAttribute("station", new Route());
        return "stations";
    }
    
    @PostMapping(path = "/stations")
    public String add(Model model, @ModelAttribute(value = "station") @Valid Station station, BindingResult rs ){
//        if(rs.hasErrors()){
//            return "routes";
//        }
//        try {
//            this.routeService.addOrUpdate(route);
//        } catch (Exception ex) {
//            model.addAttribute("errMsg", ex.getMessage());
//        }
        this.stationService.addOrUpdate(station);
        return "redirect:stations";
    }
    
    @RequestMapping(path = "/stations/{stationId}")
    public String details(Model model, @PathVariable(value = "stationId") int id){
        model.addAttribute("station", this.stationService.getStationById(id));
        return "stationDetails";
    }
    
    @RequestMapping(path = "/stations/{stationId}/delete")
    public String delete(Model model, @PathVariable(value = "stationId") int id){
        this.stationService.deleteStation(id);
        return "forward:stations";
    }
}
