package com.marc.controller;

import org.apache.commons.logging.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author marc
 * @date 2022/6/1
 */
@Controller

public class HelloController {

    @RequestMapping(value = "/h1", method = RequestMethod.GET)
    public String hello(Model model,
                        @RequestParam("name") String name) {
        System.out.println("catch name： "+name);
        //  封装数据 Model
        model.addAttribute("msg", "helloSpringMVC-annotation");
        model.addAttribute("name", name);
        return "test";  // 会被视图解析器处理 -> /WEB-INF/jsp/test.jsp
    }
}
