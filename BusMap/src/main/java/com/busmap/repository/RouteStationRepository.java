/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmap.repository;

import com.busmap.pojo.RouteStation;
import java.util.List;
import java.util.Map;

/**
 *
 * @author lechi
 */
public interface RouteStationRepository {
    List<RouteStation> getRouteStaion(Map<String, String> params);
    void addOrUpdate(RouteStation routeStation);
    RouteStation getRouteStationById(int id); 
    void deleteRouteStation(int id); 
}
