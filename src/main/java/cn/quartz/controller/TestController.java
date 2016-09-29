package cn.quartz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wenqi
 */
@Controller
public class TestController {
    @RequestMapping("/test")
    public String test(){
        return "test";
    }
}
