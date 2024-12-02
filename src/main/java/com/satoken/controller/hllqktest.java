package com.satoken.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@ApiOperation(value = "nihao")
@RestController
@RequestMapping("/hllqk")
@SaIgnore
public class hllqktest {
    @Value("${server.port}")
    private int port1;
    @RequestMapping("")
    @SaIgnore
    public String hllqk() {
        return "hello world"+port1;
    }
    @RequestMapping("/{id}/{name}")
    public Map<String, Object> hllqk1(@PathVariable("id") Integer id, @PathVariable("name") String name) {
        Map<String,Object> res=new HashMap<>();

        res.put("id",id);
        res.put("name",name);
        return res;
    }

}
