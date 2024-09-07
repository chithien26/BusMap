/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmap.controllers;

import com.busmap.pojo.Route;
import com.busmap.pojo.Station;
import com.busmap.service.RouteService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
public class ApiRouteController {

    @Autowired
    private RouteService routeService;

    @GetMapping("/routes")
    public ResponseEntity<List<Route>> list(@RequestParam Map<String, String> params) {
        List<Route> routes = this.routeService.getRoutes(params);

        return new ResponseEntity<>(routes, HttpStatus.OK);
    }
    
    @GetMapping("/routes/{routeId}")
    public ResponseEntity<Route> getRouteDetails(@PathVariable("routeId") int id) {
        Route route = this.routeService.getRouteById(id);
        return new ResponseEntity<>(route, HttpStatus.OK);
    }
    
    @PostMapping("/routes/find_routes")
    public ResponseEntity<List<Route>> findRoutes(
            @RequestParam("startStationId") int startStationId,
            @RequestParam("endStationId") int endStationId) {
        List<Route> routes = this.routeService.findRoutes(startStationId, endStationId);
        return new ResponseEntity<>(routes, HttpStatus.OK);
    }
    
    @PostMapping("/routes/find_two_routes")
    public ResponseEntity<List<Map<String, Object>>> findTwoRoutes(
            @RequestParam("startStationId") int startStationId,
            @RequestParam("endStationId") int endStationId) {
        List<Map<String, Object>> routeTransferList = this.routeService.findTwoRoutes(startStationId, endStationId);
        return new ResponseEntity<>(routeTransferList, HttpStatus.OK);
    }
    
    
    @PostMapping("/routes/station_in_route")
    public ResponseEntity<List<Station>> getStationsInRoute(
            @RequestParam("routeId") int routeId,
            @RequestParam("startStationId") int startStationId,
            @RequestParam("endStationId") int endStationId) {
        List<Station> stations = this.routeService.getStationsInRoute(routeId, startStationId, endStationId);
        return new ResponseEntity<>(stations, HttpStatus.OK);
    }
    
    @GetMapping("/routes/all_station_in_route/{routeId}")
    public ResponseEntity<List<Station>> getAllStationsInRoute(@PathVariable("routeId") int routeId) {
        List<Station> stations = this.routeService.getAllStationsInRoute(routeId);
        return new ResponseEntity<>(stations, HttpStatus.OK);
    }
    
}
