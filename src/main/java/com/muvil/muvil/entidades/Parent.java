package com.muvil.muvil.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;




@Entity
@Table(name="Parent")
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idparent")
    private Integer idParent;
    @Column(name = "mail")
    private String mail;
    @Column(name = "password")
    private String password;
    @Column(name = "parentname")
    private String parentName;
    @Column(name = "childname")
    private String childName;
    @Column(name = "latitude")
    private double latitude;
    @Column(name = "longitude")
    private double longitude;
    @Column(name = "status")
    private Integer status;
    @Column(name = "adress")
    private String adress;
    @Column(name = "district")
    private String district;
    @Column(name = "phone")
    private String phone;
    @Column (name = "operator_idoperator")
    private Integer Operator_idOperator;
    // @OneToOne
    // @JoinColumn (name = "school_idschool")
    @Column(name = "school_idschool")
    private Integer School_idSchool;

    public Integer getSchool_idSchool() {
        return this.School_idSchool;
    }

    public void setSchool_idSchool(Integer School_idSchool) {
        this.School_idSchool = School_idSchool;
    }

    // public String getSchool() {
    // return this.school.getName();
    // }

    // public void setSchool(School school) {
    // this.school = school;
    // }

    public String getMail() {
        return this.mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getParentName() {
        return this.parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getChildName() {
        return this.childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
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

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getOperator_idOperator() {
        return this.Operator_idOperator;
    }

    public void setOperator_idOperator(Integer Operator_idOperator) {
        this.Operator_idOperator = Operator_idOperator;
    }

    public Parent() {
    }

    public Integer getIdParent() {
        return idParent;
    }

    public void setIdParent(Integer idParent) {
        this.idParent = idParent;
    }
}
