package org.vincent.web.facade; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import org.slf4j.Logger;

/** 
* LoggerFactory Tester. 
* 
* @author <PengRong> 
* @since  
* @version 1.0 
*/ 
public class LoggerFactoryTest { 

@Before
public void before() throws Exception {
		System.out.println("begin log test");
} 

@After
public void after() throws Exception {
		System.out.println("stop log test");
} 

/** 
* 
* Method: getLogger() 
* 
*/ 
@Test
public void testGetLogger() throws Exception { 
 Logger logger =LoggerFactory.getLogger();
 logger.debug("lfsdjf");
 logger.info("sldkfjsaldkfj");
 logger.error("alfkjasldkfjalsdkj");
} 


} 
