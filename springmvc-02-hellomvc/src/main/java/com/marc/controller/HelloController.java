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
    /**
     * 处理请求
     *
     * @param request
     * @param response
     * @return modelAndView对象 交给dispatchServlet进行页面渲染
     * @throws Exception 异常
     */
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // ModelAndView 模型和视图
        ModelAndView mv = new ModelAndView();

        // 封装对象，放在ModelAndView中
        mv.addObject("msg", "HelloSpringMVC");
        mv.addObject("title", "测试页面");
        // 封装要跳转的视图，放在modelAndView
        mv.setViewName("hello");
        return mv;
    }
}
