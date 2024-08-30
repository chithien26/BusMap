/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmap.service;

import com.busmap.pojo.BusTrip;
import java.util.List;
import java.util.Map;

/**
 *
 * @author lechi
 */
public interface BusTripService {
    List<BusTrip> getBusTrips(Map<String, String> params);
    void addOrUpdate(BusTrip busTrip);
    BusTrip getBusTripById(int id); 
    void deleteBusTrip(int id); 
}
