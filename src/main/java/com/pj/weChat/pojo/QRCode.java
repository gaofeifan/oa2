package com.pj.weChat.pojo;

public class QRCode {

	private String ticket;
	private String url;
	private Integer expire_seconds;
	private String action_name;
	private String action_info;
	private Integer scene_id;
	private Integer scene_str;
	public Integer getExpire_seconds() {
		return expire_seconds;
	}
	public void setExpire_seconds(Integer expire_seconds) {
		this.expire_seconds = expire_seconds;
	}
	public String getAction_name() {
		return action_name;
	}
	public void setAction_name(String action_name) {
		this.action_name = action_name;
	}
	public String getAction_info() {
		return action_info;
	}
	public void setAction_info(String action_info) {
		this.action_info = action_info;
	}
	public Integer getScene_id() {
		return scene_id;
	}
	public void setScene_id(Integer scene_id) {
		this.scene_id = scene_id;
	}
	public Integer getScene_str() {
		return scene_str;
	}
	public void setScene_str(Integer scene_str) {
		this.scene_str = scene_str;
	}
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
