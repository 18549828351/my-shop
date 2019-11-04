package com.gctchina.data_arc.dao.entity;

import lombok.Data;
import org.springframework.stereotype.Repository;

import javax.xml.bind.PrintConversionEvent;
import java.security.PrivateKey;
@Data
@Repository
public class Owner {

    private String  Ownername;
    private String Description;
    private String  Ownerid;

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
