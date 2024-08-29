/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmap.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lechi
 */
@Entity
@Table(name = "route")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Route.findAll", query = "SELECT r FROM Route r"),
    @NamedQuery(name = "Route.findById", query = "SELECT r FROM Route r WHERE r.id = :id"),
    @NamedQuery(name = "Route.findByName", query = "SELECT r FROM Route r WHERE r.name = :name"),
    @NamedQuery(name = "Route.findByFirstTripTime", query = "SELECT r FROM Route r WHERE r.firstTrip = :firstTrip"),
    @NamedQuery(name = "Route.findByLastTripTime", query = "SELECT r FROM Route r WHERE r.lastTrip = :lastTrip"),
    @NamedQuery(name = "Route.findByFare", query = "SELECT r FROM Route r WHERE r.fare = :fare"),
    @NamedQuery(name = "Route.findByCreatedDate", query = "SELECT r FROM Route r WHERE r.createdDate = :createdDate"),
    @NamedQuery(name = "Route.findByActive", query = "SELECT r FROM Route r WHERE r.active = :active")})
public class Route implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull(message = "{route.name.notNull}")
    @Size(min = 1, max = 50, message = "{route.name.errMsg}")
    @Column(name = "name")
    private String name;
    @Column(name = "first_trip")
//    @Temporal(TemporalType.TIME)
    private LocalTime firstTrip;
    @Column(name = "last_trip")
//    @Temporal(TemporalType.TIME)
    private LocalTime lastTrip;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "fare")
    private BigDecimal fare;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "active")
    private Boolean active;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "routeId")
    private Set<RouteStation> routeStationSet;
    @OneToMany(mappedBy = "routeId")
    private Set<Favourite> favouriteSet;
    @OneToMany(mappedBy = "routeId")
    private Set<BusTrip> busTripSet;

    public Route() {
    }

    public Route(Integer id) {
        this.id = id;
    }

    public Route(Integer id, String name, BigDecimal fare) {
        this.id = id;
        this.name = name;
        this.fare = fare;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalTime getFirstTrip() {
        return firstTrip;
    }

    public void setFirstTrip(LocalTime firstTripTime) {
        this.firstTrip = firstTripTime;
    }

    public LocalTime getLastTrip() {
        return lastTrip;
    }

    public void setLastTrip(LocalTime lastTripTime) {
        this.lastTrip = lastTripTime;
    }

    public BigDecimal getFare() {
        return fare;
    }

    public void setFare(BigDecimal fare) {
        this.fare = fare;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @XmlTransient
    public Set<RouteStation> getRouteStationSet() {
        return routeStationSet;
    }

    public void setRouteStationSet(Set<RouteStation> routeStationSet) {
        this.routeStationSet = routeStationSet;
    }

    @XmlTransient
    public Set<Favourite> getFavouriteSet() {
        return favouriteSet;
    }

    public void setFavouriteSet(Set<Favourite> favouriteSet) {
        this.favouriteSet = favouriteSet;
    }

    @XmlTransient
    public Set<BusTrip> getBusTripSet() {
        return busTripSet;
    }

    public void setBusTripSet(Set<BusTrip> busTripSet) {
        this.busTripSet = busTripSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Route)) {
            return false;
        }
        Route other = (Route) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.busmap.pojo.Route[ id=" + id + " ]";
    }
    
}
