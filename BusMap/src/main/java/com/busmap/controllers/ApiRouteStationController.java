/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmap.controllers;

import com.busmap.pojo.RouteStation;
import com.busmap.service.RouteStationService;
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
public class ApiRouteStationController {
    @Autowired
    private RouteStationService routeStationService;

    @GetMapping("/route_stations")
    public ResponseEntity<List<RouteStation>> list(@RequestParam Map<String, String> params) {
        List<RouteStation> routeStationses = this.routeStationService.getRouteStaion(params);

        return new ResponseEntity<>(routeStationses, HttpStatus.OK);
    }
    
    @GetMapping("/route_stations/{routeStationId}")
    public ResponseEntity<RouteStation> getRouteStationDetails(@PathVariable("routeStationId") int id) {
        RouteStation routeStation = this.routeStationService.getRouteStationById(id);
        return new ResponseEntity<>(routeStation, HttpStatus.OK);
    }
    
//    @GetMapping("/routes/find_route")
//    public ResponseEntity<List<Route>> fineRoutes(
//            @RequestParam("startAddress") String startAddress,
//            @RequestParam("endAddress") String endAddress) {
//        // Chuyển địa chỉ thành tọa độ
//        GeoLocation startLocation = geoService.getCoordinates(startAddress);
//        GeoLocation endLocation = geoService.getCoordinates(endAddress);
//        
//        // Tìm tuyến xe
//        List<BusRoute> routes = busRouteService.findRoutes(startLocation, endLocation);
//        
//        return new ResponseEntity<>(routes, HttpStatus.OK);
//    }
}
