package com.satoken.controller;

import cn.dev33.satoken.stp.StpUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/upload/")
//http://localhost:8081/upload/video/
public class UploadVideo {
    @RequestMapping("video")
            public String video()
{
    String name= (String) StpUtil.getSession().get("name");
    String password=(String) StpUtil.getSession().get("password");
    return "name:"+name+"password:"+password;
}

}
