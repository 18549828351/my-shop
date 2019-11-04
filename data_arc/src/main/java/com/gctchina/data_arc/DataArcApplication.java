package com.gctchina.data_arc;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.gctchina.data_arc.dao.mapper")
public class DataArcApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataArcApplication.class, args);
    }

}
