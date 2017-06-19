package com.pj.utils.enums;

public enum CheckStatus {
	//审批状态1、同意；2、审批中；3、不同意  4 未处理
		AGREE(1,"同意"),
		IN_APPROVE(2,"审批中"),
		NO_AGREE(3,"不同意"),
		NO_HANDLE(4,"未处理"),
		BACK(5,"驳回");
		
		private int value;
		private String desc;
		
		public static CheckStatus getEnum(int value){
			for(CheckStatus orderType:values() ){
				if(orderType.value == value){
					return orderType;
				}
			}
			return null;
		}
		
		private CheckStatus(int value, String desc) {
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
