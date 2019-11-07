package com.gctchina.demo.web.controller;

//import com.gctchina.data_arc.dao.mapper.OwnerMapper;
import com.gctchina.demo.dao.Student;
import com.gctchina.demo.dao.entity.Owner;
import com.gctchina.demo.dao.repository.pri.OwnerRepositoryA;
import com.gctchina.demo.dao.repository.sec.OwnerRepositoryB;
import com.gctchina.demo.service.ifs.ILogin;
import com.gctchina.demo.service.impl.LoginImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class MainController {


    private static final Logger LOG = LoggerFactory.getLogger(MainController.class);

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String hello() {
        return "home.jsp";
    }
}

