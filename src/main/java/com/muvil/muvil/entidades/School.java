package com.muvil.muvil.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="School")
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "idschool")
    private Integer idSchool;
    @Column (name = "latitude")
    private double latitude;
    @Column (name = "longitude")
    private double longitude;
    @Column (name = "adress")
    private String adress;
    @Column (name = "district")
    private String district;
    @Column (name = "operator_idoperator")
    private Integer Operator_idOperator;
    @Column (name = "name")
    private String name;

    public Integer getIdSchool() {
        return this.idSchool;
    }

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

    public String getAdress() {
        return this.adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getDistrict() {
        return this.district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Integer getOperator_idOperator() {
        return this.Operator_idOperator;
    }

    public void setOperator_idOperator(Integer Operator_idOperator) {
        this.Operator_idOperator = Operator_idOperator;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public School() {
    }

    public void setIdSchool(Integer idSchool) {
        this.idSchool = idSchool;
    }
}
