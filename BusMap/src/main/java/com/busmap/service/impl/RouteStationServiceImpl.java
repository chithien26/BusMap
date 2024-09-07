/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmap.service.impl;

import com.busmap.pojo.RouteStation;
import com.busmap.repository.RouteStationRepository;
import com.busmap.service.RouteStationService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lechi
 */
@Service
public class RouteStationServiceImpl implements RouteStationService{

    @Autowired
    private RouteStationRepository RouteStationRepository;
    
    @Override
    public List<RouteStation> getRouteStaion(Map<String, String> params) {
        return this.RouteStationRepository.getRouteStaion(params);
    }

    @Override
    public void addOrUpdate(RouteStation routeStation) {
        this.RouteStationRepository.addOrUpdate(routeStation);
    }

    @Override
    public RouteStation getRouteStationById(int id) {
        return this.RouteStationRepository.getRouteStationById(id);
    }

    @Override
    public void deleteRouteStation(int id) {
        this.RouteStationRepository.deleteRouteStation(id);
    }

    @Override
    public Object nextRouteStation(RouteStation rs) {
        return this.RouteStationRepository.nextRouteStation(rs);
    }

    @Override
    public Object backRouteStation(RouteStation rs) {
        return this.RouteStationRepository.backRouteStation(rs);
    }

    @Override
    public List<RouteStation> getRouteStationByRoute(int routeId) {
        return this.RouteStationRepository.getRouteStationByRoute(routeId);
    }

    @Override
    public List<RouteStation> getRouteStationsByStation(int stationId) {
        return this.RouteStationRepository.getRouteStationsByStation(stationId);
    }
    
    
}
