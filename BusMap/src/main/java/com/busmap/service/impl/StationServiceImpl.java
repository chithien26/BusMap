/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmap.service.impl;

import com.busmap.pojo.Station;
import com.busmap.repository.StationRepository;
import com.busmap.service.StationService;
import java.util.List;
import java.util.Map;
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
    public void addOrUpdate(Station station) {
        this.stationRepository.addOrUpdate(station);
    }

    @Override
    public Station getStationById(int id) {
        return this.stationRepository.getStationById(id);
    }

    @Override
    public void deleteStation(int id) {
        this.stationRepository.deleteStation(id);
    }

    @Override
    public List<Station> getStations(Map<String, String> params) {
        return this.stationRepository.getStations(params);
    }

    
    
}
