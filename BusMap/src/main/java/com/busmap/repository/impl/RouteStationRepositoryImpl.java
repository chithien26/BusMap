/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmap.repository.impl;

import com.busmap.pojo.Route;
import com.busmap.pojo.RouteStation;
import com.busmap.repository.RouteStationRepository;
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
public class RouteStationRepositoryImpl implements RouteStationRepository{

    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Override
    public List<RouteStation> getRouteStaion(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<RouteStation> q = b.createQuery(RouteStation.class);
        Root root = q.from(RouteStation.class);
        q.select(root);
        
        if(params != null){
            List<Predicate> predicates = new ArrayList<>();
            
            String kw = params.get("kw");
            if(kw != null && !kw.isEmpty()){
                Predicate p = b.or(
                        b.like(root.get("routeid").as(String.class), String.format("%%%s%%", kw)), 
                        b.like(root.get("stationId"), String.format("%%%s%%", kw)));
                predicates.add(p);
            }
            if (!predicates.isEmpty()) {
                q.where(predicates.toArray(new Predicate[0]));
            }
            
        }
        
        Query<RouteStation> query = s.createQuery(q);
        return query.getResultList();
    }
    

    @Override
    public void addOrUpdate(RouteStation routeStation) {
        Session s = this.factory.getObject().getCurrentSession();
        s.merge(routeStation);
    }

    @Override
    public RouteStation getRouteStationById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(RouteStation.class, id);
    }

    @Override
    public void deleteRouteStation(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        RouteStation r = this.getRouteStationById(id);
        s.delete(r);
    }
    
}