/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmap.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lechi
 */
@Entity
@Table(name = "bus_trip")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BusTrip.findAll", query = "SELECT b FROM BusTrip b"),
    @NamedQuery(name = "BusTrip.findById", query = "SELECT b FROM BusTrip b WHERE b.id = :id"),
    @NamedQuery(name = "BusTrip.findByTripNumber", query = "SELECT b FROM BusTrip b WHERE b.tripNumber = :tripNumber"),
    @NamedQuery(name = "BusTrip.findByDepartureTime", query = "SELECT b FROM BusTrip b WHERE b.departureTime = :departureTime"),
    @NamedQuery(name = "BusTrip.findByCreatedDate", query = "SELECT b FROM BusTrip b WHERE b.createdDate = :createdDate"),
    @NamedQuery(name = "BusTrip.findByActive", query = "SELECT b FROM BusTrip b WHERE b.active = :active")})
public class BusTrip implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "trip_number")
    private int tripNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "departure_time")
    @Temporal(TemporalType.TIME)
    private Date departureTime;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "active")
    private Boolean active;
    @OneToMany(mappedBy = "busTripId")
    @JsonIgnore
    private Set<Schedule> scheduleSet;
    @JoinColumn(name = "route_id", referencedColumnName = "id")
    @ManyToOne
    @JsonIgnore
    private Route routeId;
    @JsonIgnore
    @JoinColumn(name = "vehicle_id", referencedColumnName = "id")
    @ManyToOne
    private Vehicle vehicleId;

    public BusTrip() {
    }

    public BusTrip(Integer id) {
        this.id = id;
    }

    public BusTrip(Integer id, int tripNumber, Date departureTime) {
        this.id = id;
        this.tripNumber = tripNumber;
        this.departureTime = departureTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getTripNumber() {
        return tripNumber;
    }

    public void setTripNumber(int tripNumber) {
        this.tripNumber = tripNumber;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
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
    public Set<Schedule> getScheduleSet() {
        return scheduleSet;
    }

    public void setScheduleSet(Set<Schedule> scheduleSet) {
        this.scheduleSet = scheduleSet;
    }

    public Route getRouteId() {
        return routeId;
    }

    public void setRouteId(Route routeId) {
        this.routeId = routeId;
    }

    public Vehicle getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Vehicle vehicleId) {
        this.vehicleId = vehicleId;
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
        if (!(object instanceof BusTrip)) {
            return false;
        }
        BusTrip other = (BusTrip) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.busmap.pojo.BusTrip[ id=" + id + " ]";
    }
    
}
