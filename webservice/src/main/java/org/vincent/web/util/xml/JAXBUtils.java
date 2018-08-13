package org.vincent.web.util.xml;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

/**
 * Created by PengRong on 2018/8/13.
 *
 * @author PengRong
 *         基于JDK提供的 JAXB 库 基于注解进行xml 和JavaBean 之间 转换
 */
public class JAXBUtils {

    /**
     * 将XML 文件内容解析并映射到对应的JavaBean 并返回 </p>
     *
     * @param classT   解析Xml 映射到对应的javaBean类 Class 文件。</p>
     * @param filepath 需要解析的xml文件</p>
     * @param <T></p>
     * @return T </p>
     * @author PengRong </p>
     */
    public static <T> T Unmarshaller(Class<T> classT, String filepath) throws JAXBException {
        try {
            JAXBContext jc = JAXBContext.newInstance(classT);
            Unmarshaller u = jc.createUnmarshaller();
            return (T) u.unmarshal(new File(filepath));
        } catch (JAXBException e) {
            // logger.trace(e);
            throw e;
        }
    }

    /**
     * 将JavaBean 数据转成XML 存储
     *
     * @param data
     * @param filepath
     * @throws JAXBException
     */
    public static void Marshaller(Object data, String filepath) throws JAXBException {
        OutputStream outputStream = null;
        try {
            JAXBContext jc = JAXBContext.newInstance(data.getClass());
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            File file = new File(filepath);
            outputStream = new FileOutputStream(file);
            marshaller.marshal(data, outputStream);
            /** 刷新 */
            outputStream.flush();
            //marshaller.marshal(data,System.out);

        } catch (JAXBException e) {
            // logger.trace(e);
            throw e;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null)
                    outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
