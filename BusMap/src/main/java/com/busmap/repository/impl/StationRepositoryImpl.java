/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmap.repository.impl;

import com.busmap.pojo.Station;
import com.busmap.repository.StationRepository;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lechi
 */
@Repository
@Transactional
public class StationRepositoryImpl implements StationRepository{
    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Override
    public List<Station> getStations() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From Station");
        return q.getResultList();
        
    }
    
}
