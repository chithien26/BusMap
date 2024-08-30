/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmap.service.impl;

import com.busmap.pojo.BusTrip;
import com.busmap.repository.BusTripRepository;
import com.busmap.service.BusTripService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lechi
 */
@Service
public class BusTripServiceImpl implements BusTripService{

    @Autowired
    private BusTripRepository busTripRepository;
    
    @Override
    public List<BusTrip> getBusTrips(Map<String, String> params) {
        return this.busTripRepository.getBusTrips(params);
    }

    @Override
    public void addOrUpdate(BusTrip busTrip) {
        this.busTripRepository.addOrUpdate(busTrip);
    }

    @Override
    public BusTrip getBusTripById(int id) {
        return this.busTripRepository.getBusTripById(id);
    }

    @Override
    public void deleteBusTrip(int id) {
        this.busTripRepository.deleteBusTrip(id);
    }
    
}
