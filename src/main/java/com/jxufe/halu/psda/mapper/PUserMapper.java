package com.jxufe.halu.psda.mapper;

import com.jxufe.halu.psda.pojo.PUser;

public interface PUserMapper {
    int deleteByPrimaryKey(String userid);

    int insert(PUser record);

    int insertSelective(PUser record);

    PUser selectByPrimaryKey(String userid);

    int updateByPrimaryKeySelective(PUser record);

    int updateByPrimaryKey(PUser record);
}