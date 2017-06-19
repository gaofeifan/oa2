package com.pj.system.pojo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pj.utils.enums.MessageType;

import io.swagger.annotations.ApiModelProperty;

public class Message implements Serializable {
	
	@ApiModelProperty(value = "id", required = false)
	private Integer id;

    @ApiModelProperty(value = "用户id", required = false)
    private Integer userId;

    @ApiModelProperty(value = "通知类型", required = false)
    private String type;

    @ApiModelProperty(value = "通知内容", required = false)
    private String content;

    @ApiModelProperty(value = "通知标题", required = false)
    private String title;

    @ApiModelProperty(value = "是否已读  0 未读  1 已读", required = false)
    private Integer isread;
    @ApiModelProperty(value = "发送时间", required = false)
    private Date date;

    @ApiModelProperty(value = "申请单号", required = false)
    private String applyNumber;

    @ApiModelProperty(value = "消息中的用户名称", required = false)
    private String username;
    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getTitle() {
    	if(type.equals(MessageType.ENTRY_MES.getValue())){
    		return "【"+ MessageType.ENTRY_MES.getDesc() +"】";
    	}else if(type.equals(MessageType.DIMISSION_MES.getValue())){
    		return "【"+ MessageType.DIMISSION_MES.getDesc() +"】";
    	}else if(type.equals(MessageType.REGULAR_MES.getValue())){
    		return "【"+ MessageType.REGULAR_MES.getDesc() +"】";
    	}else if(type.equals(MessageType.CHANGE_MES.getValue())){
    		return "【"+ MessageType.CHANGE_MES.getDesc() +"】";
    	}else if(type.equals(MessageType.LEAVE_MES.getValue())){
    		return "【"+ MessageType.LEAVE_MES.getDesc() +"】";
    	}else if(type.equals(MessageType.RENEW_MES.getValue())){
    		return "【"+ MessageType.RENEW_MES.getDesc() +"】";
    		
    	}
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getIsread() {
        return isread;
    }

    public void setIsread(Integer isread) {
        this.isread = isread;
    }
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8") 
    public Date getDate() {
    	return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

	public String getApplyNumber() {
		return applyNumber;
	}

	public void setApplyNumber(String applyNumber) {
		this.applyNumber = applyNumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", type=").append(type);
        sb.append(", content=").append(content);
        sb.append(", title=").append(title);
        sb.append(", isread=").append(isread);
        sb.append(", date=").append(date);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}