package com.sbb.sbb3;

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
}
