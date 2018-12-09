package com.caiwei.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.caiwei.dao.StaffDao;
import com.caiwei.utils.Result;
import com.caiwei.utils.ResultUtil;

@Controller
@RequestMapping(value="staff")
public class LoginController {

    @Autowired
    StaffDao loginMapper;
    @Autowired
    HttpSession session;
    
    /*
     * 登录检查
     */
    @RequestMapping(value="checkLogin",method =RequestMethod.POST)
    @ResponseBody
    public Result checkLogin(String staffId,String password){
        Map<String, String> map = new HashMap<String,String>();
        map.put("staffId", staffId);
        map.put("password", password);
        String result = loginMapper.queryStaff(map);
        if (result==null) {
            System.out.println(JSON.toJSON(ResultUtil.fail()));
            return ResultUtil.fail();
        }else {
            session.setAttribute("staffId", staffId);
            System.out.println(session.getAttribute("staffId"));
            System.out.println(JSON.toJSON(ResultUtil.success("")));
            return ResultUtil.success("");
        }       
    }
    
}
