package com.gctchina.demo.controller;

//import com.gctchina.data_arc.dao.mapper.OwnerMapper;
import com.gctchina.demo.dao.Student;
import com.gctchina.demo.dao.entity.Owner;
import com.gctchina.demo.dao.repository.pri.OwnerRepositoryA;
import com.gctchina.demo.dao.repository.sec.OwnerRepositoryB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private OwnerRepositoryA ownerRepositoryA;

    @Autowired
    private OwnerRepositoryB ownerRepositoryB;

    @Autowired
    private Student std;

    private static final Logger LOG = LoggerFactory.getLogger(MainController.class);

    @RequestMapping("/hello")
    public String hello(Model m) {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Owner ownerA =ownerRepositoryA.findAll().get(0);
        Owner ownerB =ownerRepositoryB.findAll().get(0);

        LOG.info(ownerA.toString());
        LOG.info(ownerB.toString());
        LOG.error("----------------------------------------------------------");
        m.addAttribute("now",sdf.format(d));
        m.addAttribute("bbb",std.getAge());
        m.addAttribute("ccc",ownerA.toString());
        m.addAttribute("ddd",ownerB.toString());
        return "hello";
    }
}

