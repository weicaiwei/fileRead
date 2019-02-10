package com.caiwei.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caiwei.dao.StaffDao;
import com.caiwei.entity.StaffInfo;
import com.caiwei.utils.Result;
import com.caiwei.utils.ResultUtil;

@Controller
public class StaffInfoController {
    
    @Autowired
    StaffDao loginMapper;
    
    @Autowired
    HttpSession session;
    
    /**
      * 获取员工的详细个人信息
     */
    @RequestMapping("staffinfo")
    @ResponseBody
    public Result queryStaffInfo() {
        String staffId = (String) session.getAttribute("staffId");
        StaffInfo staffInfo = loginMapper.queryStaffInfo(staffId);
        return ResultUtil.success(staffInfo);
        
    }

}
