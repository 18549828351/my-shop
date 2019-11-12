package com.gctchina.demo.web.controller;

//import com.gctchina.data_arc.dao.mapper.OwnerMapper;
import com.gctchina.demo.dao.Student;
import com.gctchina.demo.dao.entity.Etl_cron;
import com.gctchina.demo.dao.entity.Owner;
import com.gctchina.demo.dao.repository.pri.OwnerRepositoryA;
import com.gctchina.demo.dao.repository.sec.Etl_cronRepositoryB;
import com.gctchina.demo.dao.repository.sec.OwnerRepositoryB;
import com.gctchina.demo.service.ifs.ILogin;
import com.gctchina.demo.service.impl.LoginImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Controller
public class MainController {

    private String cronId="1001";

    @Autowired      //注入mapper
    @SuppressWarnings("all")
    Etl_cronRepositoryB etl_cronRepositoryB;

    private static final Logger LOG = LoggerFactory.getLogger(MainController.class);

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String hello() {
        return "home.jsp";
    }

    @RequestMapping(value = "/page2",method = RequestMethod.GET)
    public String page2() {
        return "page2.jsp";
    }


    @ResponseBody
    @RequestMapping(value = "/sendMsg.do",method = RequestMethod.POST)
    public Etl_cron sendMessage(String strInMsg ) {
        LOG.info(strInMsg);
        Optional<Etl_cron> etl_cron = etl_cronRepositoryB.findById(cronId);
        return etl_cron.get();
    }
}

