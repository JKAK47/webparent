package org.vincent.web.util.xml;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.regex.Matcher;
import javax.xml.bind.JAXBException;
import org.junit.Assert;
import org.junit.Test;
import org.vincent.web.service.bean.Customer;
import org.vincent.web.util.FileUtils;


/**
 * Unit test for JAXBUtilsTest App.
 */
public class JAXBUtilsTest {
		/**
		 * 从XML文件里面读取数据并转成JavaBean 数据。
		 */
		@Test
		public void testUnmarshaller() throws JAXBException {
				URL url = ClassLoader.getSystemClassLoader().getResource("test/customer.xml");
				if (!(new File(url.getFile()).exists())) {
						Assert.fail("文件不存在");
				}
				Customer customer = JAXBUtils.Unmarshaller(Customer.class, url.getFile());
				System.out.println(customer);

		}

		/**
		 * 将JavaBean 数据转换为xml 数据并存放在xml 文件里面
		 *
		 * @throws JAXBException
		 */
		@Test
		public void testMarshaller() throws JAXBException, IOException {
				Customer customer = new Customer();
				customer.setCustomerAge(35);
				customer.setId("124569");
				customer.setName("GAGA");
				/**
				 * test类的  /D:/Dev/WorkStation/IdeaProjects/webparent/webservice/target/test-classes/
				 */
				String baseDir = ClassLoader.getSystemClassLoader().getResource("").getFile();
				System.out.println(baseDir);
				/** file 就是一个文件 */
				File file = new File(baseDir, "test/customer-outpupt.xml");
				if (file.exists()) {
						file.delete();
				}
				System.out.println(Arrays.asList(new File(baseDir).list()));
				/**
				 * 给定File 实例，不管是文件夹字符串还是文件字符串，我们需要将不存在的目录和文件创建
				 */
				FileUtils.touchFile(file);
				URL url = ClassLoader.getSystemClassLoader().getResource("test/customer-outpupt.xml");
				System.out.println(url.getFile());
				JAXBUtils.Marshaller(customer, url.getFile());
				String[] str = "19630000$19640000".split(Matcher.quoteReplacement("$"));
				for (String A : str) {
						System.out.println(A);
				}
				/**
				 * 返回的结果是 \\\s
				 * */
				System.out.println(Matcher.quoteReplacement("\\$"));
				/**
				 * 返回的是 asd-?
				 *
				 * */
				System.out.println(Matcher.quoteReplacement("asd-?"));
				/**
				 * Matcher.quoteReplacement 方法是 如果 入参如果没有 \,$ 两个字符，就原样返回；
				 * 如果有这两个字符，对这两个字符的前面添加转义字符 \
				 * 变成 \\,\$ 两种形式。
				 */

				str = "oboo:and:fooy".split("o");

				System.out.println("$".indexOf('\\'));
				System.out.println("$".indexOf('$'));
		}


}
