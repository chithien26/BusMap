/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmap.repository.impl;

import com.busmap.pojo.Route;
import com.busmap.pojo.Station;
import com.busmap.repository.StationRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
    public List<Station> getStations(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Station> q = b.createQuery(Station.class);
        Root root = q.from(Station.class);
        q.select(root);
        
        if(params != null){
            List<Predicate> predicates = new ArrayList<>();
            
            String kw = params.get("kw");
            if(kw != null && !kw.isEmpty()){
                Predicate p = b.like(root.get("name"), String.format("%%%s%%", kw));
                predicates.add(p);
            }
            if (!predicates.isEmpty()) {
                q.where(predicates.toArray(new Predicate[0]));
            }
        }
        
        Query<Station> query = s.createQuery(q);
        return query.getResultList();
        
    }

 

    @Override
    public Station getStationById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Station.class, id);
    }

    @Override
    public void deleteStation(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Station sta = this.getStationById(id);
        s.delete(sta);
    }


    @Override
    public void addOrUpdate(Station station) {
        Session s = this.factory.getObject().getCurrentSession();
        if (station.getId() != null) {
            s.update(station);
        } else {
            s.save(station);
        }
    }
    
}
