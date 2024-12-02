package com.satoken.controller;

import cn.dev33.satoken.util.SaResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalException {
    @ExceptionHandler
    public SaResult handler(Exception e) {
        e.printStackTrace();
        return SaResult.error(e.getMessage());
    }
}
