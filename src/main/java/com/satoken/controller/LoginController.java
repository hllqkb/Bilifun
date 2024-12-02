   package com.satoken.controller;

   import cn.dev33.satoken.stp.StpUtil;
   import cn.dev33.satoken.util.SaResult;
   import org.springframework.beans.factory.annotation.Value;
   import org.springframework.web.bind.annotation.RequestMapping;
   import org.springframework.web.bind.annotation.RestController;

   @RestController
   @RequestMapping("/acc/")
   public class LoginController {

       @Value("${server.port}")
       private int port;

       // 登录测试
       @RequestMapping("doLogin")
       public String doLogin(String name, String pwd) {
           // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
           if ("zhang".equals(name) && "123456".equals(pwd)) {
               StpUtil.login(10001);
               return "登录成功"+port;
           }
           return "登录失败";
       }

       // 测试是否登录
       @RequestMapping("isLogin")
       public SaResult isLogin() {
           return SaResult.ok("是否登录：" + StpUtil.isLogin());
       }

       // 测试注销
       @RequestMapping("logout")
       public SaResult logout() {
           StpUtil.logout();
           return SaResult.ok("注销成功");
       }

       // 查询token信息
       @RequestMapping("tokenInfo")
       public SaResult tokenInfo() {
           return SaResult.data(StpUtil.getTokenInfo());
       }
   }
   