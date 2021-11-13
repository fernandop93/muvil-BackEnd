package com.muvil.muvil.entidades;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "idnotification")
    private Integer idNotification;
    @Column (name = "content")
    private String content;
    @Column (name = "type")
    private Integer type;
    @Column (name = "date")
    private Date date;
    @Column (name = "parent_idparent")
    private Integer Parent_idParent;

    public Integer getIdNotification() {
        return this.idNotification;
    }

    public void setIdNotification(Integer idNotification) {
        this.idNotification = idNotification;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getParent_idParent() {
        return this.Parent_idParent;
    }

    public void setParent_idParent(Integer Parent_idParent) {
        this.Parent_idParent = Parent_idParent;
    }

    public Notification() {
    }

    public Integer sgetiIdNotification() {
        return idNotification;
    }

    public void setiIdNotification(Integer idNotification) {
        this.idNotification = idNotification;
    }
}
