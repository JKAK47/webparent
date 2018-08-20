package org.vincent.web.front.controller.test.model;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by PengRong on 2018/8/17.
 */
@Controller
public class login2Controller {
    @ModelAttribute
    public void userMode2(String loginname,String password,
                          ModelMap mv){
        System.out.println("-------------userMode---.-------");
        User user = new User();
        user.setLoginname(loginname);
        user.setPassword(password);
        // 将User对象添加到ModelMap当中
        mv.addAttribute("user", user);
    }



    @RequestMapping(value="/login2")
    public String login2(ModelMap modelMap){
        System.out.println("login2");
        // 从ModelMap当中取出之前存入的名为user的对象
        User user = (User) modelMap.get("user");
        System.out.println(user);
        // 设置user对象的username属性
        user.setUsername("测试2");
        return "test/model/result2";
    }


}
