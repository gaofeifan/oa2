package com.pj.config.base.constant;

/**
 * @author GFF
 * @date 2017年6月22日下午6:34:18
 * @version 1.0.0
 * @parameter
 * @since 1.8
 */
public enum NotificationType {
	INITIATE(0, "发起通知"), 
	APPROVAL(1, "审批通知");

	private int value;
	private String desc;

	public static NotificationType getEnum(int value) {
		for (NotificationType orderType : values()) {
			if (orderType.value == value) {
				return orderType;
			}
		}
		return null;
	}

	private NotificationType(int value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
