/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmap.service.impl;

import com.busmap.pojo.Station;
import com.busmap.repository.StationRepository;
import com.busmap.service.StationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lechi
 */
@Service
public class StationServiceImpl implements StationService{
    @Autowired
    private StationRepository stationRepository;
    
    @Override
    public List<Station> getStations() {
        return this.stationRepository.getStations();
    }
    
}
