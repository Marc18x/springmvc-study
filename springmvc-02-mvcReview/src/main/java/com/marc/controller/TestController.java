package com.marc.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author marc
 * @date 2022/6/1
 */
public class TestController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 模型与视图
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", "testSpringMVC");
        modelAndView.setViewName("test");

        return modelAndView;
    }
}
