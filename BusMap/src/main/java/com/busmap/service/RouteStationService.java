/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmap.service;

import com.busmap.pojo.RouteStation;
import java.util.List;
import java.util.Map;

/**
 *
 * @author lechi
 */
public interface RouteStationService {
    List<RouteStation> getRouteStaion(Map<String, String> params);
    void addOrUpdate(RouteStation routeStation);
    RouteStation getRouteStationById(int id); 
    void deleteRouteStation(int id); 
    Object nextRouteStation(RouteStation routeStation);
    Object backRouteStation(RouteStation routeStation);
    List<RouteStation> getRouteStationByRoute(int routeId);
    List<RouteStation> getRouteStationsByStation(int stationId);

}
