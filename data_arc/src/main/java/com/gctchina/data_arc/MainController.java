package com.gctchina.data_arc;

import com.gctchina.data_arc.dao.Owner;
import com.gctchina.data_arc.dao.Student;
//import com.gctchina.data_arc.dao.mapper.OwnerMapper;
import com.sun.javafx.collections.MappingChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {

//    @Autowired
//    private OwnerMapper ownerMapper;
//    @Autowired
//    private Student std;
    @RequestMapping("/hello")
    public String hello(Model m) {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

//        List<Owner> ownerList= ownerMapper.findAll();


        m.addAttribute("now",sdf.format(d));
//        m.addAttribute("bbb",ownerList.get(0).getOwnerName());
        //String ccc= "Hello Spring Boot!"+std.getName()+String.valueOf(std.getAge());
        return "hello";
    }
}

