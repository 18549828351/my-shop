package com.gctchina.demo.dao.entity;

import lombok.Data;

import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.PrintConversionEvent;
import java.security.PrivateKey;

@Entity
public class Owner {

    @Column(nullable = true)
    private String  Ownername;

    @Column(nullable = true)
    private String Description;

    @Id
    @GeneratedValue
    private String  Ownerid;

    public Owner() {
    }

    public Owner(String ownername, String description) {
        Ownername = ownername;
        Description = description;
    }

    public String getOwnername() {
        return Ownername;
    }

    public void setOwnername(String ownername) {
        Ownername = ownername;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getOwnerid() {
        return Ownerid;
    }

    public void setOwnerid(String ownerid) {
        Ownerid = ownerid;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "Ownername='" + Ownername + '\'' +
                ", Description='" + Description + '\'' +
                ", Ownerid='" + Ownerid + '\'' +
                '}';
    }
}
