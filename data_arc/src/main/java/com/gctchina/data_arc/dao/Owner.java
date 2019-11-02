package com.gctchina.data_arc.dao;

import javax.xml.bind.PrintConversionEvent;
import java.security.PrivateKey;

public class Owner {

    private String  OwnerName;
    private String Description;
    private String  OwnerId;

    public String getOwnerName() {
        return OwnerName;
    }

    public void setOwnerName(String ownerName) {
        OwnerName = ownerName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getOwnerId() {
        return OwnerId;
    }

    public void setOwnerId(String ownerId) {
        OwnerId = ownerId;
    }
}
