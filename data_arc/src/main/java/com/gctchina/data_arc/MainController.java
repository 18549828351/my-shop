package com.gctchina.data_arc;

import com.gctchina.data_arc.dao.Student;
//import com.gctchina.data_arc.dao.mapper.OwnerMapper;
import com.gctchina.data_arc.dao.entity.Owner;
import com.gctchina.data_arc.dao.mapper.OwnerMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private OwnerMapper ownerMapper;

    @Autowired
    private Student std;
    @RequestMapping("/hello")
    public String hello(Model m) {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        List<Owner> ownerList = ownerMapper.selectList(null);
        Owner owner = ownerList.get(0);
        System.out.println(owner.toString());

        m.addAttribute("now",sdf.format(d));
        m.addAttribute("bbb",std.getAge());

        return "hello";
    }
}

