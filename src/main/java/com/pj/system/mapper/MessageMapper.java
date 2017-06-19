package com.pj.system.mapper;

import java.util.List;

import com.pj.system.pojo.Message;
import com.pj.system.pojo.MessageQuery;

public interface MessageMapper {

    int insert(Message record);

    int insertSelective(Message record);

    List<Message> selectByExample(MessageQuery example);

    Message selectByPrimaryKey(Integer id);

    /**
     * 更新为已读状态
     * @param record
     * @return
     */
    int updateIsreadByPrimaryKey(Message message);

    //	根据type与登录用户获取消息
	List<Message> selectMessageByUserIdAndType(Message message);
}