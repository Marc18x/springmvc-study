package com.marc.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author marc
 * @date 2022/5/24
 */
public class HelloController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // ModelAndView 模型和视图
        ModelAndView mv = new ModelAndView();

        // 封装对象，放在ModelAndView中
        mv.addObject("msg","HelloSpringMVC");
        // 封装要跳转的视图，放在modelAndView
        mv.setViewName("hello");
        return mv;
    }
}
