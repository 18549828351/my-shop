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
public class LoginController {

    @Autowired
    private ILogin iLogin;

    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value="login",method = RequestMethod.POST)
    public String hello(HttpServletRequest req, HttpServletResponse resp, Model m) {

        if(iLogin.Login(req.getParameter("email"),req.getParameter("password")))
        {
            req.getSession().setAttribute("user",req.getParameter("email"));
            LOG.info(" ipAddr: "+req.getRemoteAddr()+" username: "+req.getParameter("email")+" 登陆成功");
            return "redirect:/home";
        }
        else
        {
            LOG.error(" ipAddr: "+req.getRemoteAddr()+" username: "+req.getParameter("email")+" 登陆失败");
            m.addAttribute("msg","密码错误");
            return Login(req,m);
        }
    }
    @RequestMapping(value = {"","login"},method = RequestMethod.GET)
    public String Login(HttpServletRequest req,Model m) {
        LOG.info(" ipAddr: "+req.getRemoteAddr()+" 打开系统登陆页");
        return "login.jsp";
    }
}

