/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmap.controllers;

import com.busmap.pojo.Route;
import com.busmap.pojo.Schedule;
import com.busmap.service.BusTripService;
import com.busmap.service.RouteService;
import com.busmap.service.ScheduleService;
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
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;
    
    @Autowired
    private BusTripService busTripService;
    
    @ModelAttribute
    public void commAttrs(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("busTrips", busTripService.getBusTrips(params));
    }
    
    @GetMapping(path = "/schedules")
    public String list(Model model, @RequestParam Map<String, String> params){
        model.addAttribute("schedules", scheduleService.getSchedules(params));
        model.addAttribute("schedule", new Schedule());
        return "schedules";
    }
    
    @PostMapping(path = "/schedules")
    public String add(Model model, @ModelAttribute(value = "schedule") @Valid Schedule schedule, BindingResult rs ){
//        if(rs.hasErrors()){
//            return "schedules";
//        }
        try {
            this.scheduleService.addOrUpdate(schedule);
        } catch (Exception ex) {
            model.addAttribute("errMsg", ex.getMessage());
            return "schedules";

        }
//        this.routeService.addOrUpdate(route);
        return "redirect:/schedules";
    }
    
    @GetMapping(path = "/schedules/{scheduleId}")
    public String details(Model model, @PathVariable(value = "scheduleId") int id){
        model.addAttribute("schedule", this.scheduleService.getScheduleById(id));
        return "scheduleDetails";
    }
    
    @PostMapping(path = "/schedules/{scheduleId}")
    public String update(Model model, @ModelAttribute(value = "schedule") @Valid Schedule schedule, BindingResult rs ){
//        try {
//            this.routeService.addOrUpdate(route);
//        } catch (Exception ex) {
//            model.addAttribute("errMsg", ex.getMessage());
//            return "schedules";
//
//        }
        this.scheduleService.addOrUpdate(schedule);
        return "redirect:/routes";
    }
    
    @RequestMapping(path = "/schedules/{scheduleId}/delete")
    public String delete(Model model, @PathVariable(value = "scheduleId") int id){
        this.scheduleService.deleteSchedule(id);
        return "redirect:/schedules";
    }
}
