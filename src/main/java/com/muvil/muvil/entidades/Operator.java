package com.muvil.muvil.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Operator")
public class Operator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "idoperator")
    private Integer idOperator;
    @Column (name = "name")
    private String name;
    @Column (name = "password")
    private String password;
    @Column (name = "mail")
    private String mail;
    @Column (name = "createddate")
    private Date createdDate;
    @Column (name = "status")
    private int status;
    @Column (name = "phone")
    private String phone;
    @Column (name = "drivername")
    private String driverName;
    @Column (name = "driverdni")
    private String driverDNI;
    @Column (name = "drivernumber")
    private String driverNumber;
    @Column (name = "vehiclebrand")
    private String vehicleBrand;
    @Column (name = "vehiclecolor")
    private String vehicleColor;
    @Column (name = "vehiclemodel")
    private String vehicleModel;
    @Column (name = "vehicleplate")
    private String vehiclePlate;
    @Column (name = "servicestart")
    private String serviceStart;
    @Column (name = "serviceend")
    private String serviceEnd;
    @Column (name = "ioturl")
    private String iotURL;
    // @JsonIgnore
    // @OneToMany(mappedBy = "Operator_idOperator")
    // private Set<Parent> Parents;

    // public Set<Parent> getParents() {
    //     return this.Parents;
    // }

    // public void setParents(Set<Parent> Parents) {
    //     this.Parents = Parents;
    // }

    public String getIotURL() {
        return this.iotURL;
    }

    public void setIotURL(String iotURL) {
        this.iotURL = iotURL;
    }
    
    public void setIdOperator(Integer idOperator) {
        this.idOperator = idOperator;
    }

    public String getDriverName() {
        return this.driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverDNI() {
        return this.driverDNI;
    }

    public void setDriverDNI(String driverDNI) {
        this.driverDNI = driverDNI;
    }

    public String getDriverNumber() {
        return this.driverNumber;
    }

    public void setDriverNumber(String driverNumber) {
        this.driverNumber = driverNumber;
    }

    public String getVehicleBrand() {
        return this.vehicleBrand;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    public String getVehicleColor() {
        return this.vehicleColor;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public String getVehicleModel() {
        return this.vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getVehiclePlate() {
        return this.vehiclePlate;
    }

    public void setVehiclePlate(String vehiclePlate) {
        this.vehiclePlate = vehiclePlate;
    }

    public String getServiceStart() {
        return this.serviceStart;
    }

    public void setServiceStart(String serviceStart) {
        this.serviceStart = serviceStart;
    }

    public String getServiceEnd() {
        return this.serviceEnd;
    }

    public void setServiceEnd(String serviceEnd) {
        this.serviceEnd = serviceEnd;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return this.mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Operator() {
    }

    public Integer getIdOperator() {
        return idOperator;
    }
}