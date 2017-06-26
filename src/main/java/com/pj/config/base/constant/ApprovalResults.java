package com.pj.config.base.constant;

public enum ApprovalResults {
	//审批状态0、审批中  1 不同意   2同意
		UNTREATED(0,"审批中"),
		NO_AGREE(1,"不同意"),
		AGREE(2,"同意");
		
		private int value;
		private String desc;
		
		public static ApprovalResults getEnum(int value){
			for(ApprovalResults orderType:values() ){
				if(orderType.value == value){
					return orderType;
				}
			}
			return null;
		}
		
		private ApprovalResults(int value, String desc) {
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
