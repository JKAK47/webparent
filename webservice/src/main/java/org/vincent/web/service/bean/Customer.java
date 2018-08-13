package org.vincent.web.service.bean;

import javax.xml.bind.annotation.*;

/**
 *
 *
 * <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
 *  <customer id="100">
 *      <age>29</age>
 *      <name>mkyong</name>
 *  </customer>
 *
 *
 * <p> Created by PengRong on 2018/8/13.</p>
 * <p> XmlRootElement 注解标识xml 中 节点元素，name 属性设置的名称 必须是xml元素 名称一致。 </p>
 * <p> XmlType 注解标识 javaBean 转xml 时候标签的输出顺序， name 属性设置并不需要和  XmlRootElement 元素 name 属性一致；
 *      proOrder属性 标识了xml元素输出顺序
 * </p>
 * <p> XmlAttribute 注解标识id 是 变量是customer 这个xml 元素的 属性。</p>
 * <p> XmlElement 注解标识 改变量是customer 这个xml 元素的子节点。</p>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "custormer", propOrder = {"id","name","customerAge"})
@XmlRootElement(name = "customer")
public class Customer {

    @XmlAttribute(name = "id")
    private  String id;
    @XmlElement(name = "name")
    private  String name;
    @XmlElement(name = "age")
    private  int customerAge;

    public int getCustomerAge() {
        return customerAge;
    }

    public void setCustomerAge(int customerAge) {
        this.customerAge = customerAge;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", customerAge=" + customerAge +
                '}';
    }
}
