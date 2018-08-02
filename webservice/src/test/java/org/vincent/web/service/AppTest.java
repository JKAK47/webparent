package org.vincent.web.service;

import org.junit.Test;
import org.slf4j.Logger;
import org.vincent.web.util.logging.LoggerFactory;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
         System.out.println(System.getProperty("user.home"));
        assertTrue( true );
        Logger logger= LoggerFactory.getLogger();
        logger.info("sldfkjasd");
        logger.debug("sldfkjasd");
        logger.error("sldfkjasd");


    }
}
