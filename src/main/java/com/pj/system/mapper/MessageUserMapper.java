package com.pj.system.mapper;

import com.pj.system.pojo.MessageUser;

public interface MessageUserMapper {

    int insertSelective(MessageUser MessageUser);

    MessageUser selectByPrimaryKey(Integer id);
}