/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmap.service.impl;

import com.busmap.pojo.Route;
import com.busmap.repository.RouteRepository;
import com.busmap.service.RouteService;
import java.util.List;
import java.util.Map;
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

    
    
    
}
