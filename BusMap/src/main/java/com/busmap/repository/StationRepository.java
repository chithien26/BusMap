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
public interface StationRepository {
    List<Station> getStations(Map<String, String> params);
    void addOrUpdate(Station station);
    Station getStationById(int id); 
    void deleteStation(int id); 
}
