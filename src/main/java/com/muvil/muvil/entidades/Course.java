package com.muvil.muvil.entidades;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "idcourse")
    private Integer idCourse;
    @Column (name = "date")
    private Date date;
    @Column (name = "operator_idoperator")
    private Integer Operator_idOperator;
    @Column (name = "lastgpsstatus")
    private Integer lastGpsStatus;
    @Column (name = "lastcamarastatus")
    private Integer lastCamaraStatus;
    @Column (name = "videofeedurl")
    private String videoFeedURL;
    //@JsonIgnore
    @OneToMany(mappedBy = "Course_idCourse")
    private Set<VehiculeLocation> todaysLocations;

    public Integer getLastGpsStatus() {
        return this.lastGpsStatus;
    }

    public void setLastGpsStatus(Integer lastGpsStatus) {
        this.lastGpsStatus = lastGpsStatus;
    }

    public Set<VehiculeLocation> getTodaysLocations() {
        return this.todaysLocations;
    }

    public void setTodaysLocations(Set<VehiculeLocation> todaysLocations) {
        this.todaysLocations = todaysLocations;
    }

    public Integer getLastgpsstatus() {
        return this.lastGpsStatus;
    }

    public void setLastgpsstatus(Integer lastGpsStatus) {
        this.lastGpsStatus = lastGpsStatus;
    }

    public Integer getLastCamaraStatus() {
        return this.lastCamaraStatus;
    }

    public void setLastCamaraStatus(Integer lastCamaraStatus) {
        this.lastCamaraStatus = lastCamaraStatus;
    }

    public String getVideoFeedURL() {
        return this.videoFeedURL;
    }

    public void setVideoFeedURL(String videoFeedURL) {
        this.videoFeedURL = videoFeedURL;
    }

    public void setIdCourse(Integer idCourse) {
        this.idCourse = idCourse;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getOperator_idOperator() {
        return this.Operator_idOperator;
    }

    public void setOperator_idOperator(Integer Operator_idOperator) {
        this.Operator_idOperator = Operator_idOperator;
    }

    public Course() {
    }

    public Integer getIdCourse() {
        return idCourse;
    }

    public void setiIdCourse(Integer idCourse) {
        this.idCourse = idCourse;
    }
}
