/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmap.controllers;

import com.busmap.pojo.BusTrip;
import com.busmap.service.BusTripService;
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
public class ApiBusTripController {
    @Autowired
    private BusTripService busTripService;

    @GetMapping("/busTrips")
    public ResponseEntity<List<BusTrip>> list(@RequestParam Map<String, String> params) {
        List<BusTrip> busTrips = this.busTripService.getBusTrips(params);

        return new ResponseEntity<>(busTrips, HttpStatus.OK);
    }
    
    @GetMapping("/busTrips/{busTripId}")
    public ResponseEntity<BusTrip> getBusTripDetails(@PathVariable("busTripId") int id) {
        BusTrip busTrip = this.busTripService.getBusTripById(id);
        return new ResponseEntity<>(busTrip, HttpStatus.OK);
    }
}
