/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmap.controllers;

import com.busmap.service.StationService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author lechi
 */
@Controller
@RequestMapping("/admin")
public class StationController {
    @Autowired
    private StationService stationService;
    
    @RequestMapping(path = "/stations")
    public String stations(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("stations", stationService.getStations(params));
        return "stations";
    }
}
