package org.vincent.web.util.xml;

import org.junit.Assert;
import org.junit.Test;
import org.vincent.web.service.bean.Customer;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.net.URL;


/**
 * Unit test for JAXBUtilsTest App.
 */
public class JAXBUtilsTest
{
    /**
     * 从XML文件里面读取数据并转成JavaBean 数据。
     *
     */
    @Test
    public void testUnmarshaller() throws JAXBException {
        URL url =ClassLoader.getSystemClassLoader().getResource("test/customer.xml");
        if (!(new File(url.getFile()).exists())){
            Assert.fail("文件不存在");
        }
        Customer customer=JAXBUtils.Unmarshaller(Customer.class,url.getFile());
        System.out.println(customer);

    }

    @Test
    public  void  testMarshaller() throws JAXBException {
        Customer customer=new Customer();
        customer.setCustomerAge(35);
        customer.setId("124569");
        customer.setName("GAGA");
        /** test类的  /D:/Dev/WorkStation/IdeaProjects/webparent/webservice/target/test-classes/*/
        System.out.println(ClassLoader.getSystemClassLoader().getResource("").getFile());
        URL url =ClassLoader.getSystemClassLoader().getResource("test/customer-outpupt.xml");
        System.out.println(url.getFile());
        JAXBUtils.Marshaller(customer,url.getFile());
    }


}
