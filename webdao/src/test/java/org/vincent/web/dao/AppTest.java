package org.vincent.web.dao;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Unit test for simple App.
 */
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration(locations = { "classpath:spring/ApplicationContext.xml" })
public class AppTest extends AbstractJUnit4SpringContextTests
{
    @Autowired
    private  DruidDataSource dataSource ;
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;
    /**
     * 测试 数据库连接池 数据源，SessionTemplate 模板实例是否可以获取以及，查询 SELECT  1 FROM  dual;
     */
    @Test
    public void shouldAnswerWithTrue() throws SQLException {
        Assert.assertNotNull(dataSource);
        Assert.assertNotNull(sqlSessionTemplate);
        DruidPooledConnection connection= dataSource.getConnection();
        PreparedStatement statement= connection.prepareStatement("SELECT  1 FROM  dual;");
        ResultSet set= statement.executeQuery();
        while (set.next()){
             System.out.println( set.getInt(1));
        }



    }
}
