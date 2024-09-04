/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmap.repository.impl;

import com.busmap.pojo.Route;
import com.busmap.pojo.Schedule;
import com.busmap.repository.ScheduleRepository;
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
public class ScheduleRepositoryImpl implements ScheduleRepository{
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Schedule> getSchedules(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Schedule> q = b.createQuery(Schedule.class);
        Root root = q.from(Schedule.class);
        q.select(root);
        
        if(params != null){
            List<Predicate> predicates = new ArrayList<>();
            
            String kw = params.get("kw");
            if(kw != null && !kw.isEmpty()){
                Predicate p = b.or(
                        b.like(root.get("id").as(String.class), String.format("%%%s%%", kw)), 
                        b.like(root.get("busTripId").as(String.class), String.format("%%%s%%", kw)), 
                        b.like(root.get("stationId"), String.format("%%%s%%", kw)));
                predicates.add(p);
            }
            if (!predicates.isEmpty()) {
                q.where(predicates.toArray(new Predicate[0]));
            }
            
        }
        
        Query<Schedule> query = s.createQuery(q);
        return query.getResultList();
    }


    @Override
    public Schedule getScheduleById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Schedule.class, id);
    }

    @Override
    public void deleteSchedule(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Schedule r = this.getScheduleById(id);
        s.delete(r);
    }

    @Override
    public void addOrUpdate(Schedule schedule) {
        Session s = this.factory.getObject().getCurrentSession();
        s.merge(schedule);
//        Route r = s.get(Route.class, route.getId());
//        if(r != null)
//            s.update(route);
//        else
//            s.save(route);
    }

    
}
