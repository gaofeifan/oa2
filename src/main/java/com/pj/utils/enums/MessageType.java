package com.pj.utils.enums;

public enum MessageType {
	//审批状态1,入职，4，转正，5，异动，2，离职，6，续签  3  请假
		ENTRY_MES("1","入职"),
		REGULAR_MES("4","转正"),
		CHANGE_MES("5","异动"),
		DIMISSION_MES("2","离职"),
		LEAVE_MES("3","请假"),
		RENEW_MES("6","续签");
		
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
