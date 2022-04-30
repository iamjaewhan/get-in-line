package com.jay.getinline.controller;

import com.jay.getinline.exception.GeneralException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController {

    @GetMapping("/")
    public String root(){
        return "index";
    }



}
