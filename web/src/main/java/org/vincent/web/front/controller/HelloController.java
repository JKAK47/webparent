package org.vincent.web.front.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by PengRong on 2018/8/6.
 * 这个controller 处理的jsp 是 /pages/hello.jsp,传递数据给hello.jsp 视图文件
 */
@Controller
public class HelloController {
    /**
     * @RequestMapping 注解用于映射一个请求到该注解所注解的方法。
     *  http://localhost:8080/web-front/ 首页请求响应
     * @param model
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {

        model.addAttribute("msg", "Spring 3 MVC Hello World");
        //返回默认视图名称
        return "hello";

    }

    @RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
    public ModelAndView hello(@PathVariable("name") String name) {
        /**
         * 设置一个视图和 模型的ModelAndView 对象。
         */
        ModelAndView model = new ModelAndView();
		    /* 设置一个jsp视图名称 */
        model.setViewName("hello");
        /* 设置属性 在jsp页面通过
         *  ${requestScope.msg} 获取值
          * */
        model.addObject("msg", name);

        return model;

    }
}
