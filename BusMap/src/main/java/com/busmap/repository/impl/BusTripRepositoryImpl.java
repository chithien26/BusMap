/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmap.repository.impl;

import com.busmap.pojo.BusTrip;
import com.busmap.pojo.Route;
import com.busmap.repository.BusTripRepository;
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
public class BusTripRepositoryImpl implements BusTripRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<BusTrip> getBusTrips(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<BusTrip> q = b.createQuery(BusTrip.class);
        Root root = q.from(BusTrip.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();

            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                Predicate p = b.or(
                        b.like(root.get("id").as(String.class), String.format("%%%s%%", kw)),
                        b.like(root.get("route_id"), String.format("%%%s%%", kw)));
                predicates.add(p);
            }
            if (!predicates.isEmpty()) {
                q.where(predicates.toArray(new Predicate[0]));
            }

        }

        Query<BusTrip> query = s.createQuery(q);
        return query.getResultList();
    }

    @Override
    public void addOrUpdate(BusTrip busTrip) {
        Session s = this.factory.getObject().getCurrentSession();
        s.merge(busTrip);
//        Route r = s.get(Route.class, route.getId());
//        if(r != null)
//            s.update(route);
//        else
//            s.save(route);
    }

    @Override
    public BusTrip getBusTripById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(BusTrip.class, id);
    }

    @Override
    public void deleteBusTrip(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        BusTrip r = this.getBusTripById(id);
        s.delete(r);
    }
}
