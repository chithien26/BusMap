/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmap.repository.impl;

import com.busmap.pojo.Route;
import com.busmap.pojo.RouteStation;
import com.busmap.pojo.Station;
import com.busmap.repository.RouteRepository;
import com.busmap.service.StationService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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
public class RouteRepositoryImpl implements RouteRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Autowired
    private StationService stationService;

    @Override
    public List<Route> getRoutes(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Route> q = b.createQuery(Route.class);
        Root root = q.from(Route.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();

            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                Predicate p = b.or(
                        b.like(root.get("id").as(String.class), String.format("%%%s%%", kw)),
                        b.like(root.get("name"), String.format("%%%s%%", kw)));
                predicates.add(p);
            }
            if (!predicates.isEmpty()) {
                q.where(predicates.toArray(new Predicate[0]));
            }

        }

        Query<Route> query = s.createQuery(q);
        return query.getResultList();
    }

    @Override
    public Route getRouteById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Route.class, id);
    }

    @Override
    public void deleteRoute(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Route r = this.getRouteById(id);
        s.delete(r);
    }

    @Override
    public void addOrUpdate(Route route) {
        Session s = this.factory.getObject().getCurrentSession();
        s.merge(route);
//        Route r = s.get(Route.class, route.getId());
//        if(r != null)
//            s.update(route);
//        else
//            s.save(route);
    }

    @Override
    public List<Route> findRoutes(int startStationId, int endStationId) {
        Station startStation = this.stationService.getStationById(startStationId);
        Station endStation = this.stationService.getStationById(endStationId);

        Session s = this.factory.getObject().getCurrentSession();
        // Query to find routes that go through both stations
        String hql = "SELECT rs.route "
                + "FROM RouteStation rs "
                + "WHERE rs.station.id IN (:startStationId, :endStationId) "
                + "GROUP BY rs.route.id "
                + "HAVING COUNT(DISTINCT rs.station.id) = 2";

        // Execute query and return result
        List<Route> routes = s.createQuery(hql, Route.class)
                .setParameter("startStationId", startStationId)
                .setParameter("endStationId", endStationId)
                .getResultList();

        return routes;

    }
    
    @Override
    public List<Station> getStationsInRoute(int routeId, int startStationId, int endStationId) {
        Session s = this.factory.getObject().getCurrentSession();
        String startOrderHql = "SELECT rs.order FROM RouteStation rs "
                + "WHERE rs.route.id = :routeId AND rs.station.id = :startStationId";
        Integer startOrder = s.createQuery(startOrderHql, Integer.class)
                .setParameter("routeId", routeId)
                .setParameter("startStationId", startStationId)
                .uniqueResult();

        // Truy vấn để lấy giá trị order của endStation
        String endOrderHql = "SELECT rs.order FROM RouteStation rs "
                + "WHERE rs.route.id = :routeId AND rs.station.id = :endStationId";
        Integer endOrder = s.createQuery(endOrderHql, Integer.class)
                .setParameter("routeId", routeId)
                .setParameter("endStationId", endStationId)
                .uniqueResult();

        // Đảm bảo giá trị order hợp lệ trước khi truy vấn các trạm
        if (startOrder == null || endOrder == null || startOrder > endOrder) {
            return new ArrayList<>(); // Trả về danh sách trống nếu không tìm thấy hoặc thứ tự không hợp lệ
        }

        // Truy vấn lấy danh sách các trạm theo thứ tự từ startStation đến endStation
        String stationsHql = "SELECT rs.station FROM RouteStation rs "
                + "WHERE rs.route.id = :routeId AND rs.order BETWEEN :startOrder AND :endOrder "
                + "ORDER BY rs.order";
        List<Station> stations = s.createQuery(stationsHql, Station.class)
                .setParameter("routeId", routeId)
                .setParameter("startOrder", startOrder)
                .setParameter("endOrder", endOrder)
                .getResultList();

        return stations;
    }

    @Override
    public List<Station> getAllStationsInRoute(int routeId) {
        Session s = this.factory.getObject().getCurrentSession();
        String stationsHql = "SELECT rs.station FROM RouteStation rs "
                + "WHERE rs.route.id = :routeId"
                + "ORDER BY rs.order";
        List<Station> stations = s.createQuery(stationsHql, Station.class)
                .setParameter("routeId", routeId)
                .getResultList();
        return stations;
    }

}
