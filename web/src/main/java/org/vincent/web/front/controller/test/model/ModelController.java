package org.vincent.web.front.controller.test.model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by PengRong on 2018/8/17.
 * 返回 ：test/model/models.jsp
 */
@Controller
public class ModelController {
    /** 对于model 测试类 页面基于 InternalResourceViewResolver 视图解析器定义的基目录的相对路径 */
    private  String prefix="test/model/";


    @RequestMapping(value = "/model",method = RequestMethod.GET)
    public  String viewModel(HttpServletRequest request){
        String method=request.getMethod();
        System.out.println(method);
        //返回试图 jsp
        return prefix+"models";
    }

    /**
     * 对于models.jsp 页面里面的跳转进行动态跳转相应的页面.
     * @RequestMapping(value="/{formName}") 这种页面跳转方式有问题，原来的controller也会被这个方法拦截
     * 使用下面关于 jumpToJspx的三个方法响应 models.jsp 中三个<a> </a> 标签跳转
     * @param formName
     * @return
     */
    /*@RequestMapping(value="/{formName}")
    public  String jumpToJsp(@PathVariable String formName){
        return prefix+formName;
    }*/


    /**
     * loginModel1.jsp页面 controller 处理请求函数
     * @return
     */
    @RequestMapping(value="/loginModel1")
    public  String jumpToJsp1( ){
        return prefix+"loginModel1";
    }
    /**
     * loginModel2.jsp页面 controller 处理请求函数
     * @return
     */
    @RequestMapping(value="/loginModel2")
    public  String jumpToJsp2( ){
        return prefix+"loginModel2";
    }
    /**
     * loginModel3.jsp页面 controller 处理请求函数,
     *
     * @return
     */
    @RequestMapping(value="/loginModel3")
    public  String jumpToJsp3( ){
        return prefix+"loginModel3";
    }
}
