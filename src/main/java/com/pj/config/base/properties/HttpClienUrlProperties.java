package com.pj.config.base.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *	@author		GFF
 *	@date		2017年6月6日下午5:55:26
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@Component
public class HttpClienUrlProperties {

	@Value("${sso.create.url}")
	private String ssoCreateUrl;
	
	@Value("${sso.update.url}")
	private String ssoUpdateUrl;

	public String getSsoCreateUrl() {
		return ssoCreateUrl;
	}

	public String getSsoUpdateUrl() {
		return ssoUpdateUrl;
	}
}
