package com.pj;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 *	@author		GFF
 *	@date		2017年6月27日下午3:14:26
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath:spring-config.xml"})
public abstract class BaseTest {

}
