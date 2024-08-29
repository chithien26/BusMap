/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmap.controllers;

import com.busmap.pojo.Route;
import com.busmap.service.RouteService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
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
    
    @DeleteMapping("/route/{routeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "routeId") int id) {
        this.routeService.deleteRoute(id);
    }
}
