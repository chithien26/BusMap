/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmap.repository;

import com.busmap.pojo.Route;
import com.busmap.pojo.Station;
import java.util.List;
import java.util.Map;

/**
 *
 * @author lechi
 */
public interface RouteRepository {
    List<Route> getRoutes(Map<String, String> params);
    void addOrUpdate(Route route);
    Route getRouteById(int id); 
    void deleteRoute(int id); 
    List<Route> findRoutes(int startStationId, int endStationId);
    List<Map<String, Object>> findTwoRoutes(int startStationId, int endStationId);
    List<Station> getStationsInRoute(int routeId, int startStationId, int endStationId);
    List<Station> getAllStationsInRoute(int routeId);

}
