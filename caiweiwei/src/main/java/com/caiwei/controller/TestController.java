package com.caiwei.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {
	@RequestMapping
	@ResponseBody
    public Map<String,String> hello(){
		Map<String,String> map = new HashMap<String,String>();
		map.put("hello", "world");
		return map;
    	
    }
	 
}
