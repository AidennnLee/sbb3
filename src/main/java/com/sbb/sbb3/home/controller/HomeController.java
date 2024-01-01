package com.sbb.sbb3.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @GetMapping("/sbb")
    @ResponseBody
    public String home(){
        return "Hello SBB";
    }

    @GetMapping("/")
    public String root(){
        return "redirect:/question/list";
    }
}
