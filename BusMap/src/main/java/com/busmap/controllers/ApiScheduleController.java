/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmap.controllers;

import com.busmap.pojo.Route;
import com.busmap.pojo.Schedule;
import com.busmap.service.ScheduleService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lechi
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ApiScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("/schedules")
    public ResponseEntity<List<Schedule>> list(@RequestParam Map<String, String> params) {
        List<Schedule> schedules = this.scheduleService.getSchedules(params);

        return new ResponseEntity<>(schedules, HttpStatus.OK);
    }
    
    @GetMapping("/schedules/{scheduleId}")
    public ResponseEntity<Schedule> getScheduleDetails(@PathVariable("scheduleId") int id) {
        Schedule schedule = this.scheduleService.getScheduleById(id);
        return new ResponseEntity<>(schedule, HttpStatus.OK);
    }
}
