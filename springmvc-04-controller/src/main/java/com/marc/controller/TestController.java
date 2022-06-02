package com.marc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author marc
 * @date 2022/6/2
 */
@Controller
public class TestController {

    @RequestMapping("/test/t1")
    public String test1(Model model){
        model.addAttribute("msg","dir:\\test\\t1");
        return "test";
    }

    @RequestMapping("/test/t2")
    public String test2(Model model){
        model.addAttribute("msg","dir:\\test\\t2");
        return "test";
    }
}
