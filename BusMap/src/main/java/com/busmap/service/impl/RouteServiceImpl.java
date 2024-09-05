/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmap.service.impl;

import com.busmap.pojo.Route;
import com.busmap.pojo.RouteStation;
import com.busmap.pojo.Station;
import com.busmap.repository.RouteRepository;
import com.busmap.repository.RouteStationRepository;
import com.busmap.repository.StationRepository;
import com.busmap.service.RouteService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lechi
 */
@Service
public class RouteServiceImpl implements RouteService{
    
    @Autowired
    private RouteRepository routeRepository;


    @Override
    public List<Route> getRoutes(Map<String, String> params) {
        return this.routeRepository.getRoutes(params);
    }

    @Override
    public void addOrUpdate(Route route) {
        this.routeRepository.addOrUpdate(route);
    }

    @Override
    public Route getRouteById(int id) {
        return this.routeRepository.getRouteById(id);
    }

    @Override
    public void deleteRoute(int id) {
        this.routeRepository.deleteRoute(id);
    }

    @Override
    public List<Route> findRoutes(int i, int i1) {
        return this.routeRepository.findRoutes(i, i1);
    }

    @Override
    public List<Station> getStationsInRoute(int i, int i1, int i2) {
        return this.routeRepository.getStationsInRoute(i, i1, i2);
    }

    @Override
    public List<Station> getAllStationsInRoute(int i) {
        return this.getAllStationsInRoute(i);
    }

    

    
    
    
}
