package com.pj.system.pojo;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class Record implements Serializable {
	@ApiModelProperty(value = "id", required = false)
	private Integer id;

    /**
     * 操作人名称
     */
	@ApiModelProperty(value = "操作人名称", required = false)
    private String name;

    /**
     * 操作内容
     */
	@ApiModelProperty(value = "操作内容", required = false)
    private String content;

    /**
     * 操作时间
     */
	@ApiModelProperty(value = "操作时间", required = false)
    private Date handledate;

    /**
     * 消息id
     */
	@ApiModelProperty(value = "消息id", required = false)
    private Integer messageid;

    /**
     * 用户的id
     */
	@ApiModelProperty(value = "用户的id", required = false)
    private Integer userid;

    /**
     * 是否已被查看 0未查看 1已
     */
	@ApiModelProperty(value = "是否已被查看 0未查看 1已", required = false)
    private Integer isfind;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public Integer getUserid() {
		return userid;
	}

	public Integer getMessageid() {
		return messageid;
	}

	public void setMessageid(Integer messageid) {
		this.messageid = messageid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getIsfind() {
		return isfind;
	}

	public void setIsfind(Integer isfind) {
		this.isfind = isfind;
	}

	public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getHandledate() {
        return handledate;
    }

    public void setHandledate(Date handledate) {
        this.handledate = handledate;
    }

	@Override
	public String toString() {
		return "Record [id=" + id + ", name=" + name + ", content=" + content + ", handledate=" + handledate
				+ ", messageid=" + messageid + ", userid=" + userid + ", isfind=" + isfind + "]";
	}

}