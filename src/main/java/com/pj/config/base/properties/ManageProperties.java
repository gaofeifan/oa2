package com.pj.config.base.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *	@author		GFF
 *	@date		2017年6月7日上午11:12:04
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@Component
public class ManageProperties {

	@Autowired
	public FtpProperties ftpProperties;
	@Autowired
	public HttpClienUrlProperties httpClienUrlProperties;
	
}
