package com.marc.servlet;

import jdk.nashorn.internal.runtime.JSONFunctions;
import org.springframework.web.servlet.mvc.method.annotation.JsonViewRequestBodyAdvice;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

/**
 * @author marc
 * @date 2022/5/24
 */
public class HelloServlet extends HttpServlet {
    // 新增方法
    private static final String OPERATION_ADD = "add";
    // 删除方法
    private static final String OPERATION_DELETE = "delete";
    // 默认方法
    public static final String OPERATION_DEFAULT = "default";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求参数
        String method = Optional.ofNullable(req.getParameter("method")).orElse("default");

        // 模拟调用业务逻辑
        try {
            if (OPERATION_ADD.equals(method)) {
                req.getSession().setAttribute("msg", "调用了add方法");
            } else if (OPERATION_DELETE.equals(method)) {
                req.getSession().setAttribute("msg", "调用了delete方法");
            } else if (OPERATION_DEFAULT.equals(method)) {
                req.getSession().setAttribute("msg", "未获取到对应参数，调用默认方法");
            }
        } catch (Exception e) {
            req.getSession().setAttribute("msg", "传参异常");
        }
        // 页面转发 绝对路径地址
        req.getRequestDispatcher("/WEB-INF/jsp/hello.jsp").forward(req, resp);
        // 重定向
        // resp.sendRedirect("/WEB-INF/jsp/hello.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // get方法
        doGet(req, resp);
    }
}
