package com.satoken.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SaTokenConfigure implements WebMvcConfigurer {

    private final CustomInterceptor customInterceptor;

    public SaTokenConfigure(CustomInterceptor customInterceptor) {
        this.customInterceptor = customInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册自定义拦截器，校验规则为 StpUtil.checkLogin() 登录校验。
        registry.addInterceptor(customInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/user/doLogin","acc/doLogin");
    }
}
