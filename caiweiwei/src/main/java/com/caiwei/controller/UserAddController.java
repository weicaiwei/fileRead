package com.caiwei.controller;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caiwei.entity.User;

@Controller
@RequestMapping(value="/userAdd")
public class UserAddController {
    
    public static final Log LOG = LogFactory.getLog(UserAddController.class);
    
    @RequestMapping(method=RequestMethod.POST)
    @ResponseBody
    public Map<String,String> addUser(User user) {
        LOG.info("能走到这里吗");
        System.out.println(user.toString());
        System.out.println(user.getAge()+user.getDepartment()+user.getId());
        System.out.print("user的类型是哈："+user.getId().getClass().equals(Integer.class));
        Map<String, String> m= new HashMap<String,String>();
        m.put("hall", "nihao");
        return m;
    }
}
