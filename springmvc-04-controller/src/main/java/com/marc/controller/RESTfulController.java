package com.marc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.reflect.Method;

/**
 * @author marc
 * @date 2022/6/3
 */

/**
 * 使用RESTful风格实现传参，以及通过不同的的请求方式对同一路径进行请求访问，对应执行不同的的结果
 */
@Controller
public class RESTfulController {

    /**
     * 使用get请求方式传参
     *
     * @param a
     * @param b
     * @param model 模型，用于保存中间值，传递给ViewResolver进行图像渲染
     * @return
     */
    @RequestMapping(value = "/calc/{a}/{b}", method = RequestMethod.GET)
    public String test1(@PathVariable int a, @PathVariable int b, Model model) {
        model.addAttribute("result", a + b);
        return "result";
    }

    /**
     * 使用post亲戚请求方式传参
     *
     * @param a
     * @param b
     * @param model
     * @return
     */
    @RequestMapping(value = "/calc/{a}/{b}", method = RequestMethod.POST)
    public String test2(@PathVariable int a, @PathVariable int b, Model model) {
        model.addAttribute("result", a + b + 1);
        return "result";
    }

    /**
     * 跳转到post.jsp
     *
     * @return
     */
    @RequestMapping("post")
    public String postPage() {
        return "post";
    }
}
