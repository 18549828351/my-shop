package com.gctchina.data_arc;

import com.gctchina.data_arc.dao.entity.Owner;
import com.gctchina.data_arc.dao.mapper.OwnerMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class DataArcApplicationTests {

    @Autowired
    private OwnerMapper ownerMapper;
    @Test
    void contextLoads() {


    }

}
