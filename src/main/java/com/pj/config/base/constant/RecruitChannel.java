package com.pj.config.base.constant;

/**
 * 项目名称：oa   
 * 类名称：RecruitChannelConstant   
 * 类描述：招聘渠道枚举类
 * 创建人：limr   
 * 创建时间：2017年6月21日 上午9:59:36   
 * 修改人：limr   
 * 修改时间：2017年6月21日 上午9:59:36   
 * 修改备注：   
 * @version    
 *
 */
public enum RecruitChannel {

	OUTSIDE("外部招聘", 1),
	INSIDE("内部竞聘", 2),
	RECOMMEND("内部推荐", 3),
	HEADHUNTER("猎头", 4); 
	
	private String channelName ;
	private int channel;
	private RecruitChannel(String channelName, int channel) {
		this.channel = channel;
		this.channelName = channelName;
	}
	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	public int getChannel() {
		return channel;
	}
	public void setChannel(int channel) {
		this.channel = channel;
	}
	
}
