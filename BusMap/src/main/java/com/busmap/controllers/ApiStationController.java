/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmap.controllers;

import com.busmap.pojo.Station;
import com.busmap.service.StationService;
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
public class ApiStationController {
    @Autowired
    private StationService stationService;

    @GetMapping("/stations")
    public ResponseEntity<List<Station>> list(@RequestParam Map<String, String> params) {
        List<Station> routes = this.stationService.getStations(params);

        return new ResponseEntity<>(routes, HttpStatus.OK);
    }
    
    @GetMapping("/stations/{stationId}")
    public ResponseEntity<Station> getRouteDetails(@PathVariable("stationId") int id) {
        Station station = this.stationService.getStationById(id);
        return new ResponseEntity<>(station, HttpStatus.OK);
    }
}
