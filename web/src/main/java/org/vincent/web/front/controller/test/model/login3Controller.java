package org.vincent.web.front.controller.test.model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by PengRong on 2018/8/17.
 */
@Controller
public class login3Controller {
    @ModelAttribute
    public void userMode3(String loginname,String password,
                          ModelAndView mv){
        System.out.println("-------------userMode----------");
        User user = new User();
        user.setLoginname(loginname);
        user.setPassword(password);
        // 将User对象添加到ModelAndView的Model当中
        mv.addObject("user", user);
    }





    @RequestMapping(value="/login3")
    public ModelAndView login3(ModelAndView mv){
        System.out.println("login3");
        // 从ModelAndView的Model当中取出之前存入的名为user的对象
        User user = (User) mv.getModel().get("user");
        System.out.println(user);
        // 设置user对象的username属性
        user.setUsername("测试3");
        // 通过ModelAndView 设置这个请求返回的视图JSP;
        // 设置返回的视图名称
        mv.setViewName("test/model/result3");
        return mv;
    }
}
