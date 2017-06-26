package com.pj.config.base.constant;

public enum MessageType {
	//审批状态1 招聘，2 入职
		ENTRY_MES("2","入职申请"),
		RECRUITMENT_MES("1","招聘申请");
		
		private String value;
		private String desc;
		
		public static MessageType getEnum(String value){
			for(MessageType orderType:values() ){
				if(orderType.value.equals(value)){
					return orderType;
				}
			}
			return null;
		}
		
		private MessageType(String value, String desc) {
			this.value = value;
			this.desc = desc;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}
}
