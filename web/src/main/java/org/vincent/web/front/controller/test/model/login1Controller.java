package org.vincent.web.front.controller.test.model;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by PengRong on 2018/8/17.
 */
@Controller
public class login1Controller {
    @ModelAttribute
    public void userMode11(String loginname,String password,
                          Model mv){
        System.out.println("-------------userMode----------");
        User user = new User();
        user.setLoginname(loginname);
        user.setPassword(password);
        // 将User对象添加到Model当中
        mv.addAttribute("user", user);
    }

    @RequestMapping(value="/login1")
    public String login1(Model model){
        System.out.println("login");
        // 从Model当中取出之前存入的名为user的对象
        User user = (User) model.asMap().get("user");
        System.out.println(user);
        // 设置user对象的username属性
        user.setUsername("测试1");
        return "test/model/result1";
    }




}
