package com.gctchina.demo.service.impl;

import com.gctchina.demo.service.ifs.ILogin;
import org.springframework.stereotype.Service;

@Service
public class LoginImpl implements ILogin {
    @Override
    public boolean Login(String user, String pwd) {
        if("boyd.deng@gct-china.com".equals(user)&&"admin@123".equals(pwd))
        {
            return true;
        }
        return false;
    }
}
