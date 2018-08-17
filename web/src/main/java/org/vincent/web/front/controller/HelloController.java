package org.vincent.web.front.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.vincent.web.front.bean.Address;
import org.vincent.web.front.bean.Penson;

/**
 * Created by PengRong on 2018/8/6.
 * 这个controller 处理的jsp 是 /pages/hello.jsp,传递数据给hello.jsp 视图文件
 * [教程](https://blog.csdn.net/x_iya/article/details/77451559)
 */
@Controller
public class HelloController {
    /**
     * @param model
     * @return
     * @RequestMapping 注解用于映射一个请求到该注解所注解的方法。
     * http://localhost:8080/web-front/ 首页请求响应
     * RequestMapping 注解标识这个方法可以是用于处理HTTP 请求和响应的方法。
     * value 属性  设置那个URL请求映射到这个方法
     * http://localhost:8080/web-front/ 这个是域名/项目名称
     * 假如设置 "/index" ，访问这个方法将:  http://localhost:8080/web-front/index  即可方法这个方法。
     * produces 属性 指定返回的内容类型
     * 两层含义
     * request 请求头中 Accept Head 中包含了 produces 设定值才处理
     * 返回客户端内容类型是 produces 指定的类型。
     */
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "text/html")
    public String printWelcome(ModelMap model, HttpServletRequest request) {
        System.out.println(request.getMethod());
        model.addAttribute("msg", "Spring 3 MVC Hello World");
        //返回默认视图名称
        return "hello";

    }

    /**
     * 测试 produces = application/json;charset=UTF-8 ; 客户端获取到json数据，</p>
     * 一开始有一个小插曲，因为没有配置json 和javaBean 的映射器造成浏览器访问获取不到json数据。 设置 jackson 依赖后并并配置springmvc配置文件
     * 配置好后就可以返回这个javabean给浏览器了。并且 访问 /produces 并不需要jsp 这些视图啥的
     *
     * @param request
     * @param map
     * @return
     */
    @RequestMapping(value = "/produces", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Penson testProduces(HttpServletRequest request, ModelMap map) {
        Penson penson = new Penson();
        Address address = new Address();
        address.setCity("ganzhou");
        address.setProvince("jiangxi");
        penson.setAddress(address);
        penson.setName("vincent");
        penson.setAge((short) 25);
        return penson;
    }


    /**
     * RequestMapping注解的 method方法 ，如果一个请求/响应方法 没有设置 method 属性，
     * 该方法将影响所有HTTP请求方法 GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE，
     * 设置后将只可以响应指定的请求。
     *
     * @param request
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/method")
    public ModelAndView getMethod(HttpServletRequest request, ModelMap modelMap) {
        ModelAndView view = new ModelAndView();
        /** 页面访问/method页面， 跳转到另外一个jsp 页面（test/method） */
        view.setViewName("test/method");
        System.out.println(request.getMethod());
        view.addObject("method", request.getMethod());
        return view;
    }

    /**
     * 测试 RequestMapping 注解的 consumes 属性，该属性指定
     * 只处理 指定提交内容类型的 </p>
     * 该案例中指定 客户端 Headers 必须有这个头：Content-Type:text/html
     * 这个案例在postman测试成功，但在浏览器没有成功，不知道怎么在浏览器中设置HTTP请求头
     * 注意： 改响应方法不在浏览器中成功响应。
     *
     * @param request
     * @param map
     * @return
     */
    @RequestMapping(value = "/consumes", consumes = "text/html")
    public ModelAndView testConsumes(HttpServletRequest request, ModelMap map) {

        ModelAndView view = new ModelAndView();
        view.setViewName("test/consumes");
        String consumes = request.getContentType();
        /** consumes 属性 测试  */
        System.out.println(consumes);
        view.addObject("consumes", consumes);
        return view;
    }

    /**
     * 客户端传输 json 数据过来。暂时这个方法有问题。
     * Failed to read HTTP message: org.springframework.http.converter.HttpMessageNotReadableException:
     * Could not read document: Can not deserialize instance of java.lang.String out of START_OBJECT token
     *
     * @param request
     * @param json
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/consumes/json", consumes = "application/json")
    @ResponseBody
    public ModelAndView consumes(HttpServletRequest request, @RequestBody String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        // 反序列化
        Penson penson = mapper.readValue(json, Penson.class);
        ModelAndView view = new ModelAndView();
        view.setViewName("test/consumes");
        System.out.println(penson);
        view.addObject("consumes", penson.toString());
        return view;
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
