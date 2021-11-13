package com.muvil.muvil.entidades;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VehiculeLocation")
public class VehiculeLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "idvehiculelocation")
    private Integer idVehiculeLocation;
    @Column (name = "latitude")
    private double latitude;
    @Column (name = "longitude")
    private double longitude;
    @Column (name = "timestamp")
    private Date timestamp;
    @Column (name = "course_idcourse")
    private Integer Course_idCourse;

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getCourse_idCourse() {
        return this.Course_idCourse;
    }

    public void setCourse_idCourse(Integer Course_idCourse) {
        this.Course_idCourse = Course_idCourse;
    }

    public VehiculeLocation() {
    }

    public Integer getIdVehiculeLocation() {
        return idVehiculeLocation;
    }

    public void setIdVehiculeLocation(Integer idVehiculeLocation) {
        this.idVehiculeLocation = idVehiculeLocation;
    }
}
