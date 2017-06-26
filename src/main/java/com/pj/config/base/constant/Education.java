package com.pj.config.base.constant;

/**
 * 项目名称：oa   
 * 类名称：EducationConstant   
 * 类描述：学历枚举类   
 * 创建人：limr   
 * 创建时间：2017年6月21日 上午10:21:51   
 * 修改人：limr   
 * 修改时间：2017年6月21日 上午10:21:51
 * 修改备注：   
 * @version    
 *
 */
public enum Education {

	HIGH("高中及以上", 1),
	ZK("专科及以上", 2),
	BK("本科及以上", 3),
	MASTER("硕士及以上", 4),
	DR("博士及以上", 5);

	private String educationName ;
	private int education;
	
	private Education(String educationName, int education) {
		this.educationName = educationName;
		this.education = education;
	}
	public String getEducationName() {
		return educationName;
	}
	public void setEducationName(String educationName) {
		this.educationName = educationName;
	}
	public int getEducation() {
		return education;
	}
	public void setEducation(int education) {
		this.education = education;
	}
	
    
}
