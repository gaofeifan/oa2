package com.pj.config.base.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *	@author		GFF
 *	@date		2017年6月6日下午6:11:16
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
@Component
public class FtpProperties {

	@Value("${ftp.url}")
	private String url;
	
	@Value("${ftp.username}")
	private String username;
	
	@Value("${ftp.password}")
	private String password;
	
	@Value("${ftp.port}")
	private String port;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	
}
