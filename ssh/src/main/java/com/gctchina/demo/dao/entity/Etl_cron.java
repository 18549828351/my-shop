package com.gctchina.demo.dao.entity;

import com.gctchina.demo.dao.config.PrimaryConfig;
import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.persistence.*;
import java.security.PrivateKey;

@Entity
@Table(name = "Etl_cron")
public class Etl_cron {

    //@GeneratedValue
    @Id
    private String Id;

    @Column(name = "Crondesc")
    private String Crondesc;

    @Column(nullable = false)
    private String Cronstr;

    @Column(nullable = true)
    private String Lasttimekey;

    @Column(nullable = true)
    private Boolean Enable;

    public Etl_cron() {
    }

    public Etl_cron(String id) {
        Id = id;
    }

    public Etl_cron(String id, String crondesc, String cronstr, String lasttimekey, Boolean enable) {
        Id = id;
        Crondesc = crondesc;
        Cronstr = cronstr;
        Lasttimekey = lasttimekey;
        Enable = enable;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getCrondesc() {
        return Crondesc;
    }

    public void setCrondesc(String crondesc) {
        Crondesc = crondesc;
    }

    public String getCronstr() {
        return Cronstr;
    }

    public void setCronstr(String cronstr) {
        Cronstr = cronstr;
    }

    public String getLasttimekey() {
        return Lasttimekey;
    }

    public void setLasttimekey(String lasttimekey) {
        Lasttimekey = lasttimekey;
    }

    public Boolean getEnable() {
        return Enable;
    }

    public void setEnable(Boolean enable) {
        Enable = enable;
    }

    @Override
    public String toString() {
        return "Etl_cron{" +
                "Id='" + Id + '\'' +
                ", Crondesc='" + Crondesc + '\'' +
                ", Cronstr='" + Cronstr + '\'' +
                ", Lasttimekey='" + Lasttimekey + '\'' +
                ", Enable=" + Enable +
                '}';
    }
}
//USE [SAMO]
//        GO
//
///****** Object:  Table [dbo].[ETL_CRON]    Script Date: 2019/11/6 23:58:04 ******/
//        SET ANSI_NULLS ON
//        GO
//
//        SET QUOTED_IDENTIFIER ON
//        GO
//
//        CREATE TABLE [dbo].[ETL_CRON](
//        [id] [varchar](50) NOT NULL,
//        [crondesc] [varchar](50) NULL,
//        [cronstr] [varchar](50) NOT NULL,
//        [lasttimekey] [varchar](50) NOT NULL,
//        [Enable] [bit] NULL,
//        CONSTRAINT [PK_ETL_CRON] PRIMARY KEY CLUSTERED
//        (
//        [id] ASC
//        )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
//        ) ON [PRIMARY]
//        GO
//
//
